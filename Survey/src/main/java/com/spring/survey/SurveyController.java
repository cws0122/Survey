package com.spring.survey;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dao.MemberDAOImpl;
import com.spring.service.MemberServiceImpl;
import com.spring.vo.MemberVO;
import com.spring.vo.Paging;
import com.spring.vo.SurquesVO;
import com.spring.vo.SurveyVO;

@Controller
public class SurveyController {
	
	@Inject
	private MemberServiceImpl service;
	
	private static final Logger logger = LoggerFactory.getLogger(SurveyController.class);

	@RequestMapping("/main.do")
	public String main() {
		System.out.println("����ȭ������");
		return "index";
	}
	
	@RequestMapping("/loginForm.do")
	public String loginForm() {
		System.out.println("�α��� ȭ������");
		return "etc/Login";
	}
	
	
	@RequestMapping("/login.do")
	public String login(MemberVO vo , Model model, HttpServletRequest request) {
		System.out.println("�α���");
		HttpSession session = request.getSession();
		MemberVO member = service.PwdCheck(vo);
		if(member != null) {
			session.setAttribute("member", member);
			return "redirect:main.do";
		}else {
			model.addAttribute("msg", "���̵� �� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			model.addAttribute("url" , "loginForm.do");
			return "alert";
		}
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		System.out.println("�α׾ƿ�");
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:main.do";
	}
	

	@RequestMapping("/surveyListForm.do")
	public String surveyForm(Model model, HttpServletRequest request) {
		System.out.println("�������� ����Ʈ�� �̵�");
		service.Paging(model, request);
		return "particiation/researchList";
	}
	
	@RequestMapping("/surveyWriteForm.do")
	public String surveyWriteForm(HttpServletRequest request , Model model) {
		System.out.println("�������� �ۼ� �������� �̵�");
		HttpSession session = request.getSession();
		if(session.getAttribute("member") == null) {
				model.addAttribute("msg" , "�α��� �� �̿����ּ���");
				model.addAttribute("url" , "loginForm.do");
			return "alert";
		}else {
			return "particiation/researchCreate";
		}
	}

	
	@RequestMapping("/insertSurvey.do")
	public String insertSurvey(SurveyVO vo , HttpServletRequest request) {
		System.out.println("�������� ���");
		service.insertSurvey(vo , request);
		return "redirect:surveyListForm.do";
	}
	
	@RequestMapping("/surveyDetail.do")
	public String surveyDetail(@RequestParam("seq") int seq , Model model) {
		System.out.println("�������� �������� �̵�");
		SurveyVO survey = service.surveyDetail(seq);
		List<SurquesVO> surquesList = service.surquesDetail(seq);
		model.addAttribute("survey" , survey);
		model.addAttribute("surquesList" , surquesList);
		return "particiation/NomalresearchView";
	}
	

	@RequestMapping("/result.do")
	public String Result(SurveyVO vo, HttpServletRequest request) {
		System.out.println("�������� ��� ����");
		service.insertResult(vo, request);
		return "redirect:surveyListForm.do";
	}
	
	
	@RequestMapping("/SurveyResultShow.do")
	public String SurveyResultShow(@RequestParam("seq") int seq , Model model) {
		SurveyVO survey = service.surveyDetail(seq);
		service.getResult(seq, survey);
		List<SurquesVO> surquesList = service.surquesDetail(seq);
		model.addAttribute("survey" , survey);
		model.addAttribute("surquesList" , surquesList);
		return "particiation/researchPopup";
	}
	
	
	
	
	
	
}

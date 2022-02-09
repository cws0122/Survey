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
		System.out.println("메인화면으로");
		return "index";
	}
	
	@RequestMapping("/loginForm.do")
	public String loginForm() {
		System.out.println("로그인 화면으로");
		return "etc/Login";
	}
	
	
	@RequestMapping("/login.do")
	public String login(MemberVO vo , Model model, HttpServletRequest request) {
		System.out.println("로그인");
		HttpSession session = request.getSession();
		MemberVO member = service.PwdCheck(vo);
		if(member != null) {
			session.setAttribute("member", member);
			return "redirect:main.do";
		}else {
			model.addAttribute("msg", "아이디 및 비밀번호가 틀렸습니다.");
			model.addAttribute("url" , "loginForm.do");
			return "alert";
		}
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		System.out.println("로그아웃");
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:main.do";
	}
	

	@RequestMapping("/surveyListForm.do")
	public String surveyForm(Model model, HttpServletRequest request) {
		System.out.println("설문조사 리스트로 이동");
		service.Paging(model, request);
		return "particiation/researchList";
	}
	
	@RequestMapping("/surveyWriteForm.do")
	public String surveyWriteForm(HttpServletRequest request , Model model) {
		System.out.println("설문조사 작성 페이지로 이동");
		HttpSession session = request.getSession();
		if(session.getAttribute("member") == null) {
				model.addAttribute("msg" , "로그인 후 이용해주세요");
				model.addAttribute("url" , "loginForm.do");
			return "alert";
		}else {
			return "particiation/researchCreate";
		}
	}

	
	@RequestMapping("/insertSurvey.do")
	public String insertSurvey(SurveyVO vo , HttpServletRequest request) {
		System.out.println("설문조사 등록");
		service.insertSurvey(vo , request);
		return "redirect:surveyListForm.do";
	}
	
	@RequestMapping("/surveyDetail.do")
	public String surveyDetail(@RequestParam("seq") int seq , Model model) {
		System.out.println("설문조사 페이지로 이동");
		SurveyVO survey = service.surveyDetail(seq);
		List<SurquesVO> surquesList = service.surquesDetail(seq);
		model.addAttribute("survey" , survey);
		model.addAttribute("surquesList" , surquesList);
		return "particiation/NomalresearchView";
	}
	

	@RequestMapping("/result.do")
	public String Result(SurveyVO vo, HttpServletRequest request) {
		System.out.println("설문조사 결과 삽입");
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

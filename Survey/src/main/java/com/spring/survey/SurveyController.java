package com.spring.survey;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.service.MemberServiceImpl;
import com.spring.vo.MemberVO;

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
	
	@RequestMapping("/idCheck.do")
	public String idCheck(MemberVO vo, Model model) {
		System.out.println("아이디 확인 과정");
		if(service.idCheck(vo) != null) {
			model.addAttribute("member" , vo);
			return "etc/Password";
		}else {
			return "etc/Login";
		}	
	}
	
	@RequestMapping("/login.do")
	public String login(MemberVO vo , Model model, HttpServletRequest request) {
		System.out.println("로그인");
		HttpSession session = request.getSession();
		MemberVO member = service.PwdCheck(vo);
		session.setAttribute("member", member);
		return "redirect:main.do";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		System.out.println("로그아웃");
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:main.do";
	}
	

	@RequestMapping("/surveyListForm.do")
	public String surveyForm() {
		System.out.println("설문조사 리스트로 이동");
		return "particiation/researchList";
	}
	
	
	
	
	
	
	
	
	
	
	
}

package com.spring.survey;

import javax.inject.Inject;

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
			return "etc/Password";
		}else {
			return "etc/Login";
		}
		
	}
	
}

package com.spring.survey;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
		System.out.println("����ȭ������");
		return "index";
	}
	
	@RequestMapping("/loginForm.do")
	public String loginForm() {
		System.out.println("�α��� ȭ������");
		return "etc/Login";
	}
	
	@RequestMapping("/idCheck.do")
	public String idCheck(MemberVO vo) {
		System.out.println("���̵� Ȯ�� ����");
		service.idCheck(vo);
		return "etc/Login";
	}
	
}

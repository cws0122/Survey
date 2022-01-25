package com.spring.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.MemberDAOImpl;
import com.spring.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	private MemberDAOImpl dao;
	
	public MemberVO idCheck(MemberVO vo) {
		MemberVO member = null;
		if(dao.idCheck(vo) != null) {
			member = dao.idCheck(vo);
		}else {
			System.out.println("일치하지 않는 아이디이다.");
		}
		return member;
	}
}	

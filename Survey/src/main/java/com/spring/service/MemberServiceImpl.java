package com.spring.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.MemberDAOImpl;
import com.spring.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	private MemberDAOImpl dao;
	
	public void idCheck(MemberVO vo) {
		System.out.println(dao.idCheck(vo));
	}
}	

package com.spring.dao;

import com.spring.vo.MemberVO;

public interface MemberDAO {
	public MemberVO idCheck(MemberVO vo);
	public MemberVO PwdCheck(MemberVO vo);
}	

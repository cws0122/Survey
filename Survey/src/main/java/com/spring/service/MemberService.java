package com.spring.service;

import com.spring.vo.MemberVO;

public interface MemberService {
	public MemberVO idCheck(MemberVO vo);
	public MemberVO PwdCheck(MemberVO vo);
}

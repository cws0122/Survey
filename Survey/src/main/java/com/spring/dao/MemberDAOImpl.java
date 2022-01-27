package com.spring.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	public MemberVO idCheck(MemberVO vo) {
		return sqlSession.selectOne("memberDAO.idCheck", vo);
	}

	@Override
	public MemberVO PwdCheck(MemberVO vo) {
		return sqlSession.selectOne("memberDAO.PwdCheck" , vo);
	}

}

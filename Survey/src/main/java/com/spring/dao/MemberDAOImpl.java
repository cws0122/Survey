package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.vo.MemberVO;
import com.spring.vo.SurquesVO;
import com.spring.vo.SurveyVO;

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

	@Override
	public void insertSurvey(SurveyVO vo) {
		sqlSession.insert("surveyDAO.insertSurvey" , vo);
	}

	@Override
	public List<SurveyVO> SurveyList() {
		return sqlSession.selectList("surveyDAO.surveyList");
	}

	@Override
	public void insertSurques(SurquesVO vo) {
		sqlSession.insert("surveyDAO.insertSurques", vo);
	}

	@Override
	public int maxseq() {
		return sqlSession.selectOne("surveyDAO.maxseq");
	}

	@Override
	public SurveyVO surveyDetail(int seq) {
		return sqlSession.selectOne("surveyDAO.surveyDetail" , seq);
	}

	@Override
	public List<SurquesVO> surquesDetail(int seq) {
		return sqlSession.selectList("surveyDAO.surquesDetail", seq);
	}

}

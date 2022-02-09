package com.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.vo.MemberVO;
import com.spring.vo.SurquesVO;
import com.spring.vo.SurveyVO;
import com.spring.vo.SurveyresultVO;

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

	@Override
	public void insertResult(SurveyresultVO vo) {
		sqlSession.insert("surveyDAO.insertResult", vo);
	}

	@Override
	public int getAllCount() {
		return sqlSession.selectOne("surveyDAO.getAllCount");
	}

	@Override
	public List<SurveyVO> SurveyListPaging(int cPage, int numPerPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cPage", cPage);
		map.put("numPerPage", numPerPage);
		return sqlSession.selectList("surveyDAO.SurveyListPaging", map);
	}

	@Override
	public int getResult(int surseq, int quesnum, int answer) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("surseq", surseq);
		map.put("quesnum", quesnum);
		map.put("answer", answer);
		return sqlSession.selectOne("surveyDAO.getResult" , map);
	}

	@Override
	public void AnswerCount1(int count, int surveyseq, int quesnum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("surveyseq", surveyseq);
		map.put("quesnum", quesnum);
		sqlSession.update("surveyDAO.AnswerCount1" , map);
	}

	@Override
	public void AnswerCount2(int count, int surveyseq, int quesnum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("surveyseq", surveyseq);
		map.put("quesnum", quesnum);
		sqlSession.update("surveyDAO.AnswerCount2" , map);
	}

	@Override
	public void AnswerCount3(int count, int surveyseq, int quesnum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("surveyseq", surveyseq);
		map.put("quesnum", quesnum);
		sqlSession.update("surveyDAO.AnswerCount3" , map);
	}

	@Override
	public void AnswerCount4(int count, int surveyseq, int quesnum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("surveyseq", surveyseq);
		map.put("quesnum", quesnum);
		sqlSession.update("surveyDAO.AnswerCount4" , map);
	}

	@Override
	public void AnswerCount5(int count, int surveyseq, int quesnum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("surveyseq", surveyseq);
		map.put("quesnum", quesnum);
		sqlSession.update("surveyDAO.AnswerCount5" , map);
	}


}

package com.spring.dao;

import java.util.List;

import com.spring.vo.MemberVO;
import com.spring.vo.SurquesVO;
import com.spring.vo.SurveyVO;
import com.spring.vo.SurveyresultVO;

public interface MemberDAO {
	public MemberVO idCheck(MemberVO vo);
	public MemberVO PwdCheck(MemberVO vo);
	public void insertSurvey(SurveyVO vo);
	public List<SurveyVO> SurveyList();
	public void insertSurques(SurquesVO vo);
	public int maxseq();
	public SurveyVO surveyDetail(int seq);
	public List<SurquesVO> surquesDetail(int seq);
	public void insertResult(SurveyresultVO vo);
	public int getAllCount();
	public List<SurveyVO> SurveyListPaging(int cPage, int numPerPage);
	public int getResult(int surseq, int quesnum, int answer);
	public void AnswerCount1(int count, int surveyseq, int quesnum);
	public void AnswerCount2(int count, int surveyseq, int quesnum);
	public void AnswerCount3(int count, int surveyseq, int quesnum);
	public void AnswerCount4(int count, int surveyseq, int quesnum);
	public void AnswerCount5(int count, int surveyseq, int quesnum);
}	

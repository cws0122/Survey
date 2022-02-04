package com.spring.dao;

import java.util.List;

import com.spring.vo.MemberVO;
import com.spring.vo.SurquesVO;
import com.spring.vo.SurveyVO;

public interface MemberDAO {
	public MemberVO idCheck(MemberVO vo);
	public MemberVO PwdCheck(MemberVO vo);
	public void insertSurvey(SurveyVO vo);
	public List<SurveyVO> SurveyList();
	public void insertSurques(SurquesVO vo);
	public int maxseq();
	public SurveyVO surveyDetail(int seq);
	public List<SurquesVO> surquesDetail(int seq);
}	

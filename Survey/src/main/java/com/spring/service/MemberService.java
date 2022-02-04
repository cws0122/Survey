package com.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spring.vo.MemberVO;
import com.spring.vo.SurquesVO;
import com.spring.vo.SurveyVO;

public interface MemberService {
	public MemberVO idCheck(MemberVO vo);
	public MemberVO PwdCheck(MemberVO vo);
	public void insertSurvey(SurveyVO vo , HttpServletRequest request);
	public List<SurveyVO> SurveyList();
	public SurveyVO surveyDetail(int seq);
	public List<SurquesVO> surquesDetail(int seq);
}

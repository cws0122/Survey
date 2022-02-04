package com.spring.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.spring.dao.MemberDAOImpl;
import com.spring.vo.MemberVO;
import com.spring.vo.SurquesVO;
import com.spring.vo.SurveyVO;

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

	@Override
	public MemberVO PwdCheck(MemberVO vo) {
		MemberVO member = dao.PwdCheck(vo);
		return member;
	}

	@Override
	public void insertSurvey(SurveyVO vo , HttpServletRequest request) {
		dao.insertSurvey(vo);
		SurquesVO surques = new SurquesVO();
		int num = 0;
		int seq = dao.maxseq();
		surques.setSurveyseq(seq);
		String[] question = request.getParameterValues("question");
		String[] answer1 = request.getParameterValues("answer1");
		String[] answer2 = request.getParameterValues("answer2");
		String[] answer3 = request.getParameterValues("answer3");
		String[] answer4 = request.getParameterValues("answer4");
		String[] answer5 = request.getParameterValues("answer5");
		for(int i=0; i<question.length; i++) {
			surques.setQuesnum(i + 1);
			surques.setQuestion(question[i]);
			surques.setAnswer1(answer1[i]);
			surques.setAnswer2(answer2[i]);
			surques.setAnswer3(answer3[i]);
			surques.setAnswer4(answer4[i]);
			surques.setAnswer5(answer5[i]);
			dao.insertSurques(surques);
		}
	}

	@Override
	public List<SurveyVO> SurveyList() {
		List<SurveyVO> surveyList = dao.SurveyList();
		return surveyList;
	}

	@Override
	public SurveyVO surveyDetail(int seq) {
		SurveyVO survey = dao.surveyDetail(seq);
		return survey;
	}

	@Override
	public List<SurquesVO> surquesDetail(int seq) {
		List<SurquesVO> surquesList = dao.surquesDetail(seq);
		return surquesList;
	}
}	

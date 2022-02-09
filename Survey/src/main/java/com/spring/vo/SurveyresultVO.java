package com.spring.vo;

public class SurveyresultVO {
	private int seq, quesnum, surseq;
	private String answer, reason;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getSurseq() {
		return surseq;
	}
	public void setSurseq(int surseq) {
		this.surseq = surseq;
	}
	public int getQuesnum() {
		return quesnum;
	}
	public void setQuesnum(int quesnum) {
		this.quesnum = quesnum;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}

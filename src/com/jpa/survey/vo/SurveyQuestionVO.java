package com.jpa.survey.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.jpa.survey.entity.QuestionOption;
import com.jpa.survey.entity.SurveyQuestion;

public class SurveyQuestionVO {

	private long questionId;
	private String questionText;
	private int questionTypeId;
	private List<QuestionOptionVO> QuestionOptionVOs;

	public SurveyQuestionVO(SurveyQuestion surveyQuestion) {
		this.questionId=surveyQuestion.getQuestionId();
		this.questionText=surveyQuestion.getQuestionText();
		this.questionTypeId=surveyQuestion.getQuestionTypeId();
		this.QuestionOptionVOs=new ArrayList<QuestionOptionVO>();
		Collection<QuestionOption> options = surveyQuestion.getQuestionOptions();
		for(QuestionOption option:options){
			QuestionOptionVO optionVO = new QuestionOptionVO(option);
			this.QuestionOptionVOs.add(optionVO);
		}
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public int getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(int questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public List<QuestionOptionVO> getQuestionOptionVOs() {
		return QuestionOptionVOs;
	}

	public void setQuestionOptionVOs(List<QuestionOptionVO> questionOptionVOs) {
		QuestionOptionVOs = questionOptionVOs;
	}

	
}

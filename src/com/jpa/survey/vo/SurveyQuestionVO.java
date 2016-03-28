package com.jpa.survey.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jpa.survey.entity.QuestionOption;
import com.jpa.survey.entity.SurveyQuestion;
import com.jpa.util.QuestionTypeUtil;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SurveyQuestionVO {

	@JsonIgnore
	private long questionId;
	private String questionText;
	private String questionType;
	@JsonProperty("Options")
	private List<QuestionOptionVO> options;
	private int displpayOrder;
	
	public SurveyQuestionVO() {
		super();
	}

	public SurveyQuestionVO(SurveyQuestion surveyQuestion) {

		this.questionId = surveyQuestion.getQuestionId();
		this.questionText = surveyQuestion.getQuestionText();
		this.questionType = surveyQuestion.getSurveyQuestionType().getCode();

		Collection<QuestionOption> options = surveyQuestion
				.getQuestionOptions();
		if (options.size() > 0) {
			this.options = new ArrayList<QuestionOptionVO>();
			for (QuestionOption option : options) {
				QuestionOptionVO optionVO = new QuestionOptionVO(option);
				this.options.add(optionVO);
			}
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

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public List<QuestionOptionVO> getOptions() {
		return options;
	}

	public void setOptions(List<QuestionOptionVO> options) {
		this.options = options;
	}
	
	

	public int getDisplpayOrder() {
		return displpayOrder;
	}

	public void setDisplpayOrder(int displpayOrder) {
		this.displpayOrder = displpayOrder;
	}

	@JsonIgnore
	public SurveyQuestion getEntity() {
		SurveyQuestion surveyQuestion = new SurveyQuestion();
		surveyQuestion.setQuestionId(this.questionId);
		surveyQuestion.setQuestionText(this.questionText);
		surveyQuestion.setSurveyQuestionType(QuestionTypeUtil.getSurveyQuestionType(this.questionType));
		if(this.options!=null){
			ArrayList<QuestionOption> questionOptions=new ArrayList<QuestionOption>();
			for(QuestionOptionVO questionOptionVO : options){
				QuestionOption questionOption = questionOptionVO.getEntity();
				questionOption.setSurveyQuestion(surveyQuestion);
				questionOptions.add(questionOption);
			}
			surveyQuestion.setQuestionOptions(questionOptions);
		}
		return surveyQuestion;
	}
}

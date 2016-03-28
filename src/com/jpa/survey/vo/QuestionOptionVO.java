package com.jpa.survey.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jpa.survey.entity.QuestionOption;
import com.jpa.survey.entity.SurveyQuestion;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionOptionVO {

	@JsonIgnore
	private long optionId;
	private String optionText;
	private int optionOrder;
	@JsonProperty("triggerQuestion")
	private SurveyQuestionVO triggerQuestionVO;

	public QuestionOptionVO(){
		super();
	}
	public QuestionOptionVO(QuestionOption option) {
		this.optionId=option.getOptionId();
		this.optionText=option.getOptionText();
		this.optionOrder=option.getOptionOrder();
		SurveyQuestion trigerQuestion = option.getTriggerQuestion();
		if(trigerQuestion!=null){
			this.triggerQuestionVO=new SurveyQuestionVO(trigerQuestion);
		}
	}

	public long getOptionId() {
		return optionId;
	}

	public void setOptionId(long optionId) {
		this.optionId = optionId;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public int getOptionOrder() {
		return optionOrder;
	}

	public void setOptionOrder(int optionOrder) {
		this.optionOrder = optionOrder;
	}

	public SurveyQuestionVO getTriggerQuestionVO() {
		return triggerQuestionVO;
	}

	public void setTriggerQuestionVO(SurveyQuestionVO triggerQuestionVO) {
		this.triggerQuestionVO = triggerQuestionVO;
	}
	
	@JsonIgnore
	public QuestionOption getEntity() {
		QuestionOption option=new QuestionOption();
		option.setOptionId(this.optionId);
		option.setOptionText(this.optionText);
		option.setOptionOrder(this.optionOrder);
		if(this.triggerQuestionVO!=null){
			option.setTriggerQuestion(this.triggerQuestionVO.getEntity());
		}
		return option;
	}	

}

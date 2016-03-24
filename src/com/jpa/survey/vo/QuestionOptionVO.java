package com.jpa.survey.vo;

import com.jpa.survey.entity.QuestionOption;
import com.jpa.survey.entity.SurveyQuestion;

public class QuestionOptionVO {

	private long optionId;
	private String optionText;
	private int optionOrder;
	private SurveyQuestionVO triggerQuestionVO;

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

}

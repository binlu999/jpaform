package com.jpa.survey.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "QuestionOptions")
@Inheritance(strategy = InheritanceType.JOINED)
public class QuestionOption extends GenericEntity {

	@Id
	@Column(name = "OPTION_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long optionId;

	@Column(name = "QUESTION_ID")
	private long questionId;

	@Column(name = "OPTION_TEXT")
	private String optionText;

	@Column(name = "TRIGGER_FLAG")
	private boolean triggerFlag;

	@Column(name = "TRIGGER_QUESTION_ID")
	private long triggerQuestionId;

	@Column(name = "OPTION_ORDER")
	private int optionOrder;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.ALL })
	@JoinColumn(name = "QUESTION_ID")
	private SurveyQuestion surveyQuestion;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.ALL })
	@JoinColumn(name = "TRIGGER_QUESTION_ID", referencedColumnName = "QUESTION_ID")
	SurveyQuestion triggerQuestion;

	public long getOptionId() {
		return optionId;
	}

	public void setOptionId(long optionId) {
		this.optionId = optionId;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public boolean isTriggerFlag() {
		return triggerFlag;
	}

	public void setTriggerFlag(boolean triggerFlag) {
		this.triggerFlag = triggerFlag;
	}

	public long getTriggerQuestionId() {
		return triggerQuestionId;
	}

	public void setTriggerQuestionId(long triggerQuestionId) {
		this.triggerQuestionId = triggerQuestionId;
	}

	public int getOptionOrder() {
		return optionOrder;
	}

	public void setOptionOrder(int optionOrder) {
		this.optionOrder = optionOrder;
	}

	public SurveyQuestion getSurveyQuestion() {
		return surveyQuestion;
	}

	public void setSurveyQuestion(SurveyQuestion surveyQuestion) {
		if (this.triggerQuestionId == 0 || surveyQuestion.getQuestionId() == 0
				|| surveyQuestion.getQuestionId() != this.triggerQuestionId)
			this.surveyQuestion = surveyQuestion;
	}

	public SurveyQuestion getTriggerQuestion() {
		return triggerQuestion;
	}

	public void setTriggerQuestion(SurveyQuestion triggerQuestion) {
		if (this.questionId == 0 || triggerQuestion.getQuestionId() == 0
				|| triggerQuestion.getQuestionId() != this.questionId)
			this.triggerQuestion = triggerQuestion;
	}

}
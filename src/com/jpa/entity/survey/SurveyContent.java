package com.jpa.entity.survey;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jpa.entity.survey.id.SurveyContentID;

@Entity(name = "SurveyContent")
@IdClass(SurveyContentID.class)
public class SurveyContent extends GenericEntity {

	@Id
	@Column(name = "SURVEY_FORM_ID", insertable = false, updatable = false)
	private long surveyFormId;

	@Id
	@Column(name = "QUESTION_ID", insertable = false, updatable = false)
	private long questionId;

	@Column(name = "DISP_ORDER")
	private int order;

	@Column(name = "INACTIVE_FLAG")
	private boolean inactiveFlag;

	@Column(name = "INACTIVE_DATE")
	private Date inactiveDate;

	@Column(name = "LAST_UPDT_ID")
	private String lastUPDTId;

	@Column(name = "LAST_UPDT_DATE")
	private Date lastUPDTDate;

	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.ALL})
	@JoinColumn(name = "SURVEY_FORM_ID")
	private SurveyForm surveyForm;

	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.ALL})
	@JoinColumn(name = "QUESTION_ID")
	SurveyQuestion surveyQuestion;

	public long getSurveyFormId() {
		return surveyFormId;
	}

	public void setSurveyFormId(long surveyFormId) {
		this.surveyFormId = surveyFormId;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public Date getInactiveDate() {
		return inactiveDate;
	}

	public void setInactiveDate(Date inactiveDate) {
		this.inactiveDate = inactiveDate;
	}

	public String getLastUPDTId() {
		return lastUPDTId;
	}

	public void setLastUPDTId(String lastUPDTId) {
		this.lastUPDTId = lastUPDTId;
	}

	public Date getLastUPDTDate() {
		return lastUPDTDate;
	}

	public void setLastUPDTDate(Date lastUPDTDate) {
		this.lastUPDTDate = lastUPDTDate;
	}

	public boolean isInactiveFlag() {
		return inactiveFlag;
	}

	public void setInactiveFlag(boolean inactiveFlag) {
		this.inactiveFlag = inactiveFlag;
	}

	public SurveyForm getSurveyForm() {
		return surveyForm;
	}

	public void setSurveyForm(SurveyForm surveyForm) {
		this.surveyForm = surveyForm;
	}

	public SurveyQuestion getSurveyQuestion() {
		return surveyQuestion;
	}

	public void setSurveyQuestion(SurveyQuestion surveyQuestion) {
		this.surveyQuestion = surveyQuestion;
	}

	public SurveyContent() {

	}

	public SurveyContent(SurveyForm surveyForm, SurveyQuestion question) {
		this.surveyFormId = surveyForm.getSurveyFormId();
		this.surveyForm = surveyForm;
		this.questionId = question.getQuestionId();
		this.surveyQuestion = question;
	}
}

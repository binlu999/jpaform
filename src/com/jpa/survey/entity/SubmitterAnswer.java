package com.jpa.survey.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jpa.survey.entity.id.SubmitterAnswerID;
import com.jpa.survey.entity.id.SurveyQuestionID;

@Entity(name = "SUBMITTERS_ANSWERS")
@IdClass(SubmitterAnswerID.class)
public class SubmitterAnswer extends GenericEntity {

	@Id
	@Column(name = "SURVEY_SUBMITTER_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long surveySubmitterId;

	@Id
	@Column(name = "SURVEY_FORM_ID", insertable = false, updatable = false)
	private long surveyFormId;

	@Id
	@Column(name = "QUESTION_ID", insertable = false, updatable = false)
	private long questionId;

	@Id
	@Column(name = "OPTION_ID", insertable = false, updatable = false)
	private long optionId;

	@Column(name = "ANSWER_TEXT", insertable = false, updatable = false)
	private long answerText;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.ALL })
	@JoinColumn(name = "SURVEY_SUBMITTER_ID")
	private Submitter submitter;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.ALL })
	@JoinColumn(name = "SURVEY_FORM_ID")
	private SurveyForm surveyForm;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.ALL })
	@JoinColumn(name = "QUESTION_ID")
	Question question;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.ALL })
	@JoinColumn(name = "OPTION_ID")
	QuestionOption option;

	public SubmitterAnswer() {

	}

	public SubmitterAnswer(Submitter submitter, SurveyForm surveyForm,
			Question question, QuestionOption option) {
		this.submitter=submitter;
		this.surveySubmitterId=submitter.getSurveySubmitterId();
		this.surveyForm=surveyForm;
		this.surveyFormId=surveyForm.getSurveyFormId();
		this.question=question;
		this.questionId=question.getQuestionId();
		this.option=option;
		this.optionId=option.getOptionId();
	}

	public long getSurveySubmitterId() {
		return surveySubmitterId;
	}

	public void setSurveySubmitterId(long surveySubmitterId) {
		this.surveySubmitterId = surveySubmitterId;
	}

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

	public long getOptionId() {
		return optionId;
	}

	public void setOptionId(long optionId) {
		this.optionId = optionId;
	}

	public long getAnswerText() {
		return answerText;
	}

	public void setAnswerText(long answerText) {
		this.answerText = answerText;
	}

	public Submitter getSubmitter() {
		return submitter;
	}

	public void setSubmitter(Submitter submitter) {
		this.submitter = submitter;
	}

	public SurveyForm getSurveyForm() {
		return surveyForm;
	}

	public void setSurveyForm(SurveyForm surveyForm) {
		this.surveyForm = surveyForm;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public QuestionOption getOption() {
		return option;
	}

	public void setOption(QuestionOption option) {
		this.option = option;
	}
	
	

}

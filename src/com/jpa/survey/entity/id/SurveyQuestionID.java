package com.jpa.survey.entity.id;

import java.io.Serializable;

public class SurveyQuestionID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long surveyFormId;
	private long questionId;

	public SurveyQuestionID() {

	}

	public SurveyQuestionID(long surveyFormId, long questionId) {
		this.surveyFormId = surveyFormId;
		this.questionId = questionId;
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

	@Override
	public boolean equals(Object obj) {
		return obj instanceof SurveyQuestionID
				&& this.surveyFormId == ((SurveyQuestionID) obj)
						.getSurveyFormId()
				&& this.questionId == ((SurveyQuestionID) obj)
						.getQuestionId();
	}

	@Override
	public int hashCode() {
		return (int) (this.surveyFormId + this.questionId);
	}

}

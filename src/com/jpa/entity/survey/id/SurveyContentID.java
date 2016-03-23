package com.jpa.entity.survey.id;

import java.io.Serializable;

public class SurveyContentID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long surveyFormId;
	private long questionId;

	public SurveyContentID() {

	}

	public SurveyContentID(long surveyFormId, long questionId) {
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
		return obj instanceof SurveyContentID
				&& this.surveyFormId == ((SurveyContentID) obj)
						.getSurveyFormId()
				&& this.questionId == ((SurveyContentID) obj)
						.getQuestionId();
	}

	@Override
	public int hashCode() {
		return (int) (this.surveyFormId + this.questionId);
	}

}

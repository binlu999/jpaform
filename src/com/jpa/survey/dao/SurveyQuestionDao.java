package com.jpa.survey.dao;

import com.jpa.survey.entity.SurveyQuestion;

public class SurveyQuestionDao extends EntityDao<SurveyQuestion>{

	public SurveyQuestionDao() {
		super(SurveyQuestion.class);
	}

	public int deletAll() {
		return super.runNamedQuery("SURVEY_QUESTIONS.deleteAll");
	}

}

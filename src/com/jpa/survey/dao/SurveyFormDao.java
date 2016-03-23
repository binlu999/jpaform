package com.jpa.survey.dao;

import java.util.List;

import com.jpa.survey.entity.SurveyForm;

public class SurveyFormDao extends EntityDao<SurveyForm>{
	public SurveyFormDao(){
		super(SurveyForm.class);
	}

	public List<SurveyForm> findAll(){
		return super.runNamedQuery("SurveyForm.findAll");
	}
}

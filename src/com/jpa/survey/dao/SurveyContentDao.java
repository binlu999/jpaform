package com.jpa.survey.dao;

import com.jpa.survey.entity.SurveyContent;

public class SurveyContentDao extends EntityDao<SurveyContent>{

	public SurveyContentDao() {
		super(SurveyContent.class);
	}

	public int deletAll() {
		return super.runNamedQuery("SurveyContent.deleteAll");
	}

}

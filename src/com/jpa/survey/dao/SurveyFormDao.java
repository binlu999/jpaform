package com.jpa.survey.dao;

import java.util.Collection;
import java.util.List;
import com.jpa.survey.entity.SurveyContent;
import com.jpa.survey.entity.SurveyForm;
import com.jpa.survey.entity.SurveyQuestion;

public class SurveyFormDao extends EntityDao<SurveyForm>{
	SurveyQuestionDao surveyQuestionDao=new SurveyQuestionDao();
	public SurveyFormDao(){
		super(SurveyForm.class);
	}

	@Override
	public SurveyForm save(SurveyForm surveyForm) {
		Collection<SurveyContent> contents = surveyForm.getSurveyContents();
		for(SurveyContent content:contents){
			SurveyQuestion question = content.getSurveyQuestion();
			SurveyQuestion savedQuestion=surveyQuestionDao.save(question);
			content.setSurveyQuestion(savedQuestion);
			content.setQuestionId(savedQuestion.getQuestionId());
		}
		return super.save(surveyForm);
	}

	public List<SurveyForm> findAll() {
		return super.runNamedTypedQueryForAll("SurveyForm.findAll");
	}

	public int deletAll() {
		return super.runNamedQuery("SurveyForm.deleteAll");
	}
	
}

package com.jpa.survey.file;

import com.jpa.survey.dao.SurveyQuestionTypeDao;

public class SurveyQuestionTypeFileImporter {

	private SurveyQuestionTypeDao surveyQuestionTypeDao;
	
	public SurveyQuestionTypeFileImporter(){
		surveyQuestionTypeDao=new SurveyQuestionTypeDao();
	}
	
	public void importQuestionType(String filePath){
		
	}
}

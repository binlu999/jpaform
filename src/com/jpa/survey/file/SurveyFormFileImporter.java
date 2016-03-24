package com.jpa.survey.file;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.survey.dao.SurveyFormDao;
import com.jpa.survey.vo.SurveyFormVO;

public class SurveyFormFileImporter {
	private SurveyFormDao surveyFormDao = new SurveyFormDao();
	ObjectMapper mapper = new ObjectMapper();
	
	public void importFile(String resourcePath) throws JsonParseException, JsonMappingException, IOException{
		InputStream input = this.getClass().getClassLoader().getResourceAsStream(resourcePath);
		SurveyFormVO surveyFormVO=mapper.readValue(input, SurveyFormVO.class);
	}

}

package com.test.jpa.entity;

import java.util.Date;

import com.jpa.survey.dao.SurveyQuestionDao;
import com.jpa.survey.entity.SurveyQuestion;

public class SurveyQuestionTest extends GenericTest<SurveyQuestionDao,SurveyQuestion>{

	protected SurveyQuestionTest()
			throws InstantiationException, IllegalAccessException {
		super(SurveyQuestionDao.class);
	}

	@Override
	public SurveyQuestion creatOne() {
		SurveyQuestion e=new SurveyQuestion();
		e.setInactiveFlag(false);
		e.setLastUPDTId("SYSTEM ADMIN");
		e.setLastUPDTDate(new Date());
		assert(e!=null);
		return e ;
	}


	@Override
	public SurveyQuestion find(long id) {
		return null;
	}

	public void testDeletAll(){
		this.dao.deletAll();
	}
}

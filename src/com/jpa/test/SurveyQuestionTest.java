package com.jpa.test;

import java.util.Date;

import com.jpa.dao.SurveyQuestionDao;
import com.jpa.entity.survey.SurveyQuestion;

public class SurveyQuestionTest extends
		GenericTest<SurveyQuestionDao, SurveyQuestion> {

	protected SurveyQuestionTest() throws InstantiationException,
			IllegalAccessException {
		super(SurveyQuestionDao.class);
	}

	@Override
	public SurveyQuestion creatOne() {
		SurveyQuestion e = new SurveyQuestion();
		e.setQuestionText("Have you received your contract?");
		e.setQuestionTypeId(SurveyQuestion.TYPE.TEXT.getValue());
		e.setInactiveFlag(false);
		e.setLastUPDTId("SYSTEM ADMIN");
		e.setLastUPDTDate(new Date());
		assert (e.getQuestionId() == 0);
		return e;
	}

}

package com.test.jpa.entity;

import java.util.Date;

import com.jpa.survey.dao.SurveyQuestionDao;
import com.jpa.survey.entity.SurveyQuestion;
import com.jpa.survey.entity.enums.QuestionType;

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
		e.setQuestionTypeId(QuestionType.TEXT.getValue());
		e.setInactiveFlag(false);
		e.setLastUPDTId("SYSTEM ADMIN");
		e.setLastUPDTDate(new Date());
		assert (e.getQuestionId() == 0);
		return e;
	}

}

package com.jpa.test;

import java.util.Date;

import com.jpa.dao.SurveyFormDao;
import com.jpa.entity.survey.SurveyForm;

public class SurveyFormTest extends GenericTest<SurveyFormDao, SurveyForm> {

	public SurveyFormTest() throws InstantiationException,
			IllegalAccessException {
		super(SurveyFormDao.class);
	}

	public SurveyForm creatOne() {
		SurveyForm e = new SurveyForm();
		e.setCompanyCode("101");
		e.setMarketArea("MLM");
		e.setProdCode("Life");
		e.setFormDescription("MLM Life  Survey");
		e.setInactiveFlag(false);
		e.setLastUPDTId("SYSTEM ADMIN");
		e.setLastUPDTDate(new Date());
		assert (e.getSurveyFormId() == 0);
		return e;
	}

}

package com.jpa.test;

import java.util.Date;

import com.jpa.dao.SurveyContentDao;
import com.jpa.entity.survey.SurveyContent;

public class SurveyContentTest extends GenericTest<SurveyContentDao,SurveyContent>{

	protected SurveyContentTest()
			throws InstantiationException, IllegalAccessException {
		super(SurveyContentDao.class);
	}

	@Override
	public SurveyContent creatOne() {
		SurveyContent e=new SurveyContent();
		e.setInactiveFlag(false);
		e.setLastUPDTId("SYSTEM ADMIN");
		e.setLastUPDTDate(new Date());
		assert(e!=null);
		return e ;
	}


	@Override
	public SurveyContent find(long id) {
		return null;
	}

}

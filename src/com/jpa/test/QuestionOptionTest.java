package com.jpa.test;

import com.jpa.dao.QuestionOptionDao;
import com.jpa.dao.SurveyQuestionDao;
import com.jpa.entity.survey.QuestionOption;
import com.jpa.entity.survey.SurveyQuestion;

public class QuestionOptionTest extends
		GenericTest<QuestionOptionDao, QuestionOption> {

	protected QuestionOptionTest() throws InstantiationException,
			IllegalAccessException {
		super(QuestionOptionDao.class);
	}

	@Override
	public QuestionOption creatOne() {
		QuestionOption e=new QuestionOption();
		e.setOptionText("Yes");
		e.setOptionOrder(1);
		e.setTriggerFlag(true);
		return e;
	}
	
	public void testAssignToQuestion(){
		SurveyQuestionDao questionDao=new SurveyQuestionDao();
		SurveyQuestion question = questionDao.find(6451);
		SurveyQuestion trigerQuestion = questionDao.find(6251);
		
		QuestionOption option = this.find(6501);
		
		option.setSurveyQuestion(question);
		option.setTriggerQuestion(trigerQuestion);
		this.dao.save(option);
		
		//question.getQuestionOptions().add(option);
		//questionDao.save(question);
		
	}

}

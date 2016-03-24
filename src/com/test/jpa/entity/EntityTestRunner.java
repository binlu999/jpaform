package com.test.jpa.entity;

import java.util.Collection;

import org.apache.commons.lang.StringUtils;

import com.jpa.survey.entity.QuestionOption;
import com.jpa.survey.entity.SurveyContent;
import com.jpa.survey.entity.SurveyForm;
import com.jpa.survey.entity.SurveyQuestion;

public class EntityTestRunner {

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException {
		QuestionOptionTest test=new QuestionOptionTest();
		
		
		//test.testAssignToQuestion();
 
		//testCreateContent();
		
		SurveyFormTest formTest = new SurveyFormTest();
		//formTest.testFindAll();
		formTest.testExport();
		
		/*
		SurveyForm form = formTest.find(6401);
		Collection<SurveyContent> contents = form.getSurveyContents();
		for(SurveyContent content:contents){
			SurveyQuestion q = content.getSurveyQuestion();
			Collection<QuestionOption> options = q.getQuestionOptions();
			assert(options.size()>0);
		}
		assert(contents.size()>0);
	*/
	}

	static void testCreateContent() throws InstantiationException,
			IllegalAccessException {
		SurveyFormTest formTest = new SurveyFormTest();
		SurveyQuestionTest questionTest = new SurveyQuestionTest();
		SurveyContentTest contentTest = new SurveyContentTest();
		QuestionOptionTest questionOptionTest=new QuestionOptionTest();

		SurveyForm form = formTest.creatOne();
		SurveyQuestion question = questionTest.creatOne();

		SurveyContent content = contentTest.creatOne();
		content.setSurveyForm(form);
		content.setSurveyQuestion(question);
		
		QuestionOption questionOption = questionOptionTest.creatOne();
		question.getQuestionOptions().add(questionOption);

		SurveyContent newContent = contentTest.save(content);
		newContent = contentTest.merge(newContent);

		long formId = newContent.getSurveyForm().getSurveyFormId();
		SurveyForm newForm = formTest.find(formId);
		newForm = formTest.merge(newForm);
		Collection<SurveyContent> contents = newForm.getSurveyContents();
		assert (StringUtils.equals(newForm.getFormDescription(),
				form.getFormDescription()));
		assert (newForm.getSurveyContents().size() > 0);

		long questionId = newContent.getSurveyQuestion().getQuestionId();
		SurveyQuestion newQuestion = questionTest.find(questionId);
		assert (StringUtils.equals(newQuestion.getQuestionText(),
				question.getQuestionText()));
		assert (newQuestion.getSurveyContents().size() > 0);
	}
}

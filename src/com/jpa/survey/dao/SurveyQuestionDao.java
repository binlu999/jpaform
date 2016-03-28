package com.jpa.survey.dao;

import java.util.Collection;

import com.jpa.survey.entity.QuestionOption;
import com.jpa.survey.entity.SurveyQuestion;

public class SurveyQuestionDao extends EntityDao<SurveyQuestion> {
	public SurveyQuestionDao() {
		super(SurveyQuestion.class);
	}

	@Override
	public SurveyQuestion save(SurveyQuestion question) {
		Collection<QuestionOption> options = question.getQuestionOptions();
		for (QuestionOption option : options) {
			SurveyQuestion triggerQuestion = option.getTriggerQuestion();
			if (triggerQuestion != null) {
				triggerQuestion = save(triggerQuestion);
				option.setTriggerQuestion(triggerQuestion);
				option.setTriggerQuestionId(triggerQuestion.getQuestionId());
			}
		}
		return super.save(question);
	}

	public int deletAll() {
		return super.runNamedQuery("SurveyQuestion.deleteAll");
	}

}

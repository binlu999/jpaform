package com.jpa.survey.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity(name = "SurveyQuestions")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(name = "SurveyQuestion.findAll", query = "SELECT f FROM SurveyQuestions f"),
	@NamedQuery(name = "SurveyQuestion.deleteAll", query = "DELETE FROM SurveyQuestions f") })
public class SurveyQuestion extends GenericFormEntity{
	
	@Id
	@Column(name = "QUESTION_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long questionId;
	
	@Column(name = "QUESTION_TEXT")
	private String questionText;


	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.ALL })
	@JoinColumn(name = "QUESTION_TYPE_CODE")
	private SurveyQuestionType surveyQuestionType;
			
	@OneToMany(mappedBy="surveyQuestion")
    private Collection<SurveyContent> surveyContents = new ArrayList<SurveyContent>();
	
	@OneToMany(mappedBy="surveyQuestion", cascade = { CascadeType.PERSIST, CascadeType.ALL })
	private Collection<QuestionOption> questionOptions = new ArrayList<QuestionOption>();
	   
	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public SurveyQuestionType getSurveyQuestionType() {
		return surveyQuestionType;
	}

	public void setSurveyQuestionType(SurveyQuestionType surveyQuestionType) {
		this.surveyQuestionType = surveyQuestionType;
	}

	public Collection<SurveyContent> getSurveyContents() {
		return surveyContents;
	}

	public void setSurveyContents(Collection<SurveyContent> surveyContents) {
		this.surveyContents = surveyContents;
	}

	public Collection<QuestionOption> getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(Collection<QuestionOption> questionOptions) {
		this.questionOptions = questionOptions;
	}
	
	
}

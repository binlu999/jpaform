package com.jpa.survey.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name = "SurveyQuestionTypes")
@NamedQueries({
	@NamedQuery(name = "SurveyQuestionType.findAll", query = "SELECT f FROM SurveyForms f"),
	@NamedQuery(name = "SurveyQuestionType.deleteAll", query = "DELETE FROM SurveyForms f"),
	@NamedQuery(name = "SurveyQuestionType.findSingleBy", query = "SELECT f FROM SurveyQuestionTypes f WHERE f.code = :code ")})
public class SurveyQuestionType extends GenericEntity{
	
	@Id
	@Column(name = "QUESTION_TYPE_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long quetionTypeId;
	
	@Column(name = "QUESTION_TYPE_CODE", nullable = false)
	private String code;
	
	@Column(name = "QUESTION_TYPE_CODE")
	private String description;

	public long getQuetionTypeId() {
		return quetionTypeId;
	}

	public void setQuetionTypeId(long quetionTypeId) {
		this.quetionTypeId = quetionTypeId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}

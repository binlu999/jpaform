package com.jpa.survey.vo;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jpa.survey.entity.SurveyContent;
import com.jpa.survey.entity.SurveyForm;
import com.jpa.survey.entity.SurveyQuestion;

public class SurveyFormVO {

	@JsonIgnore
	private long surveyFormId;
	private String companyCode;
	private String marketArea;
	private String prodCode;
	private String formDescription;
	@JsonProperty("Questions")
	private java.util.List<SurveyQuestionVO> surveyQuestionVOs;

	public SurveyFormVO() {
	}

	public SurveyFormVO(SurveyForm surveyForm) {
		this.surveyFormId = surveyForm.getSurveyFormId();
		this.companyCode = surveyForm.getCompanyCode();
		this.marketArea = surveyForm.getMarketArea();
		this.prodCode = surveyForm.getProdCode();
		this.formDescription = surveyForm.getFormDescription();
		this.surveyQuestionVOs = new java.util.ArrayList<SurveyQuestionVO>();
		Collection<SurveyContent> contents = surveyForm.getSurveyContents();
		for (SurveyContent content : contents) {
			SurveyQuestion surveyQuestion = content.getSurveyQuestion();
			SurveyQuestionVO surveyQuestionVO = new SurveyQuestionVO(
					surveyQuestion);
			surveyQuestionVO.setDisplpayOrder(content.getOrder());
			this.surveyQuestionVOs.add(surveyQuestionVO);
		}
	}

	public long getSurveyFormId() {
		return surveyFormId;
	}

	public void setSurveyFormId(long surveyFormId) {
		this.surveyFormId = surveyFormId;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getMarketArea() {
		return marketArea;
	}

	public void setMarketArea(String marketArea) {
		this.marketArea = marketArea;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getFormDescription() {
		return formDescription;
	}

	public void setFormDescription(String formDescription) {
		this.formDescription = formDescription;
	}

	public java.util.List<SurveyQuestionVO> getSurveyQuestionVOs() {
		return surveyQuestionVOs;
	}

	public void setSurveyQuestionVOs(
			java.util.List<SurveyQuestionVO> surveyQuestionVOs) {
		this.surveyQuestionVOs = surveyQuestionVOs;
	}

	@JsonIgnore
	public SurveyForm getEntity() {
		SurveyForm surveyForm = new SurveyForm();
		surveyForm.setSurveyFormId(this.surveyFormId);
		surveyForm.setCompanyCode(this.companyCode);
		surveyForm.setMarketArea(this.marketArea);
		surveyForm.setProdCode(this.prodCode);
		surveyForm.setFormDescription(this.formDescription);
		if (this.surveyQuestionVOs != null) {
			Collection<SurveyContent> surveyContents = new java.util.ArrayList<SurveyContent>();
			for (SurveyQuestionVO surveyQuestionVO : surveyQuestionVOs) {
				SurveyQuestion surveyQuestion = surveyQuestionVO.getEntity();
				SurveyContent content = new SurveyContent();
				content.setSurveyForm(surveyForm);
				content.setSurveyQuestion(surveyQuestion);
				content.setOrder(surveyQuestionVO.getDisplpayOrder());
				surveyContents.add(content);
			}
			surveyForm.setSurveyContents(surveyContents);
		}
		return surveyForm;
	}

}

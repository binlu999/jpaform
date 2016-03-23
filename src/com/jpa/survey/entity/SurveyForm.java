package com.jpa.survey.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.InheritanceType;


@Entity(name = "SurveyForms")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({@NamedQuery(name="SurveyForm.findAll", query="SELECT f FROM SurveyForms f")})
public class SurveyForm extends GenericEntity {
	@Id
	@Column(name = "SURVEY_FORM_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long surveyFormId;
	
	@Column(name = "COMPANY_CODE")
	private String companyCode;
	
	@Column(name = "MARKET_AREA")
	private String marketArea;
	
	@Column(name = "PROD_CODE")
	private String prodCode;
	
	@Column(name = "FORM_DESCRIPTION")
	private String formDescription;
	
	@OneToMany( mappedBy="surveyForm",cascade={CascadeType.ALL,CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private Collection<SurveyContent> surveyContents= new ArrayList<SurveyContent>();
	
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

	public Collection<SurveyContent> getSurveyContents() {
		return surveyContents;
	}

	public void setSurveyContents(Collection<SurveyContent> surveyContents) {
		this.surveyContents = surveyContents;
	}
		
}

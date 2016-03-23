package com.jpa.entity.survey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "SurveyForms")
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

	@Column(name = "INACTIVE_FLAG")
	private boolean inactiveFlag;
	
	@Column(name = "INACTIVE_DATE")
	private Date inactiveDate;
	
	@Column(name = "LAST_UPDT_ID")
	private String lastUPDTId;
	
	@Column(name = "LAST_UPDT_DATE")
	private Date lastUPDTDate;
	
	//@OneToMany(mappedBy="surveyForm",cascade={CascadeType.PERSIST})
	@OneToMany( mappedBy="surveyForm",cascade={CascadeType.ALL,CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private Collection<SurveyContent> surveyContents= new ArrayList<SurveyContent>();
	
	/*
	@OneToMany( cascade={CascadeType.ALL,CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
	private Collection<SurveyQuestion> surveyQuestions=new ArrayList<SurveyQuestion>();
	*/
	
	
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

	public boolean isInactiveFlag() {
		return inactiveFlag;
	}

	public void setInactiveFlag(boolean inactiveFlag) {
		this.inactiveFlag = inactiveFlag;
	}

	public Date getInactiveDate() {
		return inactiveDate;
	}

	public void setInactiveDate(Date inactiveDate) {
		this.inactiveDate = inactiveDate;
	}

	public String getLastUPDTId() {
		return lastUPDTId;
	}

	public void setLastUPDTId(String lastUPDTId) {
		this.lastUPDTId = lastUPDTId;
	}

	public Date getLastUPDTDate() {
		return lastUPDTDate;
	}

	public void setLastUPDTDate(Date lastUPDTDate) {
		this.lastUPDTDate = lastUPDTDate;
	}
/*
	public Collection<SurveyQuestion> getSurveyQuestions() {
		return surveyQuestions;
	}

	public void setSurveyQuestions(Collection<SurveyQuestion> surveyQuestions) {
		this.surveyQuestions = surveyQuestions;
	}
*/

	public Collection<SurveyContent> getSurveyContents() {
		return surveyContents;
	}

	public void setSurveyContents(Collection<SurveyContent> surveyContents) {
		this.surveyContents = surveyContents;
	}
		
}

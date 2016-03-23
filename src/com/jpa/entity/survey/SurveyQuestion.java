package com.jpa.entity.survey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "SurveyQuestions")
public class SurveyQuestion extends GenericEntity{

	public enum TYPE{
		TEXT(1),YESNO(2);
		
		private int value;
		TYPE(int v){
			this.value=v;
		}
		
		public int getValue(){
			return value;
		}
	}
	
	@Id
	@Column(name = "QUESTION_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long questionId;
	
	@Column(name = "QUESTION_TEXT")
	private String questionText;
	
	@Column(name = "QUESTION_TYPE_ID")
	private int questionTypeId;

	@Column(name = "INACTIVE_FLAG")
	private boolean inactiveFlag;
	
	@Column(name = "INACTIVE_DATE")
	private Date inactiveDate;
	
	@Column(name = "LAST_UPDT_ID")
	private String lastUPDTId;
	
	@Column(name = "LAST_UPDT_DATE")
	private Date lastUPDTDate;
	

	@OneToMany(mappedBy="surveyQuestion")
    private Collection<SurveyContent> surveyContents = new ArrayList<SurveyContent>();
	   
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

	public int getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(int questionTypeId) {
		this.questionTypeId = questionTypeId;
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

	public Collection<SurveyContent> getSurveyContents() {
		return surveyContents;
	}

	public void setSurveyContents(Collection<SurveyContent> surveyContents) {
		this.surveyContents = surveyContents;
	}
	
}

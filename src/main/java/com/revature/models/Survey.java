package com.revature.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "surveys")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int surveyId;
	
	@NotNull
	private String title;
	
	@NotNull
	private String description;
	
	@Column(name = "date_created")
	@NotNull
	private Date dateCreated;
	
	@Column(name = "closing_date")
	@NotNull
	private Date closingDate;
	
	private boolean template;
	
	private boolean published;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "junction_survey_questions", joinColumns = @JoinColumn(name = "survey_id"), inverseJoinColumns = @JoinColumn(name = "question_id"))
	private List<Question> allQuestions;

	public Survey(int surveyId, @NotNull String title, @NotNull String description, @NotNull Date dateCreated,
			@NotNull Date closingDate, boolean template, boolean published, List<Question> allQuestions) {
		super();
		this.surveyId = surveyId;
		this.title = title;
		this.description = description;
		this.dateCreated = dateCreated;
		this.closingDate = closingDate;
		this.template = template;
		this.published = published;
		this.allQuestions = allQuestions;
	}

	public Survey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public boolean isTemplate() {
		return template;
	}

	public void setTemplate(boolean template) {
		this.template = template;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public List<Question> getAllQuestions() {
		return allQuestions;
	}

	public void setAllQuestions(List<Question> allQuestions) {
		this.allQuestions = allQuestions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allQuestions == null) ? 0 : allQuestions.hashCode());
		result = prime * result + ((closingDate == null) ? 0 : closingDate.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (published ? 1231 : 1237);
		result = prime * result + surveyId;
		result = prime * result + (template ? 1231 : 1237);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Survey other = (Survey) obj;
		if (allQuestions == null) {
			if (other.allQuestions != null)
				return false;
		} else if (!allQuestions.equals(other.allQuestions))
			return false;
		if (closingDate == null) {
			if (other.closingDate != null)
				return false;
		} else if (!closingDate.equals(other.closingDate))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (published != other.published)
			return false;
		if (surveyId != other.surveyId)
			return false;
		if (template != other.template)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Survey [surveyId=" + surveyId + ", title=" + title + ", description=" + description + ", dateCreated="
				+ dateCreated + ", closingDate=" + closingDate + ", template=" + template + ", published=" + published
				+ ", allQuestions=" + allQuestions + "]";
	}
	
}

package com.cg.fms.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "feedback identifier required")
	@Size(min=4, max=5, message = "size must be 4 to 5 characters")
	private String feedbackIdentifier;
	
	@Range(min=1, max=10)
	private int technicalSkills;
	@Range(min=1, max=10)
	private int clarityOfSpeech;
	@Range(min=1, max=10)
	private int communicationalSkills;
	@Range(min=1, max=10)
	private int friendliness;
	@Range(min=1, max=10)
	private int overallRating;
	
	@Size(min=4, max=100, message = "size must be 4 to 100 characters")
	private String comments;
	
	@Size(min=4, max=100, message = "size must be 4 to 100 characters")
	private String suggestions;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date created_At;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFeedbackIdentifier() {
		return feedbackIdentifier;
	}
	public void setFeedbackIdentifier(String feedbackIdentifier) {
		this.feedbackIdentifier = feedbackIdentifier;
	}
	public int getTechnicalSkills() {
		return technicalSkills;
	}
	public void setTechnicalSkills(int technicalSkills) {
		this.technicalSkills = technicalSkills;
	}
	public int getClarityOfSpeech() {
		return clarityOfSpeech;
	}
	public void setClarityOfSpeech(int clarityOfSpeech) {
		this.clarityOfSpeech = clarityOfSpeech;
	}
	public int getCommunicationalSkills() {
		return communicationalSkills;
	}
	public void setCommunicationalSkills(int communicationalSkills) {
		this.communicationalSkills = communicationalSkills;
	}
	public int getFriendliness() {
		return friendliness;
	}
	public void setFriendliness(int friendliness) {
		this.friendliness = friendliness;
	}
	public int getOverallRating() {
		return overallRating;
	}
	public void setOverallRating(int overallRating) {
		this.overallRating = overallRating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getSuggestions() {
		return suggestions;
	}
	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}
	public Date getCreated_At() {
		return created_At;
	}
	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}
	@PrePersist
	public void onCreate() {
		this.created_At = new Date();
	}

}

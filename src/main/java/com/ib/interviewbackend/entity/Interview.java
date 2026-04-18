package com.ib.interviewbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String candidateEmail;
    private String candidateName; // New field
    private String recruiterEmail;
    private String recruiterName; // New field
    private String interviewType;
    private String stageOfInterview;
    private LocalDateTime interviewDate;
    private String descriptionForCandidate;
    private String descriptionForRecruiter;
    private String googleMeetLink;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

    public String getCandidateName() { // New getter and setter
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getRecruiterEmail() {
        return recruiterEmail;
    }

    public void setRecruiterEmail(String recruiterEmail) {
        this.recruiterEmail = recruiterEmail;
    }

    public String getRecruiterName() { // New getter and setter
        return recruiterName;
    }

    public void setRecruiterName(String recruiterName) {
        this.recruiterName = recruiterName;
    }

    public String getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(String interviewType) {
        this.interviewType = interviewType;
    }

    public String getStageOfInterview() {
        return stageOfInterview;
    }

    public void setStageOfInterview(String stageOfInterview) {
        this.stageOfInterview = stageOfInterview;
    }

    public LocalDateTime getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDateTime interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getDescriptionForCandidate() {
        return descriptionForCandidate;
    }

    public void setDescriptionForCandidate(String descriptionForCandidate) {
        this.descriptionForCandidate = descriptionForCandidate;
    }

    public String getDescriptionForRecruiter() {
        return descriptionForRecruiter;
    }

    public void setDescriptionForRecruiter(String descriptionForRecruiter) {
        this.descriptionForRecruiter = descriptionForRecruiter;
    }

    public String getGoogleMeetLink() {
        return googleMeetLink;
    }

    public void setGoogleMeetLink(String googleMeetLink) {
        this.googleMeetLink = googleMeetLink;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", candidateEmail='" + candidateEmail + '\'' +
                ", candidateName='" + candidateName + '\'' + // Include new fields
                ", recruiterEmail='" + recruiterEmail + '\'' +
                ", recruiterName='" + recruiterName + '\'' + // Include new fields
                ", interviewType='" + interviewType + '\'' +
                ", stageOfInterview='" + stageOfInterview + '\'' +
                ", interviewDate=" + interviewDate +
                ", descriptionForCandidate='" + descriptionForCandidate + '\'' +
                ", descriptionForRecruiter='" + descriptionForRecruiter + '\'' +
                ", googleMeetLink='" + googleMeetLink + '\'' +
                '}';
    }
}

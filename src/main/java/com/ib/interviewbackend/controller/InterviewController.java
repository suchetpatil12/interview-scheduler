package com.ib.interviewbackend.controller;

import com.ib.interviewbackend.entity.Interview;
import com.ib.interviewbackend.entity.ResponseMessage;
import com.ib.interviewbackend.service.InterviewService;
import com.ib.interviewbackend.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interviews")
@CrossOrigin(origins = "http://localhost:4200")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @Autowired
    private MailService mailService;

    @PostMapping("/schedule")
    public ResponseEntity<ResponseMessage> scheduleInterview(@RequestBody Interview interview) {
        Interview scheduledInterview = interviewService.scheduleInterview(interview);

        // Send email to candidate
        String candidateEmailBody = "Dear " + scheduledInterview.getCandidateName() + ",\n\nYour interview is scheduled on " +
                scheduledInterview.getInterviewDate() +
                ".\nInterview Type: " + scheduledInterview.getInterviewType() +
                "\nStage of Interview: " + scheduledInterview.getStageOfInterview() +
                "\nDescription: " + scheduledInterview.getDescriptionForCandidate() +
                "\nGoogle Meet Link: " + scheduledInterview.getGoogleMeetLink() +
                "\n\nBest regards,\nRecruitment Team";

        mailService.sendEmail(scheduledInterview.getCandidateEmail(), "Interview Scheduled", candidateEmailBody);

        // Send email to recruiter
        String recruiterEmailBody = "Dear " + scheduledInterview.getRecruiterName() + ",\n\nAn interview is scheduled on " +
                scheduledInterview.getInterviewDate() +
                ".\nInterview Type: " + scheduledInterview.getInterviewType() +
                "\nStage of Interview: " + scheduledInterview.getStageOfInterview() +
                "\nDescription: " + scheduledInterview.getDescriptionForRecruiter() +
                "\nGoogle Meet Link: " + scheduledInterview.getGoogleMeetLink() +
                "\n\nBest regards,\nRecruitment Team";

        mailService.sendEmail(scheduledInterview.getRecruiterEmail(), "Interview Scheduled", recruiterEmailBody);

        // Return a ResponseEntity with the success message in a structured JSON format
        ResponseMessage responseMessage = new ResponseMessage("Interview scheduled and emails sent successfully!");
        return ResponseEntity.ok(responseMessage);
    }
}

package com.buglist.emailnotif;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
 
    @Autowired 
    private EmailService emailService;

    @Autowired
    private BugService bugService;
 
    // Method #1    
    @PostMapping("/Mail")
    public String
    sendMail(@RequestBody EmailDetails details) {
        String status = emailService.sendSimpleMail(details);
        return status;
    }
 
    // Method #2
    @PostMapping("/MailWithAttachment")
    public String sendMailWithAttachment(@RequestBody EmailDetails details) {
        String status = emailService.sendMailWithAttachment(details);
        return status;
    }

    @PostMapping("/MailForOpenBugs")
    public ResponseEntity<String> sendEmailForOpenBugs() {
        List<Bug> openBugs = bugService.findBugsWithOpenStatus();

        if (openBugs.isEmpty()) {
            return ResponseEntity.ok("No open bugs found.");
        }

        for (Bug bug : openBugs) {
            String emailSubject = "Bug Notification: Bug ID " + bug.getBugId();
            String emailBody = "Dear " + bug.getCustomerName() + ",\n\n"
                    + "This is to inform you that the bug with ID " + bug.getBugId()
                    + " in project " + bug.getProjectName() + " is still open.\n\n"
                    + "Reported Date: " + bug.getReportedDate() + "\n"
                    + "Summary: " + bug.getSummary() + "\n\n"
                    + "Please take necessary actions to resolve it.";

            EmailDetails emailDetails = new EmailDetails();
            emailDetails.setRecipient(bug.getAssigneeToEmail());
            emailDetails.setSubject(emailSubject);
            emailDetails.setMsgBody(emailBody);

            emailService.sendSimpleMail(emailDetails);
        }

        return ResponseEntity.ok("Email notifications sent for open bugs.");
    }
}

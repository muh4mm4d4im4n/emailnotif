package com.buglist.emailnotif;

// import com.buglist.emailnotif.Bug;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);
    String sendMailWithAttachment(EmailDetails details);
}
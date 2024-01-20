package mates.petshome.service.impl;

import lombok.RequiredArgsConstructor;
import mates.petshome.model.AdoptAnimalForm;
import mates.petshome.model.ContactUsForm;
import mates.petshome.service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private static final String FROM_EMAIL = "petshome.contactus@gmail.com";
    private static final String DEFAULT_TO_EMAIL = "petshome.contactus@gmail.com";
    private static final String DEFAULT_ADOPT_SUBJECT = "New Adopt request!";
    private static final String DEFAULT_CONTACTUS_SUBJECT = "New message!";
    private final JavaMailSender mailSender;

    @Override
    public void notifyAboutNewAdoptRequest(Long id, AdoptAnimalForm form) {
        SimpleMailMessage message = createDefaultMessageTemplate();
        message.setSubject(DEFAULT_ADOPT_SUBJECT);

        String parsedText = parseAdoptRequest(id, form);
        message.setText(parsedText);

        mailSender.send(message);
    }

    @Override
    public void notifyAboutNewContactUsRequest(ContactUsForm requestForm) {
        SimpleMailMessage message = createDefaultMessageTemplate();
        message.setSubject(DEFAULT_CONTACTUS_SUBJECT);

        String parsedText = parseContactUsRequest(requestForm);
        message.setText(parsedText);

        mailSender.send(message);
    }

    private SimpleMailMessage createDefaultMessageTemplate() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(FROM_EMAIL);
        message.setTo(DEFAULT_TO_EMAIL);
        return message;
    }

    private String parseAdoptRequest(Long id, AdoptAnimalForm form) {
        StringBuilder builder = new StringBuilder();
        builder.append(form.getName())
                .append(" - ")
                .append(form.getContactPhone())
                .append(" - ")
                .append(" wants to adopt a pet.")
                .append(System.lineSeparator())
                .append(form.getMessage());
        //        .append("TODO: ADD URL FOR ADMIN PANEL HERE");
        return builder.toString();
    }

    private String parseContactUsRequest(ContactUsForm form) {
        StringBuilder builder = new StringBuilder();
        builder.append(form.getName())
                .append(" - ")
                .append(form.getEmail())
                .append(" - ")
                .append(" says:")
                .append(System.lineSeparator())
                .append(form.getMessage());
        return builder.toString();
    }
}

package personalproject.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import personalproject.demo.models.EmailMessage;
import personalproject.demo.repositories.EmailRepository;

@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private final JavaMailSender mailSender;

    @Autowired
    private EmailRepository emailRepository;

    public SendMailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void SendMail(String from, String to, String subject, String inputName, String inputPhone, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);

        // message: texto del usuario
        String body = ("Email:  " + from) + "\n" + "\n" + ("Nombre:  " + inputName) + "\n" + "\n"
                + ("Teléfono:  " + inputPhone) + "\n" + "\n" + ("Consulta o comentario:  " + message);
        simpleMailMessage.setText(body);

        this.mailSender.send(simpleMailMessage);

    }

    public void save(EmailMessage emailNew) {
        emailRepository.save(emailNew);
    }

}

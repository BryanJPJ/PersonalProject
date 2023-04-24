package personalproject.demo.services;

import personalproject.demo.models.EmailMessage;

public interface SendMailService {
    void SendMail (String inputName, String inputPhone, String to, String from, String subject, String message);

    //Método que pide crear el controlador
    void save(EmailMessage emailMessage);



 
}

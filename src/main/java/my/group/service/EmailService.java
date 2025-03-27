package my.group.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.group.dto.EmailDTO;
import my.group.model.Email;
import my.group.repo.EmailRepo;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class EmailService {

    private final EmailRepo emailRepo;
    private final MailSender emailSender;

    public void sendSimpleMessage(String to, String subject, String body) throws MailException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("Q816QTHM@ya.ru");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        // Отправляем письмо
        emailSender.send(message);

        // Сохраняем письмо в базу данных
        Email emailEntity = new Email();
        emailEntity.setRecipient(to);
        emailEntity.setSubject(subject);
        emailEntity.setMessageBody(body);
        emailRepo.save(emailEntity);
    }
}

package my.group.controller;

import lombok.AllArgsConstructor;
import my.group.dto.EmailDTO;
import my.group.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@AllArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")
    public String SendEmailInAction(Model model, @RequestParam("to") String to,
                                    @RequestParam("subject") String subject,
                                    @RequestParam("body") String body) {

//        model.addAttribute(emailService.createEmail(emailDTO));

//        String toEmail = "Jonekarter85@gmail.com";
//        String subject = "Test Email from Spring Boot";
//        String body = "This is a simple test email.";

        emailService.sendSimpleMessage(to, subject, body);
        return "/home";
    }

    @GetMapping("/home")
    public String goHome() {
        return "/home";
    }

}

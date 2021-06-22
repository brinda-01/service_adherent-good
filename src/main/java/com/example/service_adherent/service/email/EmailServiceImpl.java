package com.example.service_adherent.service.email;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender sender;
    private final TemplateEngine engine;




    @Override
    public void sendParrainageLink(String destinataire,String token) {
        final MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {

            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(destinataire);
            messageHelper.setSubject("Demarrez votre inscription");
            String content = buildParrainageTemplate(token);
            messageHelper.setText(content,true);
        };
        sender.send(mimeMessagePreparator);
    }

    public String buildParrainageTemplate( String token){
        Context context = new Context(Locale.FRANCE);
        context.setVariable("sign",token);
        return engine.process("parrainageTemplate",context);
    }
}

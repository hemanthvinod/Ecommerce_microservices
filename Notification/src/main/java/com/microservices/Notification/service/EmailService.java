package com.microservices.Notification.service;


import com.microservices.Notification.domain.Product;
import com.microservices.Notification.service.resource.EmailTemplate;
import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.context.Context;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Async
    public void sendPaymentSuccessEmail(
            String destinationEmail,
            String customerName,
            BigDecimal amount,
            Long orderReference
    ) throws MessagingException {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            mimeMessageHelper.setFrom("Ecommerce_app@mail.com");
            final String templateName = EmailTemplate.PAYMENT_CONFIRMATION.getTemplate();
            Map<String, Object> values = new HashMap<>();
            values.put("CustomerName", customerName);
            values.put("amount", amount);
            values.put("orderReference", orderReference);

            Context context = new Context();
            context.setVariables(values);
            mimeMessageHelper.setSubject(EmailTemplate.PAYMENT_CONFIRMATION.getSubject());
            try{
                String htmlTemplate = templateEngine.process(templateName, context);
                mimeMessageHelper.setText(htmlTemplate, true);
                mimeMessageHelper.setTo(destinationEmail);
                mailSender.send(mimeMessage);
                log.info(String.format("Payment successful mail send to %s with template %s", customerName, templateName));
            }catch (MessagingException e){
                log.warn("Cannot send email to {}", destinationEmail);
            }
    }

    @Async
    public void sendOrderConfirmationEmail(
            String destinationEmail,
            String customerName,
            BigDecimal amount,
            Long orderReference,
            List<Product> products
    ) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
        mimeMessageHelper.setFrom("Ecommerce_app@mail.com");
        final String templateName = EmailTemplate.ORDER_CONFIRMATION.getTemplate();
        Map<String, Object> values = new HashMap<>();
        values.put("CustomerName", customerName);
        values.put("amount", amount);
        values.put("orderReference", orderReference);
        values.put("products", products);

        Context context = new Context();
        context.setVariables(values);
        mimeMessageHelper.setSubject(EmailTemplate.ORDER_CONFIRMATION.getSubject());
        try{
            String htmlTemplate = templateEngine.process(templateName, context);
            mimeMessageHelper.setText(htmlTemplate, true);
            mimeMessageHelper.setTo(destinationEmail);
            mailSender.send(mimeMessage);
            log.info(String.format("Order confirmation mail send to %s with template %s", customerName, templateName));
        }catch (MessagingException e){
            log.warn("Cannot send email to {}", destinationEmail);
        }
    }
}

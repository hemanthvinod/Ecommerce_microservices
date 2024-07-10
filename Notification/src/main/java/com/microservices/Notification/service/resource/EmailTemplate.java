package com.microservices.Notification.service.resource;
import lombok.Getter;
// understanding a particular use case of enum
// the constructor is by default private and we cannot make it public
public enum EmailTemplate {

    PAYMENT_CONFIRMATION("payment-confirmation.html", "Payment successfully processed"),
    ORDER_CONFIRMATION("order-confirmation.html","Order confirmation");
    @Getter
    private final String template;
    @Getter
    private final String subject;

    EmailTemplate(String template, String subject){
        this.template = template;
        this.subject = subject;
    }
}

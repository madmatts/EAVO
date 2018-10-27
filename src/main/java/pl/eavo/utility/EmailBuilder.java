package pl.eavo.utility;

import pl.eavo.model.Email;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmailBuilder {

    private Email email;

    public EmailBuilder() {
        this.email = new Email();
    }

    public EmailBuilder(Email email) {
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public EmailBuilder setTopic(String topic){
        this.email.setTopic(topic);
        return this;
    }

    public EmailBuilder setMessage(String message){
        this.email.setMessage(message);
        return this;
    }

    public EmailBuilder setRecipients(List<String> recipients){
        this.email.setRecipients(recipients);
        return this;
    }

    public EmailBuilder addRecipient(String recipient){
        this.email.addRecipant(recipient);
        return this;
    }

    public Email build(){
        return this.email;
    }
}

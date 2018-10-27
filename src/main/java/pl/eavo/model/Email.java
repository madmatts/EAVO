package pl.eavo.model;

import java.util.ArrayList;
import java.util.List;

public class Email {

    private String topic;
    private String message;
    private List<String> recipients;

    public Email(){
        recipients = new ArrayList<String>();
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    public void addRecipant(String emailAddress) {
        this.recipients.add(emailAddress);
    }

    public void clearRecipants() {
        this.recipients.clear();
    }

    public String getFirstRecipient() {
        return !this.recipients.isEmpty() ? this.recipients.get(0) : "";
    }
}

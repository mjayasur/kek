package ml.vernie.kek;

public class Message {
    private String body, sender, date;

    public Message(String body, String sender, String date) {
        this.body = body;
        this.sender = sender;
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public String getSender() {
        return sender;
    }

    public String getDate() {
        return date;
    }
}

package ru.mera.beyshatzade.postman;

public abstract class Message {
    private String from;
    private String to;
    private String message_body;

    public Message(String from, String to, String message_body) {
        this.from = from;
        this.to = to;
        this.message_body = message_body;
    }

    public String getmessage_body() {
        return message_body;
    }

    public String from() {
        return from;
    }

    public String to() {
        return to;
    }
}

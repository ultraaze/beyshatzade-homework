package ru.mera.beyshatzade.postman;

public class Letter extends Message {

    private String fromPostalIndex;
    private String toPostalIndex;

    public Letter(String from, String to, String message_body, String fromPostalIndex, String toPostalIndex) {
        super(from, to, message_body);
        this.fromPostalIndex = fromPostalIndex;
        this.toPostalIndex = toPostalIndex;
    }

    public String fromPostalIndex() {
        return fromPostalIndex;
    }


    public String toPostalIndex() {
        return toPostalIndex;
    }
}
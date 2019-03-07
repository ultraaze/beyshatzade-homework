package ru.mera.beyshatzade.postman;

public class Letter extends Message {
    private String fromPostalIndex;
    private String toPostalIndex;
    public Letter(String from, String to, String message_body, String fromPostalIndex, String toPostalIndex) {
        super(from, to, message_body);
        this.fromPostalIndex = fromPostalIndex;
        this.toPostalIndex = toPostalIndex;
    }
    public String getfromPostalIndex() {
        return fromPostalIndex;
    }
    public void setfromPostalIndex(String fromPostalIndex) {
        this.fromPostalIndex = fromPostalIndex;
    }
    public String gettoPostalIndex() {
        return toPostalIndex;
    }
    public void settoPostalIndex(String toPostalIndex) {
        this.toPostalIndex = toPostalIndex;
    }
}
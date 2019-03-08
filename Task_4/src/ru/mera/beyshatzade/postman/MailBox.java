package ru.mera.beyshatzade.postman;
import java.util.ArrayList;

public class MailBox {
    private ArrayList EmailArr = new ArrayList();
    private ArrayList LetterArr = new ArrayList();
    public void AddEmail(String from, String to, String message_body, String receive_date){
        Email New = new Email(from, to, message_body, receive_date);
        EmailArr.add("from: " + New.getfrom() + "; to: " + New.getto() + "; body: "+ New.getmessage_body() +
                "; date: " +  New.getreceive_date());
    }
    public void PrintEmail(){
        System.out.println("Все электронные письма: ");
        for (int i=0; i<EmailArr.size(); i++ ) {
            System.out.println((i+1)+": " + EmailArr.get(i));
        }
    }
    public void AddLetter(String from, String to, String message_body, String fromPostalIndex,
                                 String toPostalIndex){
        Letter New = new Letter(from, to, message_body, fromPostalIndex, toPostalIndex);
        LetterArr.add("from: " + New.getfrom() + "; to: " + New.getto() + "; body: "+ New.getmessage_body() +
                "; from-index: " +  New.getfromPostalIndex() + "; to-index: " +  New.gettoPostalIndex());
    }
    public void PrintLetter(){
        System.out.println("Все обычные письма: ");
        for (int i=0; i<LetterArr.size(); i++ ) {
            System.out.println((i+1)+": " + LetterArr.get(i));
        }
    }
}
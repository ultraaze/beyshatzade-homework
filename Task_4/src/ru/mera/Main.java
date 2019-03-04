import ru.mera.beyshatzade.postman.*;


public class Main {

    public static void main(String[] args) {


        MailBox.AddEmail("Саша","Митя","эл1","1992");
        MailBox.AddEmail("Петя","Лена","эл2","1921");
        MailBox.AddEmail("Аня","Соловей","эл3","1999");
        MailBox.PrintEmail();

        MailBox.AddLetter("Саша","Вася","Обычное1","600232", "60039");
        MailBox.AddLetter("Оля","Лена","Обычное2","600232", "600232");
        MailBox.PrintLetter();



    }
}

import ru.mera.beyshatzade.postman.*;

public class Main {
    public static void main(String[] args) {
        MailBox Test = new MailBox();
        Test.AddEmail("Саша","Митя","эл1","1992");
        Test.AddEmail("Петя","Лена","эл2","1921");
        Test.AddEmail("Аня","Соловей","эл3","1999");
        Test.PrintEmail();
        Test.AddLetter("Саша","Вася","Обычное1","600232", "60039");
        Test.AddLetter("Оля","Лена","Обычное2","600232", "600232");
        Test.PrintLetter();
    }
}
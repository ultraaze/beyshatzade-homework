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


        MailBox Test2 = new MailBox();
        Test2.AddEmail("Са33ша","Ми333тя","эл331","193392");
        Test2.AddEmail("Петя","Л33ена","эл2","193321");
        Test2.AddEmail("Аня","Солов33ей","эл333","193399");
        Test2.PrintEmail();

    }
}
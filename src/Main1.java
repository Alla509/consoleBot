import java.util.Scanner;

public class Main1 {

    public static void main(String[] args)
    {
        var scanner = new Scanner(System.in);
        System.out.println("Я бот, который определяет является ли число четным или нечетным");
        System.out.println("Введите целое число или /exit");
        while (true)
        {
            var i = scanner.nextLine();
            if (i.equalsIgnoreCase("/exit")){
                System.out.println("До встречи");
                break;
            }
            int num=Integer.parseInt(i);
            if (num%2==0) {
                System.out.println("Число четное");
            } else {
                System.out.println("Число нечетное");
            }
            System.out.println();
        }
    }
}
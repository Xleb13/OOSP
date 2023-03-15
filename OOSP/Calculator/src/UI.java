import java.util.Scanner;
public class UI {

    public void ui(){
        prescription();
        menu();
    }
    public void prescription(){
        System.out.println("********************Правила ввода*********************");
        System.out.println("-Числа и матеметические операторы вводить через пробел\n" +
                "-Дробные числа вводить через .\n" +
                "-Если в самом начале поставить отрицаельное число , то будет ошибка \n\n" );
    };
    public void menu(){
        System.out.println("---------------------Калькулятор----------------------");
        System.out.println("Чтобы открыть прошлые вычисления нажмите 1");
        System.out.println("Чтобы получить решение нажмите 2");
        System.out.println("Чтобы выйти нажмите 9");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n==1 | n==2 | n==9) {
            if (n == 1) {
                HistoryCalculations pastCalculatins = new HistoryCalculations();
                pastCalculatins.pastUr();
            }
            if (n == 2) {
                EquationCalculations op = new EquationCalculations();
                op.enub();
            }
            if (n == 9) {
                System.out.println("До Свидания");
                System.exit(0);
            }
        }
        else {
            System.out.println("Вы выбрали не существующие действие");
        }
    }
}

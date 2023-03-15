import java.util.ArrayList;
import java.util.Scanner;

public class HistoryCalculations {

    public static ArrayList<String> uravneny = new ArrayList<>();
    UI ui = new UI();
    public void uravneny(String n) {
        uravneny.add(n);
    }
    public void pastUr(){
        System.out.println("--------------- Прошлые вычисления ----------------\n" +
                           "--- Чтобы открыть недавние вычисления нажмите 1 ---\n" +
                           "----- Чтобы открыть все вычисления нажмите 2 ------\n" +
                           "---------- Чтобы выйти в меню нажмите 3 -----------");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n==1 | n==2 | n==3) {
            if (n == 1) {
                recentCalculations();
            }
            if (n == 2) {
                allCalculations();
            }
            if (n == 3 ){
                ui.menu();
            }
        }
        else {
            System.out.println("Вы выбрали не существующие действие");
        }
    }
    private void recentCalculations(){
        System.out.println("--------------- Недавние вычисления ---------------");
        for(String l : uravneny){
            System.out.println(l);
        }
        ui.menu();
    }
    private void allCalculations(){
        System.out.println("----------------- Все вычисления -----------------");
        NotePad notepad = new NotePad();
        notepad.readFile();
        ui.menu();
    }
}


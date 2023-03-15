import java.util.Scanner;

public class EquationCalculations {
    public static String equation;

    public void enub(){
        System.out.println("Введите уровнение :");
        Scanner scanner = new Scanner(System.in);
        equation = scanner.nextLine();

        Calculations calculations = new Calculations();
        calculations.calculate(equation);

        String nub = String.valueOf(calculations.calculate());
        System.out.println(equation + " = "+ nub);
        String n = equation + " = " + nub;

        HistoryCalculations past = new HistoryCalculations();
        past.uravneny(n);

        NotePad notePad = new NotePad();
        notePad.writingToFile(n);

        UI ui = new UI();
        ui.menu();

    }



}

import java.util.ArrayList;
public class HistoryCalculatins {

    public static ArrayList<String> equation = new ArrayList<>();
    public void uravneny(String n) {
        equation.add(n);
    }
    public void pastUr(){
        System.out.println("****************Прошлые вычисления****************");
        for(String l : equation){
            System.out.println(l);
        }
        UI ui = new UI();
        ui.menu();
    }
}


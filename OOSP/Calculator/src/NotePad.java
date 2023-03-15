import java.io.*;
public class NotePad {

public  void writingToFile(String n){
    File file = new File("text.txt");
    try{
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(n + "\n" );
        writer.close();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
public  void readFile(){
    try {
        BufferedReader br = null;
        br = new BufferedReader(new FileReader("text.txt"));
        String line;
        while ((line = br.readLine()) !=null){
            System.out.println(line);
        }
        br.close();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
}

package FileRecording;

import java.io.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader inputClients = new BufferedReader(new InputStreamReader(new FileInputStream(
                "C:\\Users\\Максим\\Desktop\\StudyingPractice\\FileRecording\\src\\Data\\client.txt")));
            BufferedWriter outputData = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                    "C:\\Users\\Максим\\Desktop\\StudyingPractice\\FileRecording\\src\\Data\\info.txt")))){
            int b;
            while((b = inputClients.read()) != -1){
                outputData.write(b);
            }
            outputData.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

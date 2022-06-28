import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
    public static String processRunner(ProcessBuilder processBuilder){
        StringBuilder output = new StringBuilder();
        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line+ "\n");
            }
            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!\n"+output.toString());
            } else {
                System.out.println("Failed:\n"+output.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    private static void createPR(String branch, String abc, String filePath, String commit) {
        ProcessBuilder processBuilder1 = new ProcessBuilder();
        processBuilder1.command("sh", "./GitScripts/PreGit.sh", "Data_Fix", "Data/", "Git Test");
        System.out.println(processBuilder1.command());
        processRunner(processBuilder1);
    }
}

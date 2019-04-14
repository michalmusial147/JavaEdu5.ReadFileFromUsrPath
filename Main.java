import java.util.Scanner;
import java.io.*;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
public class Main {

    private static void strange(String path) throws IOException{
        Scanner scan = new Scanner(new File(path));
        Random rand = new Random();
        String result = scan.nextLine().substring(0,Math.abs(rand.nextInt()%5)+1);
        System.out.println(result);
    }

    private static List<String> ReadFileNIO (String path) throws IOException{
        List<String> allLines = Files.readAllLines(Paths.get(path));;
        return allLines;
    }
    private static void WriteLineIO (String filename, String x) throws IOException{
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));
        outputWriter.write(x);
        outputWriter.flush();
        outputWriter.close();
    }
    private static void print(List<String> lines){
        for(String line : lines){
            System.out.println(line);
        }
    }
    public static void main(String[] args){
        String usr_path;
        List<String> AllLines;
        System.out.println("File path:");
        try{
            BufferedReader consoleRead = new BufferedReader(new InputStreamReader(System.in));
            usr_path = consoleRead.readLine();
            WriteLineIO("path.txt", usr_path);
            AllLines = ReadFileNIO(usr_path);
            print(AllLines);
            System.out.println("Press enter to continue");
            consoleRead.readLine();
            strange(usr_path);
        }
        catch(IOException e){
            System.out.println("IOException");
            return;
        }
    }
}

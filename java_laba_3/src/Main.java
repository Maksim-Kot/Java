import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("./input.txt");
        try {
            Scanner scanner = new Scanner(file);
            String line="";
            while (scanner.hasNextLine()) line += scanner.nextLine();
            SymbolFrequency freq = new SymbolFrequency(line);
            List<Character> a = freq.Calculate();
            for (int i = 0; i < a.size(); i++)
            {
                if (a.get(i).equals(' ')) System.out.println("space");
                else System.out.println(a.get(i));
            }



            FileWriter writer = new FileWriter("out.txt");
            for (int i = 0; i < a.size(); i++)
            {
                if (a.get(i).equals(' ')) writer.write("space");
                else writer.write(a.get(i) + " ");
            }

            writer.flush();

        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}

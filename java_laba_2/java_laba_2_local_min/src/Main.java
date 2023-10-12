import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter your matrix:");
        File file = new File("./input.txt");
        try {
            Scanner scanner = new Scanner(file);
            int n, m;
            n = scanner.nextInt();
            m = scanner.nextInt();
            int[][] Matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    Matrix[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    System.out.print(Matrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();


            LocalMinOfMatrix min = new LocalMinOfMatrix(n, m, Matrix);
            System.out.println("Amount of local min: " + min.Calculate());


            FileWriter writer = new FileWriter("out.txt");
            writer.write("Amount of local min: " + min.Calculate());
            writer.flush();

        }
        catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}

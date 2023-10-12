import java.io.*;
import java.text.NumberFormat;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Enter x and k:");
        Scanner scanner = new Scanner(System.in);
        double x;
        int k;
        x = scanner.nextDouble();
        k = scanner.nextInt();
        MathEquation a = new MathEquation(x, k);
        if(a.Range()){
            double result = a.Calculate();
            NumberFormat formatter = NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(k+1);
            System.out.println("Result: " + formatter.format(result));
        }
        else System.out.println("Incorrect range. Try again");
        System.out.println(Math.log(x + 1));
    }
}
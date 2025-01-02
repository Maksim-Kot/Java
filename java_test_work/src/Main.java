import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("./input.txt");
        Scanner scanner = new Scanner(file);
        Scanner scannerConcole = new Scanner(System.in);
        int amount = scanner.nextInt();
        ArrayOfHotels a = new ArrayOfHotels();
        String city, name;
        int stars;
        for(int i = 0; i < amount; i++)
        {
            city = scanner.next();
            name = scanner.next();
            stars = scanner.nextInt();
            a.AddHotel(city, name, stars);
        }

        a.SortingByTask();

        for(int i = 0; i < amount; i++)
        {
            System.out.println(a.GetHotel().get(i));
        }

        System.out.println("Enter city:");
        String neededCity = scannerConcole.next();
        ArrayList<Hotel> k = a.SameCity(neededCity);
        if(k.isEmpty()) System.out.println("No such variant");
        else
        {
            for(int i = 0; i < k.size(); i++)
            {
                System.out.println(k.get(i).toString());
            }
        }


        System.out.println("Enter name:");
        String neededName = scannerConcole.next();
        k = a.SameName(neededName);
        if(k.isEmpty()) System.out.println("No such variant");
        else
        {
            for(int i = 0; i < k.size(); i++)
            {
                System.out.println(k.get(i).toString());
            }
        }
    }
}
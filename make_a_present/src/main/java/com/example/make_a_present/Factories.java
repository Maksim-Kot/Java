package com.example.make_a_present;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Factories
{
    ArrayList<Factory> factories;

    public Factory Find(String name)
    {
        for(int i = 0; i < factories.size(); ++i)
        {
            if(factories.get(i).name.equals(name)) return factories.get(i);
        }
        return null;
    }

    public Factories() throws FileNotFoundException
    {
        factories = new ArrayList<>();
        File file = new File("./input.txt");
        Scanner scanner = new Scanner(file);
        int amount = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < amount; ++i)
        {
            String s = scanner.nextLine();
            int price = scanner.nextInt();
            scanner.nextLine();
            Factory fact = new Factory(s, price);
            for(int j = 0; j < 3; ++j)
            {
                s = scanner.nextLine();
                String regex = "\\d+";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(s);
                matcher.find();
                int start = matcher.start();
                Present pres = new Present(s.substring(0,start - 1), Integer.parseInt(s.substring(matcher.start(), matcher.end())));
                fact.AddPresent(pres);
            }
            if (scanner.hasNext()) scanner.nextLine();
            factories.add(fact);
        }
    }

    public Factories(String s) throws SQLException, ClassNotFoundException {
        DBConnector DBCon = new DBConnector();
        DBCon.connect();
        factories = DBCon.returnArray();
        DBCon.close();
    }
}

class Factory
{
    String name;
    ArrayList<Present> presents;
    int priceForConcert;

    public Factory(String name, int priceForConcert)
    {
        this.name = name;
        this.priceForConcert = priceForConcert;
        presents = new ArrayList<>();
    }

    public void AddPresent(Present a)
    {
        presents.add(a);
    }

    public int Find(String name)
    {
        for(int i = 0; i < presents.size(); ++i)
        {
            if(presents.get(i).name.equals(name)) return presents.get(i).price;
        }
        return -1;
    }

}
class Present
{
    String name;
    int price;

    public Present(String name, int price)
    {
        this.name = name;
        this.price = price;
    }
}

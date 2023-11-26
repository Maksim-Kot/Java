package com.example.make_a_present;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnector {
    static Connection co;
    static ArrayList<Factory> factories = new ArrayList<>();

    void connect() throws SQLException, ClassNotFoundException {
        //Class.forName("org.sqlite.JDBC");
        co = DriverManager.getConnection("jdbc:sqlite:presents.db");
        System.out.println("Connected");
    }

    void close() throws SQLException {
        co.close();
        System.out.println("Closed");
    }

    public static void read() throws SQLException {
        Statement statement = co.createStatement();
        String query = "SELECT * FROM Factories ORDER BY NameOfFactory";
        ResultSet rs = statement.executeQuery(query);
        Factory a = null;
        Boolean start = true;
        String s = null;
        while(rs.next())
        {
            String nameOfFactory = rs.getString("NameOfFactory");
            String nameOfPresent = rs.getString("NameOfPresent");
            int cost = rs.getInt("Cost");
            if(start)
            {
                s = nameOfFactory;
                a = new Factory(s, 30);
                Present b = new Present(nameOfPresent, cost);
                a.presents.add(b);
                start = false;
                continue;
            }
            if(s.equals(nameOfFactory))
            {
                Present b = new Present(nameOfPresent, cost);
                a.presents.add(b);
            }
            else
            {
                factories.add(a);
                s = nameOfFactory;
                a = new Factory(s, 30);
                Present b = new Present(nameOfPresent, cost);
                a.presents.add(b);
            }
        }
        factories.add(a);
        rs.close();
        statement.close();
    }

    public ArrayList<Factory> returnArray() throws SQLException {
        read();
        return factories;
    }

}


package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Calc
{
    public double res = 0;
    public String s="";

    String answer()
    {
        String regex = "\\d*[.,]?\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find())
        {
            int start = matcher.start();
            if(start<1)
            {
                res += Double.parseDouble(s.substring(matcher.start(), matcher.end()));
            }
            else if(s.charAt(start-1) == '+')
            {
                res += Double.parseDouble(s.substring(matcher.start(), matcher.end()));
            }
            else if(s.charAt(start-1) == '-')
            {
                res -= Double.parseDouble(s.substring(matcher.start(), matcher.end()));
            }
            else if(s.charAt(start-1) == '*')
            {
                res *= Double.parseDouble(s.substring(matcher.start(), matcher.end()));
            }
            else
            {
                if(0 == Double.parseDouble(s.substring(matcher.start(), matcher.end()))) return "You cant divide by zero";
                res /= Double.parseDouble(s.substring(matcher.start(), matcher.end()));
            }
        }
        s = Double.toString(res);
        res = 0;
        return s;
    }

}

public class HelloController {
    @FXML
    private Label welcomeText;

    Calc calc = new Calc();
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void on1ButtonClick() {
        calc.s += "1";
        welcomeText.setText(calc.s);
    }

    @FXML
    protected void on2ButtonClick() {
        calc.s += "2";
        welcomeText.setText(calc.s);
    }

    @FXML
    protected void on3ButtonClick() {
        calc.s += "3";
        welcomeText.setText(calc.s);
    }

    @FXML
    protected void on4ButtonClick() {
        calc.s += "4";
        welcomeText.setText(calc.s);
    }

    @FXML
    protected void on5ButtonClick() {
        calc.s += "5";
        welcomeText.setText(calc.s);
    }

    @FXML
    protected void on6ButtonClick() {
        calc.s += "6";
        welcomeText.setText(calc.s);
    }

    @FXML
    protected void on7ButtonClick() {
        calc.s += "7";
        welcomeText.setText(calc.s);
    }

    @FXML
    protected void on8ButtonClick() {
        calc.s += "8";
        welcomeText.setText(calc.s);
    }

    @FXML
    protected void on9ButtonClick() {
        calc.s += "9";
        welcomeText.setText(calc.s);
    }

    @FXML
    protected void on0ButtonClick() {
        calc.s += "0";
        welcomeText.setText(calc.s);
    }

    @FXML
    protected void onplusButtonClick() {
        calc.s += "+";
        welcomeText.setText(calc.s);
    }
    @FXML
    protected void onminusButtonClick() {
        calc.s += "-";
        welcomeText.setText(calc.s);
    }

    @FXML
    protected void onequalButtonClick() {
        welcomeText.setText(calc.answer());
    }

    @FXML
    protected void onmultButtonClick() {
        calc.s += "*";
        welcomeText.setText(calc.s);
    }


    @FXML
    protected void ondotButtonClick() {
        calc.s += ".";
        welcomeText.setText(calc.s);
    }

    @FXML
    protected void ondivButtonClick() {
        calc.s += "/";
        welcomeText.setText(calc.s);
    }

    @FXML
    protected void onbackButtonClick() {
        if(!calc.s.isEmpty()) calc.s = calc.s.substring(0, calc.s.length() -1);
        welcomeText.setText(calc.s);
    }

}
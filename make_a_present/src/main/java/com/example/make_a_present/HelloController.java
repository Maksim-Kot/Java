package com.example.make_a_present;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private CheckBox Modum;
    @FXML
    private CheckBox OZ;
    @FXML
    private CheckBox Gift;
    @FXML
    private CheckBox Card;
    @FXML
    private CheckBox Letter;
    @FXML
    private CheckBox Toy;
    @FXML
    private CheckBox Concert;
    @FXML
    private CheckBox Regular;

    private Factories a;

    private ArrayList<CheckBox> boxesFactory = new ArrayList<>();
    private ArrayList<CheckBox> boxesGifts = new ArrayList<>();


    @FXML
    protected void onModumButtonClick()
    {
        if(Modum.getText().equals("")) Modum.setSelected(false);
        OZ.setSelected(false);
        Gift.setSelected(false);
        String s = Modum.getText();
        Factory b = a.Find(s);
        for(int i = 0; i < 3; ++i)
        {
            boxesGifts.get(i).setText("");
        }
        for(int i = 0; i < b.presents.size(); ++i)
        {
            boxesGifts.get(i).setText(b.presents.get(i).name);
        }
        //Modum.setSelected(false);
    }

    @FXML
    protected void onOZButtonClick()
    {
        if(OZ.getText().equals("")) OZ.setSelected(false);
        Gift.setSelected(false);
        Modum.setSelected(false);
        String s = OZ.getText();
        Factory b = a.Find(s);
        for(int i = 0; i < 3; ++i)
        {
            boxesGifts.get(i).setText("");
        }
        for(int i = 0; i < b.presents.size(); ++i)
        {
            boxesGifts.get(i).setText(b.presents.get(i).name);
        }
    }

    @FXML
    protected void onGiftButtonClick()
    {
        if(Gift.getText().equals("")) Gift.setSelected(false);
        OZ.setSelected(false);
        //Gift.setSelected(false);
        Modum.setSelected(false);
        String s = Gift.getText();
        Factory b = a.Find(s);
        for(int i = 0; i < 3; ++i)
        {
            boxesGifts.get(i).setText("");
        }
        for(int i = 0; i < b.presents.size(); ++i)
        {
            boxesGifts.get(i).setText(b.presents.get(i).name);
        }
    }

    @FXML
    protected void onGenerateButtonClick() throws FileNotFoundException, SQLException, ClassNotFoundException {
        a = new Factories("base");
        boxesFactory.add(Modum);
        boxesFactory.add(OZ);
        boxesFactory.add(Gift);
        boxesGifts.add(Toy);
        boxesGifts.add(Letter);
        boxesGifts.add(Card);
        for(int i = 0; i <a.factories.size(); ++i)
        {
            boxesFactory.get(i).setText(a.factories.get(i).name);
        }
    }
    @FXML
    protected void onHelloButtonClick() throws FileNotFoundException {
        welcomeText.setText("Welcome to JavaFX Application!");
        Factories a = new Factories();
        double res = 0;
        if(Modum.isSelected())
        {
            String s = Modum.getText();
            if(Card.isSelected()) res += a.Find(s).Find(Card.getText());
            if(Letter.isSelected()) res += a.Find(s).Find(Letter.getText());
            if(Toy.isSelected()) res += a.Find(s).Find(Toy.getText());
            if(Concert.isSelected()) res += a.Find(s).priceForConcert;
        } else if(OZ.isSelected())
        {
            if(Card.isSelected()) res += a.Find(OZ.getText()).Find(Card.getText());
            if(Letter.isSelected()) res += a.Find(OZ.getText()).Find(Letter.getText());
            if(Toy.isSelected()) res += a.Find(OZ.getText()).Find(Toy.getText());
            if(Concert.isSelected()) res += a.Find(OZ.getText()).priceForConcert;
        } else if(Gift.isSelected())
        {
            if(Card.isSelected()) res += a.Find(Gift.getText()).Find(Card.getText());
            if(Letter.isSelected()) res += a.Find(Gift.getText()).Find(Letter.getText());
            if(Toy.isSelected()) res += a.Find(Gift.getText()).Find(Toy.getText());
            if(Concert.isSelected()) res += a.Find(Gift.getText()).priceForConcert;
        }
        if(Regular.isSelected()) res *= 0.9;
        welcomeText.setText(Double.toString(res));
    }
}
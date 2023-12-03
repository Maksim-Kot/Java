package com.example.spring_project;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Route("")
public class MainView extends VerticalLayout {
    private Grid<Present> grid = new Grid<>(Present.class, false);

    private String nameFactory;

    private Factories factories;

    public MainView() throws FileNotFoundException, SQLException, ClassNotFoundException {

        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.addColumn(Present::getName).setHeader("Name");
        grid.addColumn(Present::getPrice).setHeader("Price");

        Set<Present> need = new HashSet<>();

        ComboBox<String> comboBox = new ComboBox<>();
        ComboBox<String> comboBoxBase = new ComboBox<>();
        comboBoxBase.setItems("TXT", "Data base");
        comboBoxBase.addValueChangeListener(event -> {
            if (event.getValue() != null) {
                if(event.getValue().equals("TXT"))
                {
                    try {
                        factories = new Factories();
                        comboBox.setItems(factories.getNames());
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(event.getValue().equals("Data base"))
                {
                    try {
                        factories = new Factories("base");
                        comboBox.setItems(factories.getNames());
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                System.out.println("value is null");
            }
        });

        grid.addSelectionListener(selection -> {
            need.clear();
            need.addAll(selection.getAllSelectedItems());
            System.out.printf("Number of selected people: %s%n",
                    selection.getAllSelectedItems().size());
        });


        comboBox.addValueChangeListener(event -> {
            if (event.getValue() != null) {
                nameFactory = event.getValue().toString();
                System.out.println(event.getValue().toString());
                grid.setItems(factories.Find(event.getValue().toString()).presents);
            } else {
                System.out.println("value is null");
            }
        });


        var layout = new HorizontalLayout();
        layout.setAlignItems(Alignment.BASELINE);
        var text = new TextField();
        var regular = new Checkbox("Regular");
        var concert = new Checkbox("Concert");
        var addButton = new Button("Calculate");
        addButton.addClickShortcut(Key.ENTER);
        addButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layout.add(concert, regular, addButton, text);

        addButton.addClickListener(click -> {
            double res = 0;
            Iterator<Present> iterator = need.iterator();
            for (Present present : need) {
                System.out.println(present); // выводит все элементы в произвольном порядке
                res += present.getPrice();
            }
            if(concert.getValue()) res += factories.Find(nameFactory).priceForConcert;
            if(regular.getValue()) res *= 0.9;
            text.setValue(Double.toString(res));
        });

        var layoutUp = new HorizontalLayout();
        layout.setAlignItems(Alignment.BASELINE);
        layoutUp.add(comboBoxBase, comboBox);
        add(layoutUp, grid, layout);
    }
}

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

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Route("")
public class MainView extends VerticalLayout {
    private Grid<Present> grid = new Grid<>(Present.class, false);

    public MainView() throws FileNotFoundException {

        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.addColumn(Present::getName).setHeader("Name");
        grid.addColumn(Present::getPrice).setHeader("Price");

        Set<Present> need = new HashSet<>();
        Factories factories = new Factories();

        grid.addSelectionListener(selection -> {
            need.clear();
            need.addAll(selection.getAllSelectedItems());
            System.out.printf("Number of selected people: %s%n",
                    selection.getAllSelectedItems().size());
        });

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setItems(factories.getNames());
        comboBox.addValueChangeListener(event -> {
            if (event.getValue() != null) {
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



        add(comboBox, grid, layout);
    }
}

module com.example.make_a_present {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.make_a_present to javafx.fxml;
    exports com.example.make_a_present;
}
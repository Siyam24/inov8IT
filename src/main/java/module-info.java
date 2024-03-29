module org.example.sujithajewellerymanagement {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens org.example.sujithajewellerymanagement to javafx.fxml;
    exports org.example.sujithajewellerymanagement;
}
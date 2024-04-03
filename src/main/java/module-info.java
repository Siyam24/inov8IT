module org.example.goldmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.goldmanagementsystem to javafx.fxml;
    opens Models to javafx.base;



    exports org.example.goldmanagementsystem;
}
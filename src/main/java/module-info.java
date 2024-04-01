module org.example.goldmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.goldmanagementsystem to javafx.fxml;



    exports org.example.goldmanagementsystem;
}
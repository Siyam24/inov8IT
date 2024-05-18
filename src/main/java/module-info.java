module org.example.goldmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.mail;
    requires java.desktop;
    requires com.google.zxing;
    requires com.google.zxing.javase;
     requires itextpdf;
    requires json.simple;
    requires kernel;
    requires io;
    requires layout;


    opens org.example.goldmanagementsystem to javafx.fxml;
    opens Models to javafx.base;



    exports org.example.goldmanagementsystem;
}
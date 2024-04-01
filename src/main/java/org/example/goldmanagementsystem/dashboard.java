package org.example.goldmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.goldmanagementsystem.HelloApplication;

import java.io.IOException;
public class dashboard {

    @FXML
    private Button logout;
public void userlogout(ActionEvent event) throws IOException{
    HelloApplication h=new HelloApplication();
    h.changeScene("src/main/resources/hello-view.fxml");
}
}

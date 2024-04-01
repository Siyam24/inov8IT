package org.example.goldmanagementsystem;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.IOException;

public class login {
 public login(){

 }
    @FXML
    private Button sbutton;
    @FXML
    private Label wronglogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void userLogin(ActionEvent event) throws IOException{
        checkLogin();
    }
    private void checkLogin() throws IOException{
        HelloApplication m=new HelloApplication();
        if(username.getText().toString().equals("javacoding")&&password.getText().toString().equals("123")){
            wronglogin.setText("Success!");

            Parent root=FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Stage stage=new Stage();
            stage.setTitle("Dashboard");
            stage.setScene(new Scene(root));

            stage.show();

            sbutton.getScene().getWindow().hide();

        }
        else if (username.getText().isEmpty()&&password.getText().isEmpty()){
            wronglogin.setText("Please enter your data");
        }
        else {
            wronglogin.setText("Wrong username or password");
        }
    }
}



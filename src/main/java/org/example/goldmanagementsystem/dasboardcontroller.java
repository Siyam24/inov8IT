package org.example.goldmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class dasboardcontroller implements Initializable {



    @FXML
    private AnchorPane Dashboard_form;

    @FXML
    private AnchorPane Employee_form;

    @FXML
    private AnchorPane Gold_TransactionsForm;

    @FXML
    private AnchorPane MasterdataManagementform;

    @FXML
    private AnchorPane Transactionnew_form;

    @FXML
    private AnchorPane accessories_form;

    @FXML
    private AnchorPane allowances_form;

    @FXML
    private AnchorPane analytics_form;

    @FXML
    private Button analyticsbtn;

    @FXML
    private AnchorPane billing_form;

    @FXML
    private Button billingbtn;

    @FXML
    private Button close;

    @FXML
    private AnchorPane customer_form;

    @FXML
    private Button dasboardbtn;

    @FXML
    private AnchorPane deduction_form;

    @FXML
    private AnchorPane inquiry_form;

    @FXML
    private Button inquirybtn;

    @FXML
    private AnchorPane inventory_form;

    @FXML
    private Button m_accessbtn;

    @FXML
    private Button m_cudbtn;

    @FXML
    private Button m_employeebtn;

    @FXML
    private Button m_invenbtn;

    @FXML
    private Button m_openbalbtn;

    @FXML
    private Button m_prodbtn;

    @FXML
    private Button masterdatamanagementbtn;

    @FXML
    private AnchorPane oderform;

    @FXML
    private AnchorPane openingbalances_form;

    @FXML
    private Button ordermanagementbtn;

    @FXML
    private Button p_allowancebtn;

    @FXML
    private Button p_deductionbtn;

    @FXML
    private Button p_paybtn;

    @FXML
    private Button p_saadvanbtn;

    @FXML
    private Button p_salaryincrementbtn;

    @FXML
    private AnchorPane payment_form;

    @FXML
    private AnchorPane payroll_form;

    @FXML
    private Button payrollbtn;

    @FXML
    private AnchorPane protype_tem_form;

    @FXML
    private AnchorPane salaryadvance_form;

    @FXML
    private AnchorPane salaryincrement_form;

    @FXML
    private Button transactionnewbtn;
    /*public void switchform(ActionEvent event){

        if(event.getSource()==dasboardbtn){
            Dashboard_form.setVisible(true);
            Transactionnew_form.setVisible(false);
            MasterdataManagementform.setVisible(false);
            oderform.setVisible(false);
            billing_form.setVisible(false);
            payroll_form.setVisible(false);
            analytics_form.setVisible(false);
            inquiry_form.setVisible(false);

        }
        else if(event.getSource()==transactionnewbtn){
            Dashboard_form.setVisible(false);
            Transactionnew_form.setVisible(true);
            MasterdataManagementform.setVisible(false);
            oderform.setVisible(false);
            billing_form.setVisible(false);
            payroll_form.setVisible(false);
            analytics_form.setVisible(false);
            inquiry_form.setVisible(false);
        }
        else if(event.getSource()==masterdatamanagementbtn){
            Dashboard_form.setVisible(false);
            Transactionnew_form.setVisible(false);
            MasterdataManagementform.setVisible(true);
            oderform.setVisible(false);
            billing_form.setVisible(false);
            payroll_form.setVisible(false);
            analytics_form.setVisible(false);
            inquiry_form.setVisible(false);
        }
        else if(event.getSource()==ordermanagementbtn){
            Dashboard_form.setVisible(false);
            Transactionnew_form.setVisible(false);
            MasterdataManagementform.setVisible(false);
            oderform.setVisible(true);
            billing_form.setVisible(false);
            payroll_form.setVisible(false);
            analytics_form.setVisible(false);
            inquiry_form.setVisible(false);
        }
        else if(event.getSource()==billingbtn){
            Dashboard_form.setVisible(false);
            Transactionnew_form.setVisible(false);
            MasterdataManagementform.setVisible(false);
            oderform.setVisible(false);
            billing_form.setVisible(true);
            payroll_form.setVisible(false);
            analytics_form.setVisible(false);
            inquiry_form.setVisible(false);
        }
        else if(event.getSource()==payrollbtn){
            Dashboard_form.setVisible(false);
            Transactionnew_form.setVisible(false);
            MasterdataManagementform.setVisible(false);
            oderform.setVisible(false);
            billing_form.setVisible(false);
            payroll_form.setVisible(true);
            analytics_form.setVisible(false);
            inquiry_form.setVisible(false);
        }
        else if(event.getSource()==analyticsbtn){
            Dashboard_form.setVisible(false);
            Transactionnew_form.setVisible(false);
            MasterdataManagementform.setVisible(false);
            oderform.setVisible(false);
            billing_form.setVisible(false);
            payroll_form.setVisible(false);
            analytics_form.setVisible(true);
            inquiry_form.setVisible(false);
        }
        else if(event.getSource()==inquirybtn){
            Dashboard_form.setVisible(false);
            Transactionnew_form.setVisible(false);
            MasterdataManagementform.setVisible(false);
            oderform.setVisible(false);
            billing_form.setVisible(false);
            payroll_form.setVisible(false);
            analytics_form.setVisible(false);
            inquiry_form.setVisible(true);
        }
        else if(event.getSource()==p_allowancebtn){
            Dashboard_form.setVisible(false);
            Transactionnew_form.setVisible(false);
            MasterdataManagementform.setVisible(false);
            oderform.setVisible(false);
            billing_form.setVisible(false);
            payroll_form.setVisible(false);
            analytics_form.setVisible(false);
            inquiry_form.setVisible(false);
            allowances_form.setVisible(true);
        }

    }*/

    public void close(){
        System.exit(0);
    }



public void logout(){
    try{
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are You Sure You Want to Logout?");
        Optional<ButtonType> option=alert.showAndWait();

        if(option.equals(ButtonType.OK)){


            Parent root= FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Stage stage=new Stage();
            Scene scene=new Scene(root);

            stage.setScene(scene);
            stage.show();

        }
    }catch (Exception e){e.printStackTrace();
}}
    public void switchform(ActionEvent event){
        Dashboard_form.setVisible(false);
        Transactionnew_form.setVisible(false);
        MasterdataManagementform.setVisible(false);
        oderform.setVisible(false);
        billing_form.setVisible(false);
        payroll_form.setVisible(false);
        analytics_form.setVisible(false);
        inquiry_form.setVisible(false);
        allowances_form.setVisible(false);
        deduction_form.setVisible(false);
        salaryincrement_form.setVisible(false);
        salaryadvance_form.setVisible(false);
        payment_form.setVisible(false);
        Employee_form.setVisible(false);
        customer_form.setVisible(false);
        protype_tem_form.setVisible(false);
        accessories_form.setVisible(false);
        inventory_form.setVisible(false);
        openingbalances_form.setVisible(false);


        if (event.getSource() == dasboardbtn) {
            Dashboard_form.setVisible(true);
        } else if (event.getSource() == transactionnewbtn) {
            Transactionnew_form.setVisible(true);
        } else if (event.getSource() == masterdatamanagementbtn) {
            MasterdataManagementform.setVisible(true);
        } else if (event.getSource() == ordermanagementbtn) {
            oderform.setVisible(true);
        } else if (event.getSource() == billingbtn) {
            billing_form.setVisible(true);
        } else if (event.getSource() == payrollbtn) {
            payroll_form.setVisible(true);
        } else if (event.getSource() == analyticsbtn) {
            analytics_form.setVisible(true);
        } else if (event.getSource() == inquirybtn) {
            inquiry_form.setVisible(true);
        } else if (event.getSource() == p_allowancebtn) {
            allowances_form.setVisible(true);
        } else if (event.getSource() == p_deductionbtn) {
            deduction_form.setVisible(true);
        } else if (event.getSource() == p_salaryincrementbtn) {
            salaryincrement_form.setVisible(true);
        } else if (event.getSource() == p_saadvanbtn) {
            salaryadvance_form.setVisible(true);
        } else if (event.getSource() == p_paybtn) {
            payment_form.setVisible(true);
        }else if (event.getSource() == m_employeebtn) {
            Employee_form.setVisible(true);
        }
        else if (event.getSource() == m_cudbtn) {
            customer_form.setVisible(true);
        }
        else if (event.getSource() == m_prodbtn) {
            protype_tem_form.setVisible(true);
        }
        else if (event.getSource() == m_accessbtn) {
            accessories_form.setVisible(true);
        }
        else if (event.getSource() == m_invenbtn) {
            inventory_form.setVisible(true);
        }
        else if (event.getSource() == m_openbalbtn) {
            openingbalances_form.setVisible(true);
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

package org.example.goldmanagementsystem;

import Models.Customer;
import Models.databaseConnection;
import javafx.beans.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

public class dasboardcontroller implements Initializable {




    @FXML
    private ToggleGroup Cash;

    @FXML
    private TableView<Customer> CusDet_Table;

    @FXML
    private AnchorPane Dashboard_form;

    @FXML
    private ToggleGroup Deduction;

    @FXML
    private TableColumn<?, ?> Emp_Det_Col_Address;

    @FXML
    private TableColumn<?, ?> Emp_Det_Col_Email;

    @FXML
    private TableColumn<?, ?> Emp_Det_Col_Empname;

    @FXML
    private TableColumn<?, ?> Emp_Det_Col_NICno;

    @FXML
    private TableColumn<?, ?> Emp_Det_Col_Salary;

    @FXML
    private TableColumn<?, ?> Emp_Det_Col_TelNo;

    @FXML
    private TextField Emp_Det_TX_Address;

    @FXML
    private TextField Emp_Det_TX_Email;

    @FXML
    private TextField Emp_Det_TX_Empname;

    @FXML
    private TextField Emp_Det_TX_NICNo;

    @FXML
    private TextField Emp_Det_TX_Salary;

    @FXML
    private TextField Emp_Det_TX_TelNo;

    @FXML
    private Button Emp_Det_btn_Clear;

    @FXML
    private Button Emp_Det_btn_Update;

    @FXML
    private Button Emp_Det_btn_add;

    @FXML
    private Button Emp_Det_btn_delete;

    @FXML
    private TextField Emp_det_search;

    @FXML
    private AnchorPane Employee_form;

    @FXML
    private ToggleGroup Gold;

    @FXML
    private AnchorPane MasterdataManagementform;

    @FXML
    private ToggleGroup Opening_balance;

    @FXML
    private ToggleGroup Opening_balance1;

    @FXML
    private AnchorPane Transactionnew_form;

    @FXML
    private AnchorPane accessories_form;

    @FXML
    private TextField addCusDet_CusAdd;

    @FXML
    private TextField addCusDet_CusEmail;

    @FXML
    private TextField addCusDet_CusNICno;

    @FXML
    private TextField addCusDet_CusTelno;

    @FXML
    private TextField addCusDet_Cusname;

    @FXML
    private TableColumn<Customer,String> addCus_col_Address;

    @FXML
    private TableColumn<Customer,String> addCus_col_NICno;

    @FXML
    private TableColumn<Customer,String> addCus_col_TelNo;

    @FXML
    private TableColumn<Customer,String> addCus_col_email;

    @FXML
    private TableColumn<Customer,String> addCus_col_name;

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
    private Button signout;

    @FXML
    private Button transactionnewbtn;

    @FXML
    private ToggleGroup update;




    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;
    public ObservableList<Customer> addCustomerData(){
        ObservableList<Customer> listData = FXCollections.observableArrayList();
        String sql="SELECT * FROM customer";

        connect= databaseConnection.getConnection();

        try {
            prepare=connect.prepareStatement(sql);
            result=prepare.executeQuery();
            Customer customerd;

            while (result.next()){
                customerd=new Customer(result.getString("cusName"),
                        result.getString("cusNIC"),
                        result.getString("cusContact"),
                        result.getString("cusEmail"),
                        result.getString("cusAddress"));

                listData.add(customerd);


            }
        }catch (Exception e){e.printStackTrace();}
        return listData;

    }



    private ObservableList<Customer>addCustomer;
    public void addCustomerShowListData(){
        addCustomer=addCustomerData();



        addCus_col_name.setCellValueFactory(new PropertyValueFactory<>("cusName"));
        addCus_col_NICno.setCellValueFactory(new PropertyValueFactory<>("NICno"));
        addCus_col_TelNo.setCellValueFactory(new PropertyValueFactory<>("telNo"));
        addCus_col_email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        addCus_col_Address.setCellValueFactory(new PropertyValueFactory<>("Address"));


        CusDet_Table.setItems(addCustomer);


    }

    public void addCustomerSelect(){
        Customer customerd=CusDet_Table.getSelectionModel().getSelectedItem();
        int num=CusDet_Table.getSelectionModel().getSelectedIndex();

        if((num-1)< -1) {return;}

        addCusDet_Cusname.setText(String.valueOf(customerd.getCusName()));
        addCusDet_CusNICno.setText(String.valueOf(customerd.getNICno()));
        addCusDet_CusTelno.setText(String.valueOf(customerd.getTelNo()));
        addCusDet_CusEmail.setText(String.valueOf(customerd.getEmail()));
        addCusDet_CusAdd.setText(String.valueOf(customerd.getAddress()));




    }

   /* public void addCustomerAdd(){
        String sql="INSERT INTO customer"
                +" (cusName,cusNIC,cusContact,cusEmail,cusAddress)"
                +"VALUES (?,?,?,?,?)";

        connect= databaseConnection.getConnection();

        try {
            Alert alert;
            if(addCusDet_Cusname.getText().isEmpty()
               ||addCusDet_CusNICno.getText().isEmpty()
                ||  addCusDet_CusTelno.getText().isEmpty()
                ||   addCusDet_CusEmail.getText().isEmpty()
                ||   addCusDet_CusNICno.getText().isEmpty())
            {
                alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else {





                prepare = connect.prepareStatement(sql);
                prepare.setString(1, addCusDet_Cusname.getText());
                prepare.setString(2, addCusDet_CusNICno.getText());
                prepare.setString(3, addCusDet_CusTelno.getText());
                prepare.setString(4, addCusDet_CusEmail.getText());
                prepare.setString(5, addCusDet_CusAdd.getText());

                prepare.executeUpdate();
                alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText(" Successfully Added");
                alert.showAndWait();

                addCustomerShowListData();
                addcustomerClear();


            }

        }catch (Exception e){e.printStackTrace();
        }
    }*/
   /*public void addCustomerAdd() {
       String sqlCheck = "SELECT * FROM customer WHERE cusName = ?";
       String sqlInsert = "INSERT INTO customer (cusName, cusNIC, cusContact, cusEmail, cusAddress) VALUES (?, ?, ?, ?, ?)";

       connect = databaseConnection.getConnection();

       try {
           Alert alert;
           if (addCusDet_Cusname.getText().isEmpty() ||
                   addCusDet_CusNICno.getText().isEmpty() ||
                   addCusDet_CusTelno.getText().isEmpty() ||
                   addCusDet_CusEmail.getText().isEmpty() ||
                   addCusDet_CusNICno.getText().isEmpty()) {
               alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Error Message");
               alert.setHeaderText(null);
               alert.setContentText("Please fill all blank fields");
               alert.showAndWait();
           } else {
               // Check if customer with the same name already exists
               prepare = connect.prepareStatement(sqlCheck);
               prepare.setString(1, addCusDet_Cusname.getText());
               ResultSet result = prepare.executeQuery();
               if (result.next()) {
                   alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Error Message");
                   alert.setHeaderText(null);
                   alert.setContentText("Customer with the same name already exists");
                   alert.showAndWait();
                   return; // Exit method if customer already exists
               }

               // Insert new customer if not already existing
               prepare = connect.prepareStatement(sqlInsert);
               prepare.setString(1, addCusDet_Cusname.getText());
               prepare.setString(2, addCusDet_CusNICno.getText());
               prepare.setString(3, addCusDet_CusTelno.getText());
               prepare.setString(4, addCusDet_CusEmail.getText());
               prepare.setString(5, addCusDet_CusAdd.getText());

               prepare.executeUpdate();
               alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Information Message");
               alert.setHeaderText(null);
               alert.setContentText("Successfully Added");
               alert.showAndWait();

               addCustomerShowListData();
               addcustomerClear();
           }

       } catch (Exception e) {
           e.printStackTrace();
       }
   }*/
   public void addCustomerAdd() {
       String sqlCheck = "SELECT * FROM customer WHERE cusName = ?";
       String sqlInsert = "INSERT INTO customer (cusName, cusNIC, cusContact, cusEmail, cusAddress) VALUES (?, ?, ?, ?, ?)";

       connect = databaseConnection.getConnection();

       try {
           Alert alert;
           if (addCusDet_Cusname.getText().isEmpty() ||
                   addCusDet_CusNICno.getText().isEmpty() ||
                   addCusDet_CusTelno.getText().isEmpty() ||
                   addCusDet_CusEmail.getText().isEmpty() ||
                   addCusDet_CusNICno.getText().isEmpty()) {
               alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Error Message");
               alert.setHeaderText(null);
               alert.setContentText("Please fill all blank fields");
               alert.showAndWait();
           } else {
               // Check if customer with the same name already exists
               prepare = connect.prepareStatement(sqlCheck);
               prepare.setString(1, addCusDet_Cusname.getText());
               ResultSet result = prepare.executeQuery();
               if (result.next()) {
                   alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Error Message");
                   alert.setHeaderText(null);
                   alert.setContentText("Customer with the same name already exists");
                   alert.showAndWait();
                   return; // Exit method if customer already exists
               }

               // Validate email
               String email = addCusDet_CusEmail.getText();
               if (!isValidEmail(email)) {
                   alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Error Message");
                   alert.setHeaderText(null);
                   alert.setContentText("Invalid email format");
                   alert.showAndWait();
                   return; // Exit method if email is invalid
               }

               // Validate NIC
               String nic = addCusDet_CusNICno.getText();
               if (!isValidNIC(nic)) {
                   alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Error Message");
                   alert.setHeaderText(null);
                   alert.setContentText("Invalid NIC format");
                   alert.showAndWait();
                   return; // Exit method if NIC is invalid
               }

               // Validate telephone number
               String telNo = addCusDet_CusTelno.getText();
               if (!isValidTelNo(telNo)) {
                   alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Error Message");
                   alert.setHeaderText(null);
                   alert.setContentText("Invalid telephone number format");
                   alert.showAndWait();
                   return; // Exit method if telephone number is invalid
               }


               // Insert new customer if validations pass
               prepare = connect.prepareStatement(sqlInsert);
               prepare.setString(1, addCusDet_Cusname.getText());
               prepare.setString(2, nic);
               prepare.setString(3, addCusDet_CusTelno.getText());
               prepare.setString(4, email);
               prepare.setString(5, addCusDet_CusAdd.getText());

               prepare.executeUpdate();
               alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Information Message");
               alert.setHeaderText(null);
               alert.setContentText("Successfully Added");
               alert.showAndWait();

               addCustomerShowListData();
               addcustomerClear();
           }

       } catch (Exception e) {
           e.printStackTrace();
       }
   }

    private boolean isValidEmail(String email) {
        // Email validation regex
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    private boolean isValidNIC(String nic) {
        // NIC validation regex for 12 digits OR 9 digits followed by v, V, x, or X
        String nicRegex = "^[0-9]{12}$|^[0-9]{9}[vVxX]$";
        return nic.matches(nicRegex);
    }
    private boolean isValidTelNo(String telNo) {
        // Telephone number validation regex
        String telNoRegex = "^[0-9]{10}$"; // Assuming 10 digits for telephone number
        return telNo.matches(telNoRegex);
    }






    public void addCustomerDelete(){
        Customer customer = CusDet_Table.getSelectionModel().getSelectedItem();
        if (customer == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select a customer to delete");
            alert.showAndWait();
            return;
        }

        String sql = "DELETE FROM customer WHERE cusName = ?";
        connect = databaseConnection.getConnection();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, customer.getCusName());
            prepare.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Customer deleted successfully");
            alert.showAndWait();

            addCustomerShowListData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addcustomerClear(){
        addCusDet_Cusname.setText("");
        addCusDet_CusNICno.setText("");
        addCusDet_CusTelno.setText("");
        addCusDet_CusEmail.setText("");
        addCusDet_CusAdd.setText("");


    }




    public void close(){
        System.exit(0);
    }

    private double x=0;
    private double y=0;

public void logout(){
    try{
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are You Sure You Want to Logout?");
        Optional<ButtonType> option=alert.showAndWait();

        if(option.get().equals(ButtonType.OK)){

            signout.getScene().getWindow().hide();


            Parent root= FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Stage stage=new Stage();
            Scene scene=new Scene(root);



            root. setOnMousePressed ( (MouseEvent event) -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
                root. setOnMouseDragged ( (MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8f);
                });
                    root. setOnMouseReleased ( (MouseEvent event) ->{
                        stage. setOpacity (1);
                    });

            stage.initStyle(StageStyle.TRANSPARENT);

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
        addCustomerShowListData();

    }
}

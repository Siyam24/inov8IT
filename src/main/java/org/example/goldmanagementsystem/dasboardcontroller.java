package org.example.goldmanagementsystem;

import Models.*;


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
import java.sql.SQLException;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;




import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
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
    @FXML
    private TableColumn<Order,String> Order_col_Customer;

    @FXML
    private TableColumn<Order,LocalDate> Order_col_Date;

    @FXML
    private TableColumn<Order,String> Order_col_Employee;

    @FXML
    private TableColumn<Order,String> Order_col_Item;

    @FXML
    private TableColumn<Order,Integer> Order_col_QTY;

    @FXML
    private TableColumn<Order,String> Order_col_Weight;

    @FXML
    private DatePicker Order_date;

    @FXML
    private ComboBox<String> Order_tx_Customer;


    @FXML
    private ComboBox<String> Order_tx_Employee;

    @FXML
    private Spinner<Integer> Order_tx_QTY;

    @FXML
    private TextField Order_tx_Weight;

    @FXML
    private TextField Order_tx_item;

    @FXML
    private TableView<Order> Order_Table;
    @FXML
    private TableView<Allowances> AllowanceDetailTable;

    @FXML
    private TableColumn<Allowances, Integer> empIDColumn;
    @FXML
    private TableColumn<Allowances, Integer> empNameColumn;
    @FXML
    private TableColumn<Allowances, Double> BsalaryColumn;
    @FXML
    private TableColumn<Allowances, Integer> totalOTColumn;
    @FXML
    private TableColumn<Allowances, Integer> ratesPerHrColumn;
    @FXML
    private TableColumn<Allowances, Integer> totalAmountColumn;

    @FXML
    public Button clearbtnAllowances;

    @FXML
    private Label employeeNameLabel;

    @FXML
    private Label allowanceLabel;

    @FXML
    private TextField txtAllowancesEmpID;

    @FXML
    private TextField txtAllowancesEmpName;

    @FXML
    private TextField txtAllowancesBSalary;
    @FXML
    private TextField txtAllowancesTotalOT;
    @FXML
    private TextField txtAllowancesRatesperHr;
    @FXML
    private TextField txtAllowancesTotalamount;
    @FXML
    private Button CTbtnclear;
    @FXML
    private Button CTadd;

    @FXML
    private Button CTbtndelete;

    @FXML
    private Button CTbtnupdate;

    @FXML
    private TableColumn<CashTransaction, Integer> CTcolamount;

    @FXML
    private TableColumn<CashTransaction, Date> CTcoldate;

    @FXML
    private TableColumn<CashTransaction, String> CTcolname;

    @FXML
    private TableColumn<CashTransaction, String> CTcolrole;

    @FXML
    private TableColumn<CashTransaction, String> CTcoltype;

    @FXML
    private TableView<CashTransaction> CTtable;

    @FXML
    private TextField CTtxtAmount;

    @FXML
    private DatePicker CTtxtDate;

    @FXML
    private TextField CTtxtName;

    @FXML
    private TextField CTtxtRole;

    @FXML
    private TextField CTtxtType;
    @FXML
    private Button btnInvCatAdd;

    @FXML
    private Button btnInvCatClear;

    @FXML
    private Button btnInvCatDelete;

    @FXML
    private Button btnInvCatUpdate;

    @FXML
    private TableColumn<InventoryCategory, String> colInvCatId;

    @FXML
    private TableColumn<InventoryCategory, String> colInvCatName;

    @FXML
    private TableView<InventoryCategory> tableInvCat;

    @FXML
    private TextField txtInvCatName;

    @FXML
    private TextField txtInvTypeCategory;

    @FXML
    private TextField txtInvTypeName;

    @FXML
    private TextField txtInvTypeQty;

    @FXML
    private TextField txtInvTypeStatus;

    @FXML
    private TableColumn<InventoryType, Integer> colInvTypeId;


    @FXML
    private TableColumn<InventoryType, String> colInvTypeCat;

    @FXML
    private TableColumn<InventoryType, String> colInvTypeName;

    @FXML
    private TableColumn<InventoryType, Integer> colInvTypeQty;

    @FXML
    private TableColumn<InventoryType, String> colInvTypeStatus;

    @FXML
    private TableView<InventoryType> tableInvType;
    @FXML
    private Button btnInvTypeAdd;

    @FXML
    private Button btnInvTypeClear;

    @FXML
    private Button btnInvTypeDelete;

    @FXML
    private Button btnInvTypeUpdate;
    @FXML
    private Button addbtnAllowances;
    @FXML
    private Button calculatebtnAllowances;






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
               orderCusId();
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

    //********************************************* SHAMINI **********************************************//
    public void orderCusId(){
        String sql="SELECT cusName FROM customer ";
        connect= databaseConnection.getConnection();
        try {
            prepare=connect.prepareStatement(sql);
            result=prepare.executeQuery();

            ObservableList<String> listData=FXCollections.observableArrayList(); // Specify the type of items in the list

            while (result.next()){
                listData.add(result.getString("cusName"));
            }

            Order_tx_Customer.getItems().clear(); // Clear the existing items
            Order_tx_Customer.getItems().addAll(listData); // Add the new items

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void orderEmpId(){
        String sql="SELECT empName FROM employee ";
        connect= databaseConnection.getConnection();
        try{
            prepare=connect.prepareStatement(sql);
            result=prepare.executeQuery();

            ObservableList<String> listData=FXCollections.observableArrayList(); // Specify the type of items in the list

            while (result.next()){
                listData.add(result.getString("empName"));
            }

            Order_tx_Employee.getItems().clear(); // Clear the existing items
            Order_tx_Employee.getItems().addAll(listData); // Add the new items

        }catch (Exception e){
            e.printStackTrace();
        }
    }



    private SpinnerValueFactory<Integer> spinner;
    public void orderSpinner(){
        spinner=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,50,0);

        Order_tx_QTY.setValueFactory(spinner);
    }

    private int qty;
    public void orderQuantity() {
        qty=Order_tx_QTY.getValue();

        System.out.println(qty);
    }


    public ObservableList<Order> addOrderdata(){
        ObservableList<Order> listData = FXCollections.observableArrayList();
        String sql = "SELECT date, cusID, empID, item, qty, weight FROM orderDetails";

        try (Connection connect = databaseConnection.getConnection();
             PreparedStatement prepare = connect.prepareStatement(sql);
             ResultSet result = prepare.executeQuery()) {

            while (result.next()) {
                Order orderd = new Order(result.getDate("date").toLocalDate(),
                        result.getString("cusID"),
                        result.getString("empID"),
                        result.getString("item"),
                        result.getInt("qty"),
                        result.getString("weight"));

                listData.add(orderd);
            }

            // Populate combo boxes
            ObservableList<String> customerNames = FXCollections.observableArrayList();
            ObservableList<String> employeeNames = FXCollections.observableArrayList();

            for (Order order : listData) {
                if (!customerNames.contains(order.getCusName())) {
                    customerNames.add(order.getCusName());
                }
                if (!employeeNames.contains(order.getEmpName())) {
                    employeeNames.add(order.getEmpName());
                }
            }

            // Set combo box items

                Order_tx_Customer.setItems(customerNames);
                Order_tx_Employee.setItems(employeeNames);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }



    private ObservableList<Order>addOrderList;
    public void addOrderShowListData(){
        addOrderList=addOrderdata();



        Order_col_Date.setCellValueFactory(new PropertyValueFactory<>("date"));
        Order_col_Customer.setCellValueFactory(new PropertyValueFactory<>("CusName"));
        Order_col_Employee.setCellValueFactory(new PropertyValueFactory<>("EmpName"));
        Order_col_Item.setCellValueFactory(new PropertyValueFactory<>("Item"));
        Order_col_QTY.setCellValueFactory(new PropertyValueFactory<>("QTY"));
        Order_col_Weight.setCellValueFactory(new PropertyValueFactory<>("Weight"));


        Order_Table.setItems(addOrderList);


    }
    public void addOrderSelect(){
        Order orderd=Order_Table.getSelectionModel().getSelectedItem();
        int num=Order_Table.getSelectionModel().getSelectedIndex();

        if((num-1)< -1) {return;}

        Order_date.setValue(orderd.getDate());
        Order_tx_Customer.getSelectionModel().select(orderd.getCusName());
        Order_tx_Employee.getSelectionModel().select(orderd.getEmpName());
        Order_tx_item.setText(orderd.getItem());
        Order_tx_QTY.getValueFactory().setValue(orderd.getQTY());
        Order_tx_Weight.setText(String.valueOf(orderd.getWeight()));

    }


    public void addOrder() {
        Date date = new Date();
        String sqlCheck = "SELECT * FROM orderDetails WHERE empID = ?";

        String sqlInsert = "INSERT INTO orderDetails (date, cusID, empID, item, qty, weight) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        connect = databaseConnection.getConnection();

        try {
            Alert alert;
            if (Order_date.getValue() == null ||
                    Order_tx_Customer.getSelectionModel().isEmpty() ||
                    Order_tx_Employee.getSelectionModel().isEmpty() ||
                    Order_tx_item.getText().isEmpty() ||
                    Order_tx_QTY.getValue() == null ||
                    Order_tx_Weight.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all fields");
                alert.showAndWait();
            } else {
                // Check if an order for the same employee already exists
                prepare = connect.prepareStatement(sqlCheck);
                prepare.setString(1, Order_tx_Employee.getSelectionModel().getSelectedItem());
                ResultSet result = prepare.executeQuery();
                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("An order for this employee already exists");
                    alert.showAndWait();
                    return; // Exit method if order for this employee already exists
                }

                // Validate quantity (QTY) as integer
                int qty = Order_tx_QTY.getValue();


                // Validate weight as decimal or integer
                double weight;
                try {
                    weight = Double.parseDouble(Order_tx_Weight.getText());
                } catch (NumberFormatException ex) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Weight should be a decimal or integer");
                    alert.showAndWait();
                    return; // Exit method if weight is not a decimal or integer
                }

                // Insert new order if validations pass
                prepare = connect.prepareStatement(sqlInsert);
                prepare.setDate(1, java.sql.Date.valueOf(Order_date.getValue()));
                prepare.setString(2, Order_tx_Customer.getSelectionModel().getSelectedItem());
                prepare.setString(3, Order_tx_Employee.getSelectionModel().getSelectedItem());
                prepare.setString(4, Order_tx_item.getText());
                prepare.setInt(5, qty);
                prepare.setDouble(6, weight);

                prepare.executeUpdate();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added");
                alert.showAndWait();



                addOrderShowListData();
                addOrderClear();

                refreshComboBoxes();


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addOrderClear() {
        Order_date.setValue(null);
        Order_tx_Customer.getSelectionModel().clearSelection();
        Order_tx_Employee.getSelectionModel().clearSelection();
        Order_tx_item.setText("");
        Order_tx_QTY.getValueFactory().setValue(0);
        Order_tx_Weight.setText("");
    }


    public void OrderDelete() {
        Order order = Order_Table.getSelectionModel().getSelectedItem();
        if (order == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select an order to delete");
            alert.showAndWait();
            return;
        }

        String sql = "DELETE FROM orderDetails WHERE item = ?";
        connect = databaseConnection.getConnection();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, order.getItem());
            prepare.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Order deleted successfully");
            alert.showAndWait();

            // Update the table view and clear the selection
            addOrderShowListData();

            // Refresh the combo box lists
            refreshComboBoxes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void refreshComboBoxes() {
        ObservableList<String> customerNames = FXCollections.observableArrayList();
        ObservableList<String> employeeNames = FXCollections.observableArrayList();

        // Get customer names from the customer table
        String customerSql = "SELECT cusName FROM customer";
        try (Connection connect = databaseConnection.getConnection();
             PreparedStatement customerPrepare = connect.prepareStatement(customerSql);
             ResultSet customerResult = customerPrepare.executeQuery()) {

            while (customerResult.next()) {
                customerNames.add(customerResult.getString("cusName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Get employee names from the employee table
        String employeeSql = "SELECT empName FROM employee";
        try (Connection connect = databaseConnection.getConnection();
             PreparedStatement employeePrepare = connect.prepareStatement(employeeSql);
             ResultSet employeeResult = employeePrepare.executeQuery()) {

            while (employeeResult.next()) {
                employeeNames.add(employeeResult.getString("empName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Order_tx_Customer.setItems(customerNames);
        Order_tx_Employee.setItems(employeeNames);
    }








    public void close(){
        System.exit(0);
    }

    private double x=0;
    private double y=0;

public void logout() {
    try {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are You Sure You Want to Logout?");
        Optional<ButtonType> option = alert.showAndWait();

        if (option.get().equals(ButtonType.OK)) {

            signout.getScene().getWindow().hide();


            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);


            root.setOnMousePressed((MouseEvent event) -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            root.setOnMouseDragged((MouseEvent event) -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);

                stage.setOpacity(.8f);
            });
            root.setOnMouseReleased((MouseEvent event) -> {
                stage.setOpacity(1);
            });

            stage.initStyle(StageStyle.TRANSPARENT);

            stage.setScene(scene);
            stage.show();

        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    /*//////////////////////////Amina***********************************/

    /* -------------------Allowances Part---------------------------------------------------------*/





    // Add other TextField variables as needed
//-------------------------------Clear button function-------------------------------

@FXML
   private void clearFieldsA(ActionEvent actionEvent) {
        txtAllowancesEmpID.setText("");
        txtAllowancesEmpName.setText("");
        txtAllowancesBSalary.setText("");
        txtAllowancesTotalOT.setText("");
        txtAllowancesRatesperHr.setText("");
        txtAllowancesTotalamount.setText("");

    }

    //-------------------Calculate Button function---------------------------------
    @FXML
    private void calculateTotalAmount(ActionEvent event) {
        try {
            double basicSalary = Double.parseDouble(txtAllowancesBSalary.getText());
            double totalOT = Double.parseDouble(txtAllowancesTotalOT.getText());
            double ratesPerHour = Double.parseDouble(txtAllowancesRatesperHr.getText());
            double totalAmount = basicSalary + (totalOT * ratesPerHour);

            txtAllowancesTotalamount.setText(Double.toString(totalAmount));
        } catch (NumberFormatException e) {
            txtAllowancesTotalamount.setText("Invalid Input");
        }
    }
    //------------- ADD button function-------------------------------//



    private Connection connects;
    private Statement statements;
    private PreparedStatement prepares;
    private ResultSet results;

    public ObservableList<Allowances> addSalaryAllowanceData() {
        ObservableList<Allowances> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM salaryAllowance";

        connects = databaseConnection.getConnection();
        try {
            prepares = connects.prepareStatement(sql);
            results = prepares.executeQuery();
            Allowances allowanced;

            while (result.next()) {
                allowanced = new Allowances(result.getInt("EmpID"),
                        result.getString("EmpName"),
                        result.getDouble("Bsalary"),
                        result.getInt("TotalOT"),
                        result.getDouble("RatePerHr"),
                        result.getDouble("TotalAmount"));

                listData.add(allowanced);
            }

        } catch (Exception e) {e.printStackTrace();}
        return listData;
    }
    private ObservableList<Allowances> addSalaryAllowance;
    public void addSalaryAllowanceShowListData() {

        addSalaryAllowance = addSalaryAllowanceData();

        empIDColumn.setCellValueFactory(new PropertyValueFactory<>("EmpID"));
        empNameColumn.setCellValueFactory(new PropertyValueFactory<>("EmpName"));
        BsalaryColumn.setCellValueFactory(new PropertyValueFactory<>("Bsalary"));
        totalOTColumn.setCellValueFactory(new PropertyValueFactory<>("TotalOT"));
        ratesPerHrColumn.setCellValueFactory(new PropertyValueFactory<>("RatePerHr"));
        totalAmountColumn.setCellValueFactory(new PropertyValueFactory<>("TotalAmount"));

        AllowanceDetailTable.setItems(addSalaryAllowance);
    }
    public void addSalaryAllowanceSelect() {
        Allowances allowanced = AllowanceDetailTable.getSelectionModel().getSelectedItem();
        int num = AllowanceDetailTable.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        txtAllowancesEmpID.setText(String.valueOf(allowanced.getEmpID()));
        txtAllowancesEmpName.setText(allowanced.getEmpName());
        txtAllowancesBSalary.setText(String.valueOf(allowanced.getBsalary()));
        txtAllowancesTotalOT.setText(String.valueOf(allowanced.getTotalOT()));
        txtAllowancesRatesperHr.setText(String.valueOf(allowanced.getRatePerHr()));
        txtAllowancesTotalamount.setText(String.valueOf(allowanced.getTotalAmount()));
    }

    public void addAllowance() {
        String sqlCheck = "SELECT * FROM salaryAllowance WHERE EmpID = ?";
        String sqlInsert = "INSERT INTO salaryAllowance (EmpID, EmpName, Bsalary, TotalOT, RatePerHr,TotalAmount) VALUES (?, ?, ?, ?, ?,?)";

        connects = databaseConnection.getConnection();

        // Insert new customer if validations pass
        try {
            prepares = connects.prepareStatement(sqlInsert);
            prepares.setInt(1, Integer.parseInt(txtAllowancesEmpID.getText()));
            prepares.setString(2, txtAllowancesEmpName.getText());
            prepares.setDouble(3, Double.parseDouble(txtAllowancesBSalary.getText()));
            prepares.setInt(4, Integer.parseInt(txtAllowancesTotalOT.getText()));
            prepares.setDouble(5, Double.parseDouble(txtAllowancesRatesperHr.getText()));
            prepares.setDouble(6, Double.parseDouble(txtAllowancesTotalamount.getText()));

            prepares.executeUpdate();
            addSalaryAllowanceShowListData();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText("Successfully Added");
        alert.showAndWait();

        addSalaryAllowanceShowListData();

    }
/*888---------------------------------------------------------Nitishe------------------------------------------------------------*/
Connection con = null;
    PreparedStatement st = null;
    ResultSet rs =null;
    public ObservableList<CashTransaction>getCashtransaction(){
        ObservableList<CashTransaction> cashTransactions = FXCollections.observableArrayList();

        String query = "select * from cashTransection";
        con = databaseConnection.getConnection();
        try {
            st=con.prepareStatement(query);
            rs =st.executeQuery();
            while(rs.next()){
                CashTransaction st = new CashTransaction();
                st.setCTDate(rs.getDate("date").toLocalDate());
                st.setCTRole(rs.getString("role"));
                st.setCTAmount(rs.getInt("transectionAmount"));
                st.setCTName(rs.getString("name"));
                st.setCTType(rs.getString("transectionType"));




                cashTransactions.add(st);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cashTransactions;
    }

    private ObservableList<CashTransaction>getCashtransaction;

    public void showCashTransaction(){
        getCashtransaction = getCashtransaction();
        //table.setItems(list);

        CTcoldate.setCellValueFactory(new PropertyValueFactory<CashTransaction,Date>("CTDate"));
        CTcolrole.setCellValueFactory(new PropertyValueFactory<CashTransaction,String>("CTRole"));
        CTcolamount.setCellValueFactory(new PropertyValueFactory<CashTransaction,Integer>("CTAmount"));
        CTcolname.setCellValueFactory(new PropertyValueFactory<CashTransaction,String>("CTName"));
        CTcoltype.setCellValueFactory(new PropertyValueFactory<CashTransaction,String>("CTType"));

        CTtable.setItems(getCashtransaction);



    }

    @FXML
    void createCT(ActionEvent event) {
        String insert = "insert into cashTransection(transectionType,transectionAmount,name,date,role) values(?,?,?,?,?)";
        con = databaseConnection.getConnection();
        try {
            st=con.prepareStatement(insert);
            st.setString(1,CTtxtType.getText());
            st.setDouble(2, Double.parseDouble(CTtxtAmount.getText()));
            st.setString(3,CTtxtName.getText());
            st.setDate(4, java.sql.Date.valueOf(CTtxtDate.getValue()));
            st.setString(5,CTtxtRole.getText());
            st.executeUpdate();
            showCashTransaction();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void getData(MouseEvent event) {
        CashTransaction cashTransaction = CTtable.getSelectionModel().getSelectedItem();
        int num=CTtable.getSelectionModel().getSelectedIndex();

        if((num-1)<-1){return;}
        CTtxtType.setText(cashTransaction.getCTType());
        CTtxtAmount.setText(String.valueOf(cashTransaction.getCTAmount()));
        CTtxtName.setText(cashTransaction.getCTName());
        CTtxtDate.setValue(cashTransaction.getCTDate());
        CTtxtRole.setText(cashTransaction.getCTRole());
    }

    @FXML
    void deleteCT(ActionEvent event) {
        String delete = "delete from cashTransection where id= ?";
        con = databaseConnection.getConnection();
        try {
            st = con.prepareStatement(delete);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void updateCT(ActionEvent event) {
        String update = "update cashTransection set transectionType=?,transectionAmount=?,name=?,date=?,role=?";
        con =databaseConnection.getConnection();
        try {
            st = con.prepareStatement(update);
            st.setString(1,CTtxtType.getText());
            st.setString(2,CTtxtAmount.getText());
            st.setInt(3, Integer.parseInt(CTtxtAmount.getText()));
            st.setString(4,CTtxtAmount.getText());
            st.setDate(5, java.sql.Date.valueOf(CTtxtDate.getValue()));
            st.setString(6,CTtxtRole.getText());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





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



//----------------------------------------Siyam--------------------------------------------------------------------/

PreparedStatement pst;
@FXML
void addInvCat(ActionEvent event) {
    String catName = txtInvCatName.getText().trim(); // Trim to remove leading/trailing whitespace

    if (!catName.isEmpty()) { // Check if the category name is not empty
        try {
            pst = connect.prepareStatement("INSERT INTO inventoryCat(category) VALUES (?)");
            pst.setString(1, catName);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Inventory category added successfully");
            alert.showAndWait();

            tableInventoryCat();

            txtInvCatName.setText("");
            txtInvCatName.requestFocus();

        } catch (Exception ex) {
            ex.printStackTrace();
            // Handle database or insertion errors
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error Message");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Error adding inventory category: " + ex.getMessage());
            errorAlert.showAndWait();
        }
    } else {
        // Show a warning if the category name is empty
        Alert warningAlert = new Alert(Alert.AlertType.WARNING);
        warningAlert.setTitle("Warning");
        warningAlert.setHeaderText(null);
        warningAlert.setContentText("Please enter a category name.");
        warningAlert.showAndWait();
    }
}

public void tableInventoryCat(){

    int[] myIndex = new int[1];
    int[] id = new int[1];
    ObservableList<InventoryCategory> inventoryCategories = FXCollections.observableArrayList();

    try {
        pst = connect.prepareStatement("SELECT id,category from inventoryCat");
        ResultSet rs = pst.executeQuery();
        {
            while (rs.next()){
                InventoryCategory it = new InventoryCategory();

                it.setId(rs.getString("id"));
                it.setName(rs.getString("category"));
                inventoryCategories.add(it);
            }
        }
        tableInvCat.setItems(inventoryCategories);
        colInvCatId.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getId()));
        colInvCatName.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getName()));

    }catch (Exception ex){
        ex.printStackTrace();
    }

    tableInvCat.setRowFactory(tv -> {
        TableRow<InventoryCategory> myRow = new TableRow<>();
        myRow.setOnMouseClicked(event ->
        {
            if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                myIndex[0] = tableInvCat.getSelectionModel().getSelectedIndex();
                id[0] = Integer.parseInt(String.valueOf(tableInvCat.getItems().get(myIndex[0]).getId()));
                txtInvCatName.setText(tableInvCat.getItems().get(myIndex[0]).getName());
            }
        });
        return myRow;
    });
}

@FXML
void updateInvCat(ActionEvent event) {
    String name;
    int myIndex;
    int id;

    myIndex = tableInvCat.getSelectionModel().getSelectedIndex();

    id = Integer.parseInt(String.valueOf(tableInvCat.getItems().get(myIndex).getId()));

    name = txtInvCatName.getText();
    try
    {
        pst = connect.prepareStatement("update inventoryCat set category = ? where id = ? ");
        pst.setString(1, name);
        pst.setInt(2, id);
        pst.executeUpdate();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText("Inventory category updated successfully");
        alert.showAndWait();

        tableInventoryCat();

    }
    catch (Exception ex)
    {
        ex.printStackTrace();
    }
}

@FXML
void deleteInvCat(ActionEvent event) {
    int myIndex;
    int id;

    myIndex = tableInvCat.getSelectionModel().getSelectedIndex();

    id = Integer.parseInt(String.valueOf(tableInvCat.getItems().get(myIndex).getId()));

    try
    {
        pst = connect.prepareStatement("delete from inventoryCat where id = ? ");
        pst.setInt(1, id);
        pst.executeUpdate();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText("Inventory category deleted successfully");
        alert.showAndWait();

        tableInventoryCat();

    }
    catch (Exception ex)
    {
        ex.printStackTrace();
    }
}

@FXML
void clearInvCat(ActionEvent event) {
    txtInvCatName.setText("");
}


//Inventory Type
@FXML
void addInvType(ActionEvent event) {
    String category,name,status;
    int qty;

    category = txtInvTypeCategory.getText();
    name = txtInvTypeName.getText();
    status = txtInvTypeStatus.getText();
    qty = Integer.parseInt(txtInvTypeQty.getText());

    try
    {
        pst = connect.prepareStatement("insert into inventory(inventoryName,inventoryCat,inventoryQty,inventoryStatus)values(?,?,?,?)");
        pst.setString(1, name);
        pst.setString(2, category);
        pst.setString(3, String.valueOf(qty));
        pst.setString(4, status);
        pst.executeUpdate();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText("Inventory type added successfully");
        alert.showAndWait();

        tableInventoryType();

    }
    catch (Exception ex)
    {
        ex.printStackTrace();
    }
}

public void tableInventoryType() {
    int[] myIndex = new int[1];
    int[] idType = new int[1];

    ObservableList<InventoryType> inventoryTypes = FXCollections.observableArrayList();

    try {
        pst = connect.prepareStatement("SELECT id,inventoryName,inventoryCat,inventoryQty,inventoryStatus from inventory");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            InventoryType it = new InventoryType();

            it.setId(Integer.parseInt(rs.getString("id")));
            it.setName(rs.getString("inventoryName"));
            it.setCategory(rs.getString("inventoryCat"));
            it.setQuantity(rs.getInt("inventoryQty"));
            it.setStatus(rs.getString("inventoryStatus"));
            inventoryTypes.add(it);
        }
        tableInvType.setItems(inventoryTypes);
        colInvTypeId.setCellValueFactory(f -> {
            int quantity = f.getValue().idProperty();
            return new SimpleIntegerProperty(quantity).asObject();
        });
        colInvTypeName.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().nameProperty()));
        colInvTypeCat.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().categoryProperty()));
        colInvTypeQty.setCellValueFactory(f -> {
            int quantity = f.getValue().quantityProperty();
            return new SimpleIntegerProperty(quantity).asObject();
        });
        colInvTypeStatus.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().statusProperty()));

    } catch (Exception ex) {
        ex.printStackTrace();
    }

    tableInvType.setRowFactory(tv -> {
        TableRow<InventoryType> myRow = new TableRow<>();
        myRow.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                myIndex[0] = tableInvType.getSelectionModel().getSelectedIndex();
                idType[0] = Integer.parseInt(String.valueOf(tableInvType.getItems().get(myIndex[0]).getId()));
                txtInvTypeName.setText(tableInvType.getItems().get(myIndex[0]).getName());
                txtInvTypeCategory.setText(tableInvType.getItems().get(myIndex[0]).getCategory());
                txtInvTypeQty.setText(String.valueOf(tableInvType.getItems().get(myIndex[0]).getQuantity()));
                txtInvTypeStatus.setText(tableInvType.getItems().get(myIndex[0]).getStatus());
            }
        });
        return myRow;
    });
}

@FXML
void updateInvType(ActionEvent event) {
    int myIndex = tableInvType.getSelectionModel().getSelectedIndex();

    if (myIndex >= 0) { // Check if an item is selected
        try {
            int id = Integer.parseInt(String.valueOf(tableInvType.getItems().get(myIndex).getId()));

            String name = txtInvTypeName.getText();
            String category = txtInvTypeCategory.getText();
            String status = txtInvTypeStatus.getText();
            int qty = Integer.parseInt(txtInvTypeQty.getText());

            pst = connect.prepareStatement("UPDATE inventory SET inventoryName = ?, inventoryCat = ?, inventoryQty = ?, inventoryStatus = ? WHERE id = ?");
            pst.setString(1, name);
            pst.setString(2, category);
            pst.setInt(3, qty);
            pst.setString(4, status);
            pst.setInt(5, id);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Inventory type updated successfully");
            alert.showAndWait();

            tableInventoryType();

        } catch (SQLException | NumberFormatException ex) {
            ex.printStackTrace();
            // Handle database or parsing errors
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error Message");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Error updating inventory type: " + ex.getMessage());
            errorAlert.showAndWait();
        }
    } else {
        // If no item is selected, show a warning message
        Alert warningAlert = new Alert(Alert.AlertType.WARNING);
        warningAlert.setTitle("Warning Message");
        warningAlert.setHeaderText(null);
        warningAlert.setContentText("Please select an inventory type to update.");
        warningAlert.showAndWait();
    }
}



@FXML
void deleteInvType(ActionEvent event) {
    int myIndex = tableInvType.getSelectionModel().getSelectedIndex();

    if (myIndex >= 0) { // Check if an item is selected
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText("Delete Inventory Type");
        confirmationAlert.setContentText("Are you sure you want to delete this inventory type?");

        Optional<ButtonType> result = confirmationAlert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                int id = Integer.parseInt(String.valueOf(tableInvType.getItems().get(myIndex).getId()));

                pst = connect.prepareStatement("DELETE FROM inventory WHERE id = ?");
                pst.setInt(1, id);
                pst.executeUpdate();

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Success");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Inventory type deleted successfully");
                successAlert.showAndWait();

                tableInventoryType();
            } catch (SQLException | NumberFormatException ex) {
                ex.printStackTrace();
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Error deleting inventory type: " + ex.getMessage());
                errorAlert.showAndWait();
            }
        }
    } else {
        Alert warningAlert = new Alert(Alert.AlertType.WARNING);
        warningAlert.setTitle("Warning");
        warningAlert.setHeaderText(null);
        warningAlert.setContentText("Please select an inventory type to delete.");
        warningAlert.showAndWait();
    }
}


@FXML
void clearInvType(ActionEvent event) {
    txtInvTypeCategory.setText("");
    txtInvTypeName.setText("");
    txtInvTypeStatus.setText("");
    txtInvTypeQty.setText("");
}
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addCustomerShowListData();
        addOrderShowListData();
        orderCusId();
        orderEmpId();
        orderSpinner();
        tableInventoryCat();
        tableInventoryType();
        addSalaryAllowanceShowListData();

    }
}

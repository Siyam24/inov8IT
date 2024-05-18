package org.example.goldmanagementsystem;

import Models.*;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.*;
import java.util.regex.Pattern;

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
    private AnchorPane Employee_form;


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
    private TableColumn<Customer, String> addCus_col_Address;

    @FXML
    private TableColumn<Customer, String> addCus_col_NICno;

    @FXML
    private TableColumn<Customer, String> addCus_col_TelNo;

    @FXML
    private TableColumn<Customer, String> addCus_col_email;

    @FXML
    private TableColumn<Customer, String> addCus_col_name;

    @FXML
    private AnchorPane allowances_form;

    @FXML
    private AnchorPane calendar_form;

    @FXML
    private Button analyticsbtn;

    @FXML
    private AnchorPane billing_form;

    @FXML
    private Button billingbtn;

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
    private TableColumn<Order, String> Order_col_Customer;

    @FXML
    private TableColumn<Order, LocalDate> Order_col_Date;

    @FXML
    private TableColumn<Order, String> Order_col_Employee;

    @FXML
    private TableColumn<Order, String> Order_col_Item;

    @FXML
    private TableColumn<Order, Integer> Order_col_QTY;

    @FXML
    private TableColumn<Order, String> Order_col_Weight;

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
    private TextField order_search;

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
    private TextField txtInvTypeName;

    @FXML
    private TextField txtInvTypeQty;

    @FXML
    private TextField txtInvTypeStatus;

    @FXML
    private TextField txtSearchInvCat;

    @FXML
    private TextField txtSearchInvType;

    @FXML
    private ComboBox<String> invCatComboBox;

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
    private TextField txtIqEmail;

    @FXML
    private TextField txtIqSubject;

    @FXML
    private TextArea txtIqDescription;

    @FXML
    private Button btnIqSend;

    @FXML
    private Button addbtnAllowances;

    @FXML
    private Button calculatebtnAllowances;

    @FXML
    private Button deletebtnAllowances;

    @FXML
    private Button clearbtnAllowances;

    @FXML
    private Button updateBtnallowances;

    @FXML
    private TableView<Allowance> AllowanceDetailTable;

    @FXML
    private TableColumn<Allowance, Integer> empIDColumn;

    @FXML
    private TableColumn<Allowance, String> empNameColumn;

    @FXML
    private TableColumn<Allowance, Double> BsalaryColumn;

    @FXML
    private TableColumn<Allowance, Double> totalOTColumn;

    @FXML
    private TableColumn<Allowance, Double> ratesPerHrColumn;

    @FXML
    private TableColumn<Allowance, Double> totalAmountColumn;

    @FXML
    private TableColumn<Allowance, Double> advanceColumn;

    @FXML
    private TableColumn<Allowance, Double> deductionColumn;

    @FXML
    private TableColumn<Allowance, Double> incrementColumn;

    @FXML
    private TextField txtAllowancesEmpID;

    @FXML
    private TextField txtAllowancesEmpName;

    @FXML
    private ImageView paymentImage;

    @FXML
    private TextField txtAllowancesBSalary;

    @FXML
    private TextField txtAllowancesTotalOT;

    @FXML
    private TextField txtAllowancesRatesperHr;

    @FXML
    private TextField txtAllowancesTotalamount;

    @FXML
    private TextField txtAllowancesIncrement;

    @FXML
    private TextField txtAllowancesDeduction;

    @FXML
    private TextField txtAllowancesAdvance;

    @FXML
    private TableView<Allowance> paymentTable;

    @FXML
    private TableColumn<Allowance, Integer> statusIDColumn;

    @FXML
    private TableColumn<Allowance, String> statusNameColumn;

    @FXML
    private TableColumn<Allowance, Double> statusAdvanceColumn;

    @FXML
    private TableColumn<Allowance, Double> statusTotalamountColumn;

    @FXML
    private Button GTbtnadd;

    @FXML
    private Button GTbtnclear;

    @FXML
    private Button GTbtndelete;

    @FXML
    private Button GTbtnupdate;

    @FXML
    private TableColumn<GoldTransaction, Integer> GTcolamount;

    @FXML
    private TableColumn<GoldTransaction, String> GTcoldes;

    @FXML
    private TableColumn<GoldTransaction, Integer> GTcolref;

    @FXML
    private TableView<GoldTransaction> GTtable;

    @FXML
    private TextField GTtxtAmount;

    @FXML
    private TextField GTtxtDes;

    @FXML
    private TextField GTtxtRef;

    @FXML
    private TextField Gold_search;

    @FXML
    private TextField cash_search;

    @FXML
    private TextField display;

    @FXML
    private Button divide;

    @FXML
    private Button plus;

    @FXML
    private Button clear;

    @FXML
    private Button minus;

    @FXML
    private Button multiplication;

    @FXML
    private Button equals;

    @FXML
    private Button one;

    @FXML
    private Button two;

    @FXML
    private Button three;

    @FXML
    private Button four;

    @FXML
    private Button five;

    @FXML
    private Button six;

    @FXML
    private Button seven;

    @FXML
    private Button eight;

    @FXML
    private Button nine;

    @FXML
    private Button zero;

    @FXML
    private Label dashboard_noOR;

    @FXML
    private TableColumn<CashTransaction, Integer> CTcoldID;

    @FXML
    private TextField CTtxtID;

    @FXML
    private TextField GTtxtID;

    @FXML
    private TableColumn<GoldTransaction, Integer> GTcolID;

    @FXML
    private TableView<Employee> EmpDet_Table;

    @FXML
    private Text year;

    @FXML
    private Text month;

    @FXML
    private FlowPane calendar;

    @FXML
    private Label txtGoldRate;

    @FXML
    private Label dasboard_Emp;

    @FXML
    private BarChart<?, ?> dashboard_noORGR;

    @FXML
    private BarChart<?, ?> dashboard_GTgraph;

    @FXML
    private Button CB_AmoCaBTN;

    @FXML
    private ComboBox<String> CB_CusName;

    @FXML
    private DatePicker CB_Date;

    @FXML
    private ComboBox<String> CB_EmpName;

    @FXML
    private TextField CB_ID;

    @FXML
    private TextField CB_Item;

    @FXML
    private TextField CB_PPG;

    @FXML
    private TextField CB_Qty;

    @FXML
    private TextField CB_amount;

    @FXML
    private Button CB_billBTN;

    @FXML
    private Button CB_calWeBTN;

    @FXML
    private TextField CB_totalWei;

    @FXML
    private TextField CB_weight;
    ZonedDateTime dateFocus;
    ZonedDateTime today;
    float data = 0f;
    int operation = -1;

    public void dashboardNo_OR() {
        String sql = "SELECT COUNT(*) AS total FROM orderDetails";
        int no = 0;
        connect = databaseConnection.getConnection();
        try {
            statement = connect.createStatement();
            result = statement.executeQuery(sql);

            if (result.next()) {
                no = result.getInt("total");
            }
            dashboard_noOR.setText(String.valueOf(no));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dashboardNo_Emp() {
        String sql = "SELECT COUNT(*) AS total FROM employee";
        int emp = 0;
        connect = databaseConnection.getConnection();
        try {
            statement = connect.createStatement();
            result = statement.executeQuery(sql);

            if (result.next()) {
                emp = result.getInt("total");
            }
            dasboard_Emp.setText(String.valueOf(emp));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dashboardNoodOrGraph() {
        dashboard_noORGR.getData().clear();

        String sql = "SELECT date,COUNT(*) FROM orderDetails GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 9 ";
        connect = databaseConnection.getConnection();
        try {

            XYChart.Series chart = new XYChart.Series<>();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }
            dashboard_noORGR.getData().add(chart);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dashboardNoTransGraph() {
        dashboard_GTgraph.getData().clear();

        String sql = "SELECT date,COUNT(*) FROM cashTransection GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 9 ";
        connect = databaseConnection.getConnection();
        try {

            XYChart.Series chart = new XYChart.Series<>();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }
            dashboard_GTgraph.getData().add(chart);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void close() {
        System.exit(0);
    }

    private double x = 0;
    private double y = 0;

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


    private Map<Integer, List<CalendarActivity>> calendarActivityMap = new HashMap<>();

    @FXML
    void backOneMonth(ActionEvent event) {
        dateFocus = dateFocus.minusMonths(1);
        calendar.getChildren().clear();
        drawCalendar();
    }

    @FXML
    void forwardOneMonth(ActionEvent event) {
        dateFocus = dateFocus.plusMonths(1);
        calendar.getChildren().clear();
        drawCalendar();
    }

    private void drawCalendar() {
        year.setText(String.valueOf(dateFocus.getYear()));
        month.setText(String.valueOf(dateFocus.getMonth()));

        double calendarWidth = calendar.getPrefWidth();
        double calendarHeight = calendar.getPrefHeight();
        double strokeWidth = 1;
        double spacingH = calendar.getHgap();
        double spacingV = calendar.getVgap();

        // List of activities for a given month
        calendarActivityMap = getCalendarActivitiesMonth(dateFocus); // Update the class-level calendarActivityMap

        int monthMaxDate = dateFocus.getMonth().maxLength();
        // Check for leap year
        if (dateFocus.getYear() % 4 != 0 && monthMaxDate == 29) {
            monthMaxDate = 28;
        }
        int dateOffset = ZonedDateTime.of(dateFocus.getYear(), dateFocus.getMonthValue(), 1, 0, 0, 0, 0, dateFocus.getZone()).getDayOfWeek().getValue();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                StackPane stackPane = new StackPane();

                Rectangle rectangle = new Rectangle();
                rectangle.setFill(Color.TRANSPARENT);
                rectangle.setStroke(Color.BLACK);
                rectangle.setStrokeWidth(strokeWidth);
                double rectangleWidth = (calendarWidth / 7) - strokeWidth - spacingH;
                rectangle.setWidth(rectangleWidth);
                double rectangleHeight = (calendarHeight / 6) - strokeWidth - spacingV;
                rectangle.setHeight(rectangleHeight);
                stackPane.getChildren().add(rectangle);

                int calculatedDate = (j + 1) + (7 * i);
                if (calculatedDate > dateOffset) {
                    int currentDate = calculatedDate - dateOffset;
                    if (currentDate <= monthMaxDate) {
                        Text date = new Text(String.valueOf(currentDate));
                        double textTranslationY = -(rectangleHeight / 2) * 0.75;
                        date.setTranslateY(textTranslationY);
                        stackPane.getChildren().add(date);

                        stackPane.setOnMouseClicked(this::handleMouseClick);

                        List<CalendarActivity> calendarActivities = calendarActivityMap.get(currentDate);
                        if (calendarActivities != null) {
                            createCalendarActivity(calendarActivities, rectangleHeight, rectangleWidth, stackPane);
                        }
                        if (today.getYear() == dateFocus.getYear() && today.getMonth() == dateFocus.getMonth() && today.getDayOfMonth() == currentDate) {
                            rectangle.setStroke(Color.BLUE);
                        }
                    }
                }
                calendar.getChildren().add(stackPane);
            }
        }
    }

    private void handleMouseClick(MouseEvent event) {
        StackPane stackPane = (StackPane) event.getSource();
        int clickedDate = Integer.parseInt(((Text) stackPane.getChildren().get(1)).getText());

        List<CalendarActivity> events = calendarActivityMap.get(clickedDate);
        if (events == null || events.isEmpty()) {
            // If there are no events, show the TextInputDialog to add an event
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Add Event");
            dialog.setHeaderText("Enter event details:");
            dialog.setContentText("Event:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(eventDetails -> {
                addEvent(clickedDate, eventDetails);
            });
        } else {
            // If there are events, show the ChoiceDialog to delete an event
            ChoiceDialog<CalendarActivity> dialog = new ChoiceDialog<>(events.get(0), events);
            dialog.setTitle("Delete Event");
            dialog.setHeaderText("Select event to delete:");
            dialog.setContentText("Event:");

            dialog.getDialogPane().getButtonTypes().clear(); // Clear existing buttons

            ButtonType deleteButtonType = new ButtonType("Delete", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(deleteButtonType, ButtonType.CANCEL);

            Optional<CalendarActivity> result = dialog.showAndWait();
            result.ifPresent(this::showDeleteConfirmation);
        }
    }

    private void showDeleteConfirmation(CalendarActivity event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Delete Event");
        alert.setContentText("Are you sure you want to delete this event?");

        ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonTypeYes) {
            deleteEvent(event);
        }
    }


    private void addEvent(int date, String eventDetails) {
        // Add the event to the calendar
        ZonedDateTime dateTime = ZonedDateTime.of(dateFocus.getYear(), dateFocus.getMonthValue(), date, 0, 0, 0, 0,
                dateFocus.getZone());
        CalendarActivity event = new CalendarActivity(null, dateTime, eventDetails);
        insertEventIntoDatabase(event);
        calendarActivityMap.computeIfAbsent(date, k -> new ArrayList<>()).add(event);

        // Find the StackPane corresponding to the date and update it
        for (Node node : calendar.getChildren()) {
            if (node instanceof StackPane) {
                StackPane stackPane = (StackPane) node;
                if (stackPane.getChildren().size() > 1) {
                    Text text = (Text) stackPane.getChildren().get(1);
                    if (text.getText().equals(String.valueOf(date))) {
                        Rectangle rectangle = (Rectangle) stackPane.getChildren().get(0);
                        double rectangleHeight = rectangle.getHeight();
                        double rectangleWidth = rectangle.getWidth();
                        createCalendarActivity(calendarActivityMap.get(date), rectangleHeight, rectangleWidth, stackPane);
                        break;
                    }
                }
            }
        }
    }

    private void deleteEvent(CalendarActivity event) {
        ZonedDateTime dateTime = event.getEvent_datetime();
        int date = dateTime.getDayOfMonth();
        deleteEventFromDatabase(event);
        calendarActivityMap.get(date).remove(event);
        updateCalendarUI(date);
    }

    private void updateCalendarUI(int date) {
        // Find the StackPane corresponding to the date and remove its children
        for (Node node : calendar.getChildren()) {
            if (node instanceof StackPane) {
                StackPane stackPane = (StackPane) node;
                if (stackPane.getChildren().size() > 1) {
                    Text text = (Text) stackPane.getChildren().get(1);
                    if (text.getText().equals(String.valueOf(date))) {
                        // Remove all children except the rectangle
                        ObservableList<Node> children = stackPane.getChildren();
                        for (int i = children.size() - 1; i >= 0; i--) {
                            Node child = children.get(i);
                            if (child instanceof VBox) {
                                children.remove(i);
                                break;
                            }
                        }
                        List<CalendarActivity> activities = calendarActivityMap.get(date);
                        if (activities != null && !activities.isEmpty()) {
                            Rectangle rectangle = (Rectangle) children.get(0);
                            double rectangleHeight = rectangle.getHeight();
                            double rectangleWidth = rectangle.getWidth();
                            createCalendarActivity(activities, rectangleHeight, rectangleWidth, stackPane);
                        }
                        break;
                    }
                }
            }
        }
    }

    private void createCalendarActivity(List<CalendarActivity> calendarActivities, double rectangleHeight,
                                        double rectangleWidth, StackPane stackPane) {
        VBox calendarActivityBox = new VBox();
        for (CalendarActivity activity : calendarActivities) {
            Text text = new Text(activity.getEvent_details() );
            calendarActivityBox.getChildren().add(text);
            text.setOnMouseClicked(mouseEvent -> {
                // On Text clicked
                System.out.println(text.getText());
            });
        }
        calendarActivityBox.setTranslateY((rectangleHeight / 2) * 0.20);
        calendarActivityBox.setMaxWidth(rectangleWidth * 0.8);
        calendarActivityBox.setMaxHeight(rectangleHeight * 0.65);
        calendarActivityBox.setStyle("-fx-background-color:white");

        // Clear previous contents and add the updated VBox
        stackPane.getChildren().removeIf(node -> node instanceof VBox);
        stackPane.getChildren().add(calendarActivityBox);
    }

    private void insertEventIntoDatabase(CalendarActivity event) {
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement statement = conn
                     .prepareStatement("INSERT INTO calendarevent (event_datetime, event_details) VALUES (?, ?)")) {
            statement.setObject(1, event.getEvent_datetime());
            statement.setString(2, event.getEvent_details());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteEventFromDatabase(CalendarActivity event) {
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement("DELETE FROM calendarevent WHERE CEID = ?")) {
            statement.setString(1, event.getCEID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateEventInDatabase(CalendarActivity newEvent) {
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement statement = conn
                     .prepareStatement("UPDATE calendarevent SET event_details = ? WHERE CEID = ?")) {
            statement.setString(1, newEvent.getEvent_details());
            statement.setString(2, newEvent.getCEID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Map<Integer, List<CalendarActivity>> createCalendarMap(List<CalendarActivity> calendarActivities) {
        Map<Integer, List<CalendarActivity>> calendarActivityMap = new HashMap<>();

        for (CalendarActivity activity : calendarActivities) {
            int activityDate = activity.getEvent_datetime().getDayOfMonth();
            calendarActivityMap.computeIfAbsent(activityDate, k -> new ArrayList<>()).add(activity);
        }
        return calendarActivityMap;
    }


    private Map<Integer, List<CalendarActivity>> getCalendarActivitiesMonth(ZonedDateTime dateFocus) {
        Map<Integer, List<CalendarActivity>> calendarActivityMap = new HashMap<>();
        int year = dateFocus.getYear();
        int month = dateFocus.getMonthValue();

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement statement = conn
                     .prepareStatement("SELECT * FROM calendarevent WHERE YEAR(event_datetime) = ? AND MONTH(event_datetime) = ?")) {
            statement.setInt(1, year);
            statement.setInt(2, month);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String CEID = resultSet.getString("CEID");
                ZonedDateTime event_datetime = resultSet.getTimestamp("event_datetime").toLocalDateTime().atZone(dateFocus.getZone());
                CalendarActivity event = new CalendarActivity(CEID, event_datetime, resultSet.getString("event_details"));
                int dayOfMonth = event_datetime.getDayOfMonth();
                calendarActivityMap.computeIfAbsent(dayOfMonth, k -> new ArrayList<>()).add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        today = ZonedDateTime.now(); // Set the today date
        return calendarActivityMap;
    }

    /************************************************Janani**************************************************/
    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;

    public ObservableList<Customer> addCustomerData() {
        ObservableList<Customer> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM customer";

        connect = databaseConnection.getConnection();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            Customer customerd;

            while (result.next()) {
                customerd = new Customer(result.getString("cusName"),
                        result.getString("cusNIC"),
                        result.getString("cusContact"),
                        result.getString("cusEmail"),
                        result.getString("cusAddress"));

                listData.add(customerd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<Customer> addCustomer;

    public void addCustomerShowListData() {
        addCustomer = addCustomerData();

        addCus_col_name.setCellValueFactory(new PropertyValueFactory<>("cusName"));
        addCus_col_NICno.setCellValueFactory(new PropertyValueFactory<>("NICno"));
        addCus_col_TelNo.setCellValueFactory(new PropertyValueFactory<>("telNo"));
        addCus_col_email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        addCus_col_Address.setCellValueFactory(new PropertyValueFactory<>("Address"));

        CusDet_Table.setItems(addCustomer);
    }


    public void addCustomerSelect() {
        Customer customerd = CusDet_Table.getSelectionModel().getSelectedItem();
        int num = CusDet_Table.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

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


    public void addCustomerDelete() {
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

    public void addcustomerClear() {
        addCusDet_Cusname.setText("");
        addCusDet_CusNICno.setText("");
        addCusDet_CusTelno.setText("");
        addCusDet_CusEmail.setText("");
        addCusDet_CusAdd.setText("");


    }

    @FXML
    void generatePDFCustomer(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            String filePath = file.getAbsolutePath();
            pdfGenerateCustomer(file, CusDet_Table);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PDF Generated");
            alert.setHeaderText(null);
            alert.setContentText("PDF file generated successfully!");
            alert.showAndWait();
        }
    }

    public static void pdfGenerateCustomer(File file, TableView<Customer> customerTable) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            float[] columnWidths = {0.5f, 2f, 2f, 1f, 4f, 1f};
            table.setWidths(columnWidths);

            // Add table headers
            addTableHeaderCustomer(table);

            // Add table rows
            addRowsCustomer(table, customerTable);

            document.add(table);
            document.close();

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void addTableHeaderCustomer(PdfPTable table) {
        String[] headers = {"Id", "Name", "NIC", "Tel No", "Email", "Address"};
        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(header));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(cell);
        }
    }

    private static void addRowsCustomer(PdfPTable table, TableView<Customer> tableView) {
        for (Customer item : tableView.getItems()) {
            table.addCell(String.valueOf(item.getCusID()));
            table.addCell(item.getCusName());
            table.addCell(String.valueOf(item.getNICno())); // Convert to String
            table.addCell(String.valueOf(item.getTelNo())); // Convert to String
            table.addCell(String.valueOf(item.getEmail()));
            table.addCell(String.valueOf(item.getAddress()));
        }
    }


    public ObservableList<Employee> addEmployeeData(){
        ObservableList<Employee> listData = FXCollections.observableArrayList();
        String sql="SELECT * FROM employee";

        connect= databaseConnection.getConnection();

        try {
            prepare=connect.prepareStatement(sql);
            result=prepare.executeQuery();
            Employee employeed;

            while (result.next()){
                employeed=new Employee(result.getString("empName"),
                        result.getString("empNIC"),
                        result.getString("empContact"),
                        result.getString("empEmail"),
                        result.getInt("empSalary"),
                        result.getString("empAddress"));

                listData.add(employeed);


            }
        }catch (Exception e){e.printStackTrace();}
        return listData;

    }

    private ObservableList<Employee>addEmployee;
    public void addEmployeeShowListData(){
        addEmployee=addEmployeeData();

        Emp_Det_Col_Empname.setCellValueFactory(new PropertyValueFactory<>("empName"));
        Emp_Det_Col_NICno.setCellValueFactory(new PropertyValueFactory<>("empNIC"));
        Emp_Det_Col_TelNo.setCellValueFactory(new PropertyValueFactory<>("empContact"));
        Emp_Det_Col_Email.setCellValueFactory(new PropertyValueFactory<>("empEmail"));
        Emp_Det_Col_Salary.setCellValueFactory(new PropertyValueFactory<>("empSalary"));
        Emp_Det_Col_Address.setCellValueFactory(new PropertyValueFactory<>("empAddress"));

        EmpDet_Table.setItems(addEmployee);
    }

    public void addEmployeeSelect(){
        Employee employee=EmpDet_Table.getSelectionModel().getSelectedItem();
        int num=EmpDet_Table.getSelectionModel().getSelectedIndex();

        if((num-1)< -1) {return;}

        Emp_Det_TX_Empname.setText(String.valueOf(employee.getEmpName()));
        Emp_Det_TX_NICNo.setText(String.valueOf(employee.getEmpNIC()));
        Emp_Det_TX_TelNo.setText(String.valueOf(employee.getEmpContact()));
        Emp_Det_TX_Email.setText(String.valueOf(employee.getEmpEmail()));
        Emp_Det_TX_Address.setText(String.valueOf(employee.getEmpAddress()));
        Emp_Det_TX_Salary.setText(String.valueOf(employee.getEmpSalary()));

    }
    public void addEmployeeAdd(){
        String sqlCheck = "SELECT * FROM employee WHERE empName = ?";
        String sqlInsert = "INSERT INTO employee (empName, empNIC, empContact, empEmail,empAddress, empSalary)VALUES (?, ?, ?, ?,?,?)";

        connect = databaseConnection.getConnection();

        try {
            Alert alert;
            if (Emp_Det_TX_Empname.getText().isEmpty() ||
                    Emp_Det_TX_NICNo.getText().isEmpty() ||
                    Emp_Det_TX_TelNo.getText().isEmpty() ||
                    Emp_Det_TX_Email.getText().isEmpty() ||
                    Emp_Det_TX_Address.getText().isEmpty() ||
                    Emp_Det_TX_Salary.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                // Check if employee with the same name already exists
                prepare = connect.prepareStatement(sqlCheck);
                prepare.setString(1, Emp_Det_TX_Empname.getText());
                ResultSet result = prepare.executeQuery();
                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Employee with the same name already exists");
                    alert.showAndWait();
                    return; // Exit method if employee already exists
                }
                // Validate email
                String email = Emp_Det_TX_Email.getText();
                if (!isValidEmpEmail(email)) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid email format");
                    alert.showAndWait();
                    return; // Exit method if email is invalid
                }

                // Validate NIC
                String nic = Emp_Det_TX_NICNo.getText();
                if (!isValidEmpNIC(nic)) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid NIC format");
                    alert.showAndWait();
                    return; // Exit method if NIC is invalid
                }

                // Validate telephone number
                String telNo = Emp_Det_TX_TelNo.getText();
                if (!isValidEmpTelNo(telNo)) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid telephone number format");
                    alert.showAndWait();
                    return; // Exit method if telephone number is invalid
                }


                // Insert new customer if validations pass
                prepare = connect.prepareStatement(sqlInsert);
                prepare.setString(1, Emp_Det_TX_Empname.getText());
                prepare.setString(2, nic);
                prepare.setString(3, Emp_Det_TX_TelNo.getText());
                prepare.setString(4, email);
                prepare.setString(5, Emp_Det_TX_Address.getText());
                prepare.setString(6, Emp_Det_TX_Salary.getText());

                prepare.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added");
                alert.showAndWait();

                addEmployeeShowListData();
                addEmployeeClear();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isValidEmpEmail(String email) {
        // Email validation regex
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    private boolean isValidEmpNIC(String nic) {
        // NIC validation regex for 12 digits OR 9 digits followed by v, V, x, or X
        String nicRegex = "^[0-9]{12}$|^[0-9]{9}[vVxX]$";
        return nic.matches(nicRegex);
    }
    private boolean isValidEmpTelNo(String telNo) {
        // Telephone number validation regex
        String telNoRegex = "^[0-9]{10}$"; // Assuming 10 digits for telephone number
        return telNo.matches(telNoRegex);
    }

    public void addEmployeeUpdate() {
        Employee selectedEmployee = EmpDet_Table.getSelectionModel().getSelectedItem();
        if (selectedEmployee == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select an employee to update");
            alert.showAndWait();
            return;
        }

        String sqlUpdate = "UPDATE employee SET empName=?, empNIC=?, empContact=?, empEmail=?, empAddress=?, empSalary=? WHERE empName=?";
        connect = databaseConnection.getConnection();

        try {
            Alert alert;
            if (Emp_Det_TX_Empname.getText().isEmpty() ||
                    Emp_Det_TX_NICNo.getText().isEmpty() ||
                    Emp_Det_TX_TelNo.getText().isEmpty() ||
                    Emp_Det_TX_Email.getText().isEmpty() ||
                    Emp_Det_TX_Address.getText().isEmpty() ||
                    Emp_Det_TX_Salary.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                // Validate email, NIC, telephone number similar to addEmployeeAdd() method

                prepare = connect.prepareStatement(sqlUpdate);
                prepare.setString(1, Emp_Det_TX_Empname.getText());
                prepare.setString(2, Emp_Det_TX_NICNo.getText());
                prepare.setString(3, Emp_Det_TX_TelNo.getText());
                prepare.setString(4, Emp_Det_TX_Email.getText());
                prepare.setString(5, Emp_Det_TX_Address.getText());
                prepare.setString(6, Emp_Det_TX_Salary.getText());
                prepare.setString(7, selectedEmployee.getEmpName()); // Where clause for update

                int rowsUpdated = prepare.executeUpdate();
                if (rowsUpdated > 0) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Employee updated successfully");
                    alert.showAndWait();

                    addEmployeeShowListData();
                    addEmployeeClear();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Failed to update employee");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEmployeeDelete(){
        Employee employee = EmpDet_Table.getSelectionModel().getSelectedItem();
        if (employee == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select a employee to delete");
            alert.showAndWait();
            return;
        }

        String sql = "DELETE FROM employee WHERE empName = ?";
        connect = databaseConnection.getConnection();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, employee.getEmpName());
            prepare.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Employee deleted successfully");
            alert.showAndWait();

            addEmployeeShowListData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEmployeeClear(){
        Emp_Det_TX_Empname.setText("");
        Emp_Det_TX_NICNo.setText("");
        Emp_Det_TX_TelNo.setText("");
        Emp_Det_TX_Email.setText("");
        Emp_Det_TX_Address.setText("");
        Emp_Det_TX_Salary.setText("");
    }

    /********************************************Shamini**********************************************/

    public ObservableList<String> getCustomerNames() {
        ObservableList<String> customerNames = FXCollections.observableArrayList();
        String sql = "SELECT cusName FROM customer";
        try (Connection connect = databaseConnection.getConnection(); PreparedStatement prepare = connect.prepareStatement(sql); ResultSet result = prepare.executeQuery()) {

            while (result.next()) {
                customerNames.add(result.getString("cusName"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerNames;
    }

    public ObservableList<String> getEmployeeNames() {
        ObservableList<String> employeeNames = FXCollections.observableArrayList();
        String sql = "SELECT empName FROM employee";
        try (Connection connect = databaseConnection.getConnection(); PreparedStatement prepare = connect.prepareStatement(sql); ResultSet result = prepare.executeQuery()) {

            while (result.next()) {
                employeeNames.add(result.getString("empName"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeNames;
    }

    private void populateCustomerNames() {
        ObservableList<String> customerNames = getCustomerNames();
        // Assuming Order_tx_Customer is your ComboBox for customer names
        CB_CusName.setItems(customerNames);

    }

    private void populateEmployeeNames() {
        ObservableList<String> employeeNames = getEmployeeNames();
        // Assuming Order_tx_Employee is your ComboBox for employee names
        CB_EmpName.getItems().addAll(employeeNames);
    }

    @FXML
    private void calculateTotalWeight() {
        try {
            int quantity = Integer.parseInt(CB_Qty.getText());
            double weight = Double.parseDouble(CB_weight.getText());
            double totalWeight = quantity * weight;
            CB_totalWei.setText(String.valueOf(totalWeight));
        } catch (NumberFormatException e) {
            // Handle the case where the user enters invalid input
            CB_totalWei.setText("Invalid input");
        }
    }

    @FXML
    private void calculateTotalAmount() {
        try {
            double totalWeight = Double.parseDouble(CB_totalWei.getText());
            double pricePerGram = Double.parseDouble(CB_PPG.getText());
            double totalAmount = totalWeight * pricePerGram;
            CB_amount.setText(String.valueOf(totalAmount));
        } catch (NumberFormatException e) {
            // Handle the case where the user enters invalid input
            CB_amount.setText("Invalid input");
        }
    }

    @FXML
    private void generatePDFBill(MouseEvent event) {
        try {
            // Check for empty fields
            if (CB_ID.getText().isEmpty() || CB_Date.getValue() == null || CB_EmpName.getValue().isEmpty() || CB_CusName.getValue().isEmpty() || CB_Item.getText().isEmpty() || CB_weight.getText().isEmpty() || CB_Qty.getText().isEmpty() || CB_amount.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill in all fields before generating the PDF.");
                alert.showAndWait();
                return;
            }
            // Prompt the user to choose a file save location
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialFileName("Bill.pdf");
            fileChooser.setTitle("Save PDF");
            File file = fileChooser.showSaveDialog(null);

            // If the user selected a file, proceed with PDF generation
            if (file != null) {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(file));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("PDF Generated");
                alert.setHeaderText(null);
                alert.setContentText("PDF file generated successfully!");
                alert.showAndWait();
                document.open();

                // Shop details
                Paragraph shopName = new Paragraph(" Sujitha Jewellers", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 14, com.itextpdf.text.Font.BOLD));
                PdfPTable shopTable = new PdfPTable(1);
                shopTable.setWidthPercentage(100);
                PdfPCell shopCell = new PdfPCell(shopName);
                shopCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                shopTable.addCell(shopCell);
                document.add(shopTable);

                Paragraph address = new Paragraph("Address: 123, Sea Street, Colombo, SriLanka", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12));
                PdfPTable addressTable = new PdfPTable(1);
                addressTable.setWidthPercentage(100);
                PdfPCell addressCell = new PdfPCell(address);
                addressCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                addressTable.addCell(addressCell);
                document.add(addressTable);

                Paragraph email = new Paragraph("Email: Sujithajewellers@gmail.com", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12));
                PdfPTable emailTable = new PdfPTable(1);
                emailTable.setWidthPercentage(100);
                PdfPCell emailCell = new PdfPCell(email);
                emailCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                emailTable.addCell(emailCell);
                document.add(emailTable);

                // Add some spacing
                document.add(new Paragraph("\n"));


                // Bill details
                Paragraph billDetails = new Paragraph("Bill Details", FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.BOLD, BaseColor.BLACK));
                billDetails.setAlignment(Element.ALIGN_CENTER);
                document.add(billDetails);


                // Assuming CB_ID, CB_Date, CB_EmpName, CB_CusName, CB_Item, CB_weight, CB_amount are controls
                document.add(new Paragraph("Bill ID: " + CB_ID.getText(), new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12)));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("Date: " + CB_Date.getValue(), new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12)));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("Employee Name: " + CB_EmpName.getValue(), new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12)));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("Customer Name: " + CB_CusName.getValue(), new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12)));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("Item: " + CB_Item.getText(), new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12)));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("Total Weight: " + CB_weight.getText(), new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12)));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph(" Quantity: " + CB_Qty.getText(), new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12)));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("Total Amount: " + CB_amount.getText(), new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12)));
                document.add(new Paragraph("\n"));

                document.close();
            }
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }




    public void orderCusId() {
        String sql = "SELECT cusName FROM customer ";
        connect = databaseConnection.getConnection();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ObservableList<String> listData = FXCollections.observableArrayList(); // Specify the type of items in the list

            while (result.next()) {
                listData.add(result.getString("cusName"));
            }

            Order_tx_Customer.getItems().clear(); // Clear the existing items
            Order_tx_Customer.getItems().addAll(listData); // Add the new items

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void orderEmpId() {
        String sql = "SELECT empName FROM employee ";
        connect = databaseConnection.getConnection();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ObservableList<String> listData = FXCollections.observableArrayList(); // Specify the type of items in the list

            while (result.next()) {
                listData.add(result.getString("empName"));
            }

            Order_tx_Employee.getItems().clear(); // Clear the existing items
            Order_tx_Employee.getItems().addAll(listData); // Add the new items

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private SpinnerValueFactory<Integer> spinner;

    public void orderSpinner() {
        spinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50, 0);

        Order_tx_QTY.setValueFactory(spinner);
    }

    private int qty;

    public void orderQuantity() {
        qty = Order_tx_QTY.getValue();

        System.out.println(qty);
    }


    public ObservableList<Order> addOrderdata() {
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
            dashboardNo_OR();
            dashboardNoodOrGraph();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }


    private ObservableList<Order> addOrderList;

    public void addOrderShowListData() {
        addOrderList = addOrderdata();

        Order_col_Date.setCellValueFactory(new PropertyValueFactory<>("date"));
        Order_col_Customer.setCellValueFactory(new PropertyValueFactory<>("CusName"));
        Order_col_Employee.setCellValueFactory(new PropertyValueFactory<>("EmpName"));
        Order_col_Item.setCellValueFactory(new PropertyValueFactory<>("Item"));
        Order_col_QTY.setCellValueFactory(new PropertyValueFactory<>("QTY"));
        Order_col_Weight.setCellValueFactory(new PropertyValueFactory<>("Weight"));

        Order_Table.setItems(addOrderList);
    }

    public void addOrderSelect() {
        Order orderd = Order_Table.getSelectionModel().getSelectedItem();
        int num = Order_Table.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

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

    public void updateOrder() {
        Order selectedOrder = Order_Table.getSelectionModel().getSelectedItem();
        if (selectedOrder == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select an order to update");
            alert.showAndWait();
            return;
        }

        String sql = "UPDATE orderDetails SET date = ?, cusID = ?, empID = ?, item = ?, qty = ?, weight = ? WHERE empID = ?";
        String sqlCheck = "SELECT * FROM orderDetails WHERE empID = ?";
        connect = databaseConnection.getConnection();

        try {

            if (!selectedOrder.getEmpName().equals(Order_tx_Employee.getSelectionModel().getSelectedItem())) {
                prepare = connect.prepareStatement(sqlCheck);
                prepare.setString(1, Order_tx_Employee.getSelectionModel().getSelectedItem());
                ResultSet result = prepare.executeQuery();
                if (result.next()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("An order for this employee already exists");
                    alert.showAndWait();
                    return; // Exit method if order for this employee already exists
                }
            }
            prepare = connect.prepareStatement(sql);
            prepare.setDate(1, java.sql.Date.valueOf(Order_date.getValue()));
            prepare.setString(2, Order_tx_Customer.getSelectionModel().getSelectedItem());
            prepare.setString(3, Order_tx_Employee.getSelectionModel().getSelectedItem());
            prepare.setString(4, Order_tx_item.getText());
            prepare.setInt(5, Order_tx_QTY.getValue());
            prepare.setDouble(6, Double.parseDouble(Order_tx_Weight.getText()));
            prepare.setString(7, selectedOrder.getEmpName());


            prepare.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Order updated successfully");
            alert.showAndWait();

            // Update the table view and clear the selection
            addOrderShowListData();

            // Refresh the combo box lists
            refreshComboBoxes();
            addOrderClear();

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

        String sql = "DELETE FROM orderDetails WHERE empID = ?";

        connect = databaseConnection.getConnection();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, order.getEmpName());
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

    @FXML
    public void searchAction(ActionEvent event) {
        orderSearch(); // Call your search method here
    }


    public void orderSearch() {
        FilteredList<Order> filter = new FilteredList<>(addOrderList, e -> true);
        order_search.textProperty().addListener((Observable, oldValue, newValue) -> {
            filter.setPredicate(predicateOrderadata -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String searchkey = newValue.toLowerCase();
                if (predicateOrderadata.getEmpName().toString().toLowerCase().contains(searchkey)) {
                    return true;
                } else if (predicateOrderadata.getCusName().toString().toLowerCase().contains(searchkey)) {
                    return true;
                } else return false;


            });
        });
        SortedList<Order> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(Order_Table.comparatorProperty());
        Order_Table.setItems(sortList);
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

    /**************************************  Amina***********************************/

    /* -------------------------------Allowances Part----------------------------------*/
    @FXML
    void generatePDFPayment(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files","*.pdf"));
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            String filePath = file.getAbsolutePath();
            pdfGeneratePayment(file, paymentTable);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PDF Generated");
            alert.setHeaderText(null);
            alert.setContentText("PDF file generated successfully!");
            alert.showAndWait();
        }
    }

    public static void pdfGeneratePayment(File file, TableView<Allowance> paymentTable) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            float[] columnWidths = {1f, 2f, 3f, 2f};
            table.setWidths(columnWidths);

            // Add table headers
            addTableHeaderPayment(table);

            // Add table rows
            addRowsPayment(table, paymentTable);

            document.add(table);
            document.close();

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void addTableHeaderPayment(PdfPTable table) {
        String[] headers = {"Id", "name", "Advance", "Total salary"};
        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(header));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(cell);
        }
    }

    private static void addRowsPayment(PdfPTable table, TableView<Allowance> tableView) {
        for (Allowance item : tableView.getItems()) {
            table.addCell(String.valueOf(item.getEmpid()));
            table.addCell(item.getEmpname());
            table.addCell(String.valueOf(item.getAdvance())); // Convert to String
            table.addCell(String.valueOf(item.getTotalamount())); // Convert to String
        }
    }


    private Image generateQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                text,
                BarcodeFormat.QR_CODE,
                width,
                height
        );

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        return new Image(inputStream);
    }

    //-------------------------------Clear button function-------------------------------
    @FXML
    private void clearFieldsA(ActionEvent actionEvent) {
        txtAllowancesEmpID.setText("");
        txtAllowancesEmpName.setText("");
        txtAllowancesBSalary.setText("");
        txtAllowancesTotalOT.setText("");
        txtAllowancesRatesperHr.setText("");
        txtAllowancesIncrement.setText("");
        txtAllowancesDeduction.setText("");
        txtAllowancesAdvance.setText("");
        txtAllowancesTotalamount.setText("");

    }

    //-------------------Calculate Button function---------------------------------
    @FXML
    private void calculateTotalAmount(ActionEvent event) {
        try {
            double basicsalary = Double.parseDouble(txtAllowancesBSalary.getText());
            double totalot = Double.parseDouble(txtAllowancesTotalOT.getText());
            double rateperhour = Double.parseDouble(txtAllowancesRatesperHr.getText());
            double increment = Double.parseDouble(txtAllowancesIncrement.getText());
            double deduction = Double.parseDouble(txtAllowancesDeduction.getText());
            double advance = Double.parseDouble(txtAllowancesAdvance.getText());
            double totalamount = basicsalary + (totalot * rateperhour) + increment + advance - deduction;

            txtAllowancesTotalamount.setText(Double.toString(totalamount));
        } catch (NumberFormatException e) {
            txtAllowancesTotalamount.setText("Invalid Input");
        }
    }
    //------------- ADD button function-------------------------------//

    public ObservableList<Allowance> addSalaryAllowanceData() {
        ObservableList<Allowance> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM allowance";

        connect = databaseConnection.getConnection();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            Allowance allowanced;

            while (result.next()) {
                allowanced = new Allowance(
                        result.getInt("empid"),
                        result.getString("empname"),
                        result.getDouble("basicsalary"),
                        result.getDouble("totalot"),
                        result.getDouble("rateperhour"),
                        result.getDouble("advance"),
                        result.getDouble("deduction"),
                        result.getDouble("increment"),
                        result.getDouble("totalamount"));

                listData.add(allowanced);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<Allowance> addSalaryAllowance;

    public void addSalaryAllowanceShowListData() {

        addSalaryAllowance = addSalaryAllowanceData();

        empIDColumn.setCellValueFactory(new PropertyValueFactory<>("empid"));
        empNameColumn.setCellValueFactory(new PropertyValueFactory<>("empname"));
        BsalaryColumn.setCellValueFactory(new PropertyValueFactory<>("basicsalary"));
        totalOTColumn.setCellValueFactory(new PropertyValueFactory<>("totalot"));
        ratesPerHrColumn.setCellValueFactory(new PropertyValueFactory<>("rateperhour"));
        advanceColumn.setCellValueFactory(new PropertyValueFactory<>("advance"));
        incrementColumn.setCellValueFactory(new PropertyValueFactory<>("increment"));
        deductionColumn.setCellValueFactory(new PropertyValueFactory<>("deduction"));
        totalAmountColumn.setCellValueFactory(new PropertyValueFactory<>("totalamount"));
        statusIDColumn.setCellValueFactory(new PropertyValueFactory<>("empid"));
        statusNameColumn.setCellValueFactory(new PropertyValueFactory<>("empname"));
        statusTotalamountColumn.setCellValueFactory(new PropertyValueFactory<>("totalamount"));
        statusAdvanceColumn.setCellValueFactory(new PropertyValueFactory<>("advance"));
        AllowanceDetailTable.setItems(addSalaryAllowance);
        paymentTable.setItems(addSalaryAllowance);

    }

    public void addSalaryAllowanceSelect() {
        Allowance allowanced = AllowanceDetailTable.getSelectionModel().getSelectedItem();
        int num = AllowanceDetailTable.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        txtAllowancesEmpID.setText(String.valueOf(allowanced.getEmpid()));
        txtAllowancesEmpName.setText(allowanced.getEmpname());
        txtAllowancesBSalary.setText(String.valueOf(allowanced.getBasicsalary()));
        txtAllowancesTotalOT.setText(String.valueOf(allowanced.getTotalot()));
        txtAllowancesRatesperHr.setText(String.valueOf(allowanced.getRateperhour()));
        txtAllowancesAdvance.setText(String.valueOf(allowanced.getAdvance()));
        txtAllowancesDeduction.setText(String.valueOf(allowanced.getDeduction()));
        txtAllowancesIncrement.setText(String.valueOf(allowanced.getDeduction()));
        txtAllowancesTotalamount.setText(String.valueOf(allowanced.getTotalamount()));
    }


    public void addAllowance() {
        String sqlCheck = "SELECT * FROM allowance WHERE empid = ?";
        String sqlInsert = "INSERT INTO allowance (empid, empname, basicsalary, totalot, rateperhour,totalamount,deduction,increment,advance) VALUES (?, ?, ?, ?, ?,?,?,?,?)";

        connect = databaseConnection.getConnection();
        try {
            Alert alert;
            if (txtAllowancesEmpID.getText().isEmpty() ||
                    txtAllowancesEmpName.getText().isEmpty() ||
                    txtAllowancesBSalary.getText().isEmpty() ||
                    txtAllowancesRatesperHr.getText().isEmpty() ||
                    txtAllowancesTotalOT.getText().isEmpty() ||
                    txtAllowancesIncrement.getText().isEmpty() ||
                    txtAllowancesDeduction.getText().isEmpty() ||
                    txtAllowancesAdvance.getText().isEmpty()
            ) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            }
            String empname = txtAllowancesEmpName.getText();
            if (!isValidEmpname(empname)) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid name format");
                alert.showAndWait();
                return;
            }
            String basicsalary = txtAllowancesBSalary.getText();
            if (!isValidBsalary(basicsalary)) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid name format");
                alert.showAndWait();
                return;
            }
            String totalot = txtAllowancesTotalOT.getText();
            if (!isValidTotalot(totalot)) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid number format");
                alert.showAndWait();
                return;
            }
            String rateperhour = txtAllowancesRatesperHr.getText();
            if (!isValidRateperhour(rateperhour)) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid number format");
                alert.showAndWait();
                return;
            }
            String increment = txtAllowancesIncrement.getText();
            if (!isValidIncrement(increment)) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid number format");
                alert.showAndWait();
                return;
            }
            String deduction = txtAllowancesDeduction.getText();
            if (!isValidDeduction(deduction)) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid number format");
                alert.showAndWait();
                return;
            }
            String advance = txtAllowancesAdvance.getText();
            if (!isValidAdvance(advance)) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid number format");
                alert.showAndWait();
                return;
            }

            prepare = connect.prepareStatement(sqlInsert);
            prepare.setString(1, txtAllowancesEmpID.getText());
            prepare.setString(2, txtAllowancesEmpName.getText());
            prepare.setString(3, txtAllowancesBSalary.getText());
            prepare.setString(4, txtAllowancesTotalOT.getText());
            prepare.setString(5, txtAllowancesRatesperHr.getText());
            prepare.setString(6, txtAllowancesTotalamount.getText());
            prepare.setString(7, txtAllowancesAdvance.getText());
            prepare.setString(8, txtAllowancesDeduction.getText());
            prepare.setString(9, txtAllowancesIncrement.getText());

            prepare.executeUpdate();
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Added");
            alert.showAndWait();
            addSalaryAllowanceShowListData();

            //refreshTables();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean isValidEmpname(String empname) {
        // Regular expression for only letters (a-z, A-Z) and spaces
        Pattern pattern = Pattern.compile("^[a-zA-Z ]+$");
        return pattern.matcher(empname).matches();
    }

    private boolean isValidBsalary(String basicsalary) {
        try {
            Double.parseDouble(basicsalary);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidTotalot(String totalot) {
        try {
            Double.parseDouble(totalot);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidRateperhour(String rateperhour) {
        try {
            Double.parseDouble(rateperhour);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidDeduction(String deduction) {
        try {
            Double.parseDouble(deduction);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidIncrement(String increment) {
        try {
            Double.parseDouble(increment);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidAdvance(String advance) {
        try {
            Double.parseDouble(advance);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    // Function to populate text fields when a row is clicked in the table
    @FXML
    private void addSalaryAllowanceSelect(MouseEvent event) {
        Allowance selectedAllowance = AllowanceDetailTable.getSelectionModel().getSelectedItem();
        if (selectedAllowance != null) {
            txtAllowancesEmpID.setText(String.valueOf(selectedAllowance.getEmpid()));
            txtAllowancesEmpName.setText(selectedAllowance.getEmpname());
            txtAllowancesBSalary.setText(String.valueOf(selectedAllowance.getBasicsalary()));
            txtAllowancesTotalOT.setText(String.valueOf(selectedAllowance.getTotalot()));
            txtAllowancesRatesperHr.setText(String.valueOf(selectedAllowance.getRateperhour()));
            txtAllowancesTotalamount.setText(String.valueOf(selectedAllowance.getTotalamount()));
            txtAllowancesIncrement.setText(String.valueOf(selectedAllowance.getIncrement()));
            txtAllowancesDeduction.setText(String.valueOf(selectedAllowance.getDeduction()));
            txtAllowancesAdvance.setText(String.valueOf(selectedAllowance.getAdvance()));
        }
    }

    // Update function for the "Update" button
    @FXML
    private void updateAllowance(ActionEvent event) {
        connect = databaseConnection.getConnection();
        String sql = "UPDATE allowance SET empname = ?, basicsalary = ?, totalot = ?, rateperhour = ?, totalamount = ?,advance = ?,increment = ?,deduction = ? WHERE empid = ?";

        Alert alert = null;
        try {
            prepare = connect.prepareStatement(sql);

            prepare.setString(1, txtAllowancesEmpName.getText());
            prepare.setDouble(2, Double.parseDouble(txtAllowancesBSalary.getText()));
            prepare.setDouble(3, Double.parseDouble(txtAllowancesTotalOT.getText()));
            prepare.setDouble(4, Double.parseDouble(txtAllowancesRatesperHr.getText()));
            prepare.setDouble(5, Double.parseDouble(txtAllowancesTotalamount.getText()));
            prepare.setDouble(6, Double.parseDouble(txtAllowancesAdvance.getText()));
            prepare.setDouble(7, Double.parseDouble(txtAllowancesIncrement.getText()));
            prepare.setDouble(8, Double.parseDouble(txtAllowancesDeduction.getText()));
            prepare.setInt(9, Integer.parseInt(txtAllowancesEmpID.getText()));

            prepare.executeUpdate();

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Record Updated Successfully");
            alert.showAndWait();

            addSalaryAllowanceShowListData(); // Refresh the table after update

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    ///delete button
    @FXML
    public void deleteAllowance() {
        Allowance allowance = AllowanceDetailTable.getSelectionModel().getSelectedItem();
        if (allowance == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select an Allowance to delete");
            alert.showAndWait();
            return;
        }

        String sql = "DELETE FROM allowance WHERE empid = ?";
        connect = databaseConnection.getConnection();

        Alert alert = null;
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setInt(1, allowance.getEmpid());
            prepare.executeUpdate();

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Allowance deleted successfully");
            alert.showAndWait();


            addSalaryAllowanceShowListData();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /***********************************************Nitishe**************************************************/
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    public ObservableList<CashTransaction> getCashtransaction() {
        ObservableList<CashTransaction> cashTransactions = FXCollections.observableArrayList();

        String query = "select * from cashTransection";
        con = databaseConnection.getConnection();
        try {
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
                CashTransaction st = new CashTransaction();
                st.setCTID(rs.getInt("CTID"));
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

    private ObservableList<CashTransaction> getCashtransaction;

    public void showCashTransaction() {
        getCashtransaction = getCashtransaction();
        //table.setItems(list);
        CTcoldID.setCellValueFactory(new PropertyValueFactory<CashTransaction, Integer>("CTID"));
        CTcoldate.setCellValueFactory(new PropertyValueFactory<CashTransaction, Date>("CTDate"));
        CTcolrole.setCellValueFactory(new PropertyValueFactory<CashTransaction, String>("CTRole"));
        CTcolamount.setCellValueFactory(new PropertyValueFactory<CashTransaction, Integer>("CTAmount"));
        CTcolname.setCellValueFactory(new PropertyValueFactory<CashTransaction, String>("CTName"));
        CTcoltype.setCellValueFactory(new PropertyValueFactory<CashTransaction, String>("CTType"));

        CTtable.setItems(getCashtransaction);
    }

    @FXML
    void createCT(ActionEvent event) {
        String insert = "insert into cashTransection(CTID,transectionType,transectionAmount,name,date,role) values(?,?,?,?,?,?)";
        con = databaseConnection.getConnection();
        try {
            st = con.prepareStatement(insert);
            st.setInt(1, Integer.parseInt(CTtxtID.getText()));
            st.setString(2, CTtxtType.getText());
            st.setDouble(3, Double.parseDouble(CTtxtAmount.getText()));
            st.setString(4, CTtxtName.getText());
            st.setDate(5, java.sql.Date.valueOf(CTtxtDate.getValue()));
            st.setString(6, CTtxtRole.getText());
            st.executeUpdate();
            showCashTransaction();
            dashboardNoTransGraph();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void getData(MouseEvent event) {
        CashTransaction cashTransaction = CTtable.getSelectionModel().getSelectedItem();
        int num = CTtable.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        CTtxtID.setText(String.valueOf(cashTransaction.getCTID()));
        CTtxtType.setText(cashTransaction.getCTType());
        CTtxtAmount.setText(String.valueOf(cashTransaction.getCTAmount()));
        CTtxtName.setText(cashTransaction.getCTName());
        CTtxtDate.setValue(cashTransaction.getCTDate());
        CTtxtRole.setText(cashTransaction.getCTRole());
    }

    public void deleteCT(ActionEvent event) {
        CashTransaction cashTransaction = CTtable.getSelectionModel().getSelectedItem();
        if (cashTransaction == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select a cash transaction to delete");
            alert.showAndWait();
            return;
        }

        String sql = "DELETE FROM cashTransection WHERE CTID = ?";

        connect = databaseConnection.getConnection();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setInt(1, cashTransaction.getCTID());
            prepare.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Transaction deleted successfully");
            alert.showAndWait();
            showCashTransaction();
            clearCT(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void updateCT(ActionEvent event) {
        connect = databaseConnection.getConnection();
        String sql = "UPDATE cashTransection SET transectionType = ?, transectionAmount = ?, name = ?, date = ?, role = ? WHERE CTID = ?";

        Alert alert = null;
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, CTtxtType.getText());
            prepare.setInt(2, Integer.parseInt(CTtxtAmount.getText()));
            prepare.setString(3, CTtxtName.getText());
            prepare.setDate(4, java.sql.Date.valueOf(CTtxtDate.getValue()));
            prepare.setString(5, CTtxtRole.getText());
            prepare.setInt(6, Integer.parseInt(CTtxtID.getText()));


            prepare.executeUpdate();

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Record Updated Successfully");
            alert.showAndWait();

            //addSalaryAllowanceShowListData(); // Refresh the table after update
            showCashTransaction();
            clearCT(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void clearCT(ActionEvent event) {
        CTtxtDate.setValue(null);
        CTtxtAmount.setText("");
        CTtxtName.setText("");
        CTtxtRole.setText("");
        CTtxtType.setText("");
        CTtxtID.setText(null);
    }

    @FXML
    public void searchActionCash(ActionEvent event) {
        cashSearch(); // Call your search method here
    }

    public void cashSearch() {
        FilteredList<CashTransaction> filter = new FilteredList<>(getCashtransaction, e -> true);
        cash_search.textProperty().addListener((Observable, oldValue, newValue) -> {
            filter.setPredicate(predicateOrderadata -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String searchkey = newValue.toLowerCase();
                if (predicateOrderadata.getCTName().toString().toLowerCase().contains(searchkey)) {
                    return true;
                } else if (predicateOrderadata.getCTRole().toString().toLowerCase().contains(searchkey)) {
                    return true;
                } else return false;


            });
        });
        SortedList<CashTransaction> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(CTtable.comparatorProperty());
        CTtable.setItems(sortList);
    }

    //Nitishe's pdf generation part for cash
    @FXML
    void generatePDFCash(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            String filePath = file.getAbsolutePath();
            // private TableView<CashTransaction> CTtable;
            pdfGenerateCash(file, CTtable);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PDF Generated");
            alert.setHeaderText(null);
            alert.setContentText("PDF file generated successfully!");
            alert.showAndWait();
        }
    }

    public static void pdfGenerateCash(File file, TableView<CashTransaction> CTtable) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            float[] columnWidths = {1f, 2f, 3f, 2f, 1f, 2f};
            table.setWidths(columnWidths);

            // Add table headers
            addTableHeaderCash(table);

            // Add table rows
            addRowsCash(table, CTtable);

            document.add(table);
            document.close();

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void addTableHeaderCash(PdfPTable table) {
        String[] headers = {"CTID", "transectionType", "transectionAmount", "name", "date", "role"};
        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(header));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(cell);
        }
    }

    private static void addRowsCash(PdfPTable table, TableView<CashTransaction> tableView) {
        for (CashTransaction item : tableView.getItems()) {
            table.addCell(String.valueOf(item.getCTID()));
            table.addCell(item.getCTType());
            table.addCell(String.valueOf(item.getCTAmount()));
            table.addCell(item.getCTName());
            table.addCell(String.valueOf(item.getCTDate()));
            table.addCell(String.valueOf(item.getCTID()));

        }
    }

    @FXML
    public void searchActionGold(ActionEvent event) {
        goldSearch(); // Call your search method here
    }

    public void goldSearch() {
        FilteredList<GoldTransaction> filter = new FilteredList<>(getGoldtransaction, e -> true);
        Gold_search.textProperty().addListener((Observable, oldValue, newValue) -> {
            filter.setPredicate(predicateOrderadata -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String searchkey = newValue.toLowerCase();
                if (predicateOrderadata.getDescription().toString().toLowerCase().contains(searchkey)) {
                    return true;
                } else return false;


            });
        });
        SortedList<GoldTransaction> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(GTtable.comparatorProperty());
        GTtable.setItems(sortList);
    }

    public ObservableList<GoldTransaction> getGoldtransaction() {
        ObservableList<GoldTransaction> goldTransactions = FXCollections.observableArrayList();

        String query = "select * from goldtransaction";
        con = databaseConnection.getConnection();
        try {
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
                GoldTransaction st = new GoldTransaction();
                st.setGTID(rs.getInt("GTID"));
                st.setRefno(rs.getInt("Refno"));
                st.setDescription(rs.getString("Description"));
                st.setAmount(rs.getInt("Amount"));
                goldTransactions.add(st);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return goldTransactions;
    }

    private ObservableList<GoldTransaction> getGoldtransaction;

    public void showGoldTransaction() {
        getGoldtransaction = getGoldtransaction();
        //table.setItems(list);
        GTcolref.setCellValueFactory(new PropertyValueFactory<GoldTransaction, Integer>("Refno"));
        GTcoldes.setCellValueFactory(new PropertyValueFactory<GoldTransaction, String>("Description"));
        GTcolamount.setCellValueFactory(new PropertyValueFactory<GoldTransaction, Integer>("Amount"));
        GTcolID.setCellValueFactory(new PropertyValueFactory<GoldTransaction, Integer>("GTID"));
        GTtable.setItems(getGoldtransaction);
    }

    @FXML
    void getDataGT(MouseEvent event) {
        GoldTransaction goldTransaction = GTtable.getSelectionModel().getSelectedItem();
        int num = GTtable.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        GTtxtRef.setText(String.valueOf(goldTransaction.getRefno()));
        GTtxtDes.setText(goldTransaction.getDescription());
        GTtxtAmount.setText(String.valueOf(goldTransaction.getAmount()));
        GTtxtID.setText(String.valueOf(goldTransaction.getGTID()));

    }

    @FXML
    void GTadd(ActionEvent event) {
        String insert = "insert into goldtransaction(GTID,Refno,Description,amount) values(?,?,?,?)";
        con = databaseConnection.getConnection();
        try {
            st = con.prepareStatement(insert);
            st.setString(1, GTtxtID.getText());
            st.setString(2, GTtxtRef.getText());
            st.setString(3, GTtxtDes.getText());
            st.setString(4, GTtxtAmount.getText());


            st.executeUpdate();
            showGoldTransaction();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void GTdelete(ActionEvent event) {
        GoldTransaction goldTransaction = GTtable.getSelectionModel().getSelectedItem();
        if (goldTransaction == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select a Gold transaction to delete");
            alert.showAndWait();
            return;
        }

        String sql = "DELETE FROM goldtransaction WHERE GTID = ?";

        connect = databaseConnection.getConnection();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setInt(1, goldTransaction.getGTID());
            prepare.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Transaction deleted successfully");
            alert.showAndWait();
            showGoldTransaction();
            GTClesr(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void GTupdate(ActionEvent event) {
        connect = databaseConnection.getConnection();
        String sql = "UPDATE goldtransaction SET Refno = ?, Description = ?, amount = ? WHERE GTID = ?";

        Alert alert = null;
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setInt(1, Integer.parseInt(GTtxtRef.getText()));
            prepare.setString(2, (GTtxtDes.getText()));
            prepare.setInt(3, Integer.parseInt(GTtxtAmount.getText()));
            prepare.setInt(4, Integer.parseInt(GTtxtID.getText()));


            prepare.executeUpdate();

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Record Updated Successfully");
            alert.showAndWait();

            //addSalaryAllowanceShowListData(); // Refresh the table after update
            showGoldTransaction();
            GTClesr(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void GTClesr(ActionEvent event) {
        GTtxtID.setText(null);
        GTtxtRef.setText("");
        GTtxtDes.setText("");
        GTtxtAmount.setText("");

    }

    //Nitishe's pdf generation part for Gold
    @FXML
    void generatePDFGold(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            String filePath = file.getAbsolutePath();
            //private TableView<GoldTransaction> GTtable;
            pdfGenerateGold(file, GTtable);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PDF Generated");
            alert.setHeaderText(null);
            alert.setContentText("PDF file generated successfully!");
            alert.showAndWait();
        }
    }

    public static void pdfGenerateGold(File file, TableView<GoldTransaction> GTtable) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            float[] columnWidths = {1f, 2f, 3f, 2f};
            table.setWidths(columnWidths);

            // Add table headers
            addTableHeaderGold(table);

            // Add table rows
            addRowsGold(table, GTtable);

            document.add(table);
            document.close();

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void addTableHeaderGold(PdfPTable table) {
        String[] headers = {"GTID", "Refno", "Description", "amount"};
        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(header));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(cell);
        }
    }

    private static void addRowsGold(PdfPTable table, TableView<GoldTransaction> tableView) {
        for (GoldTransaction item : tableView.getItems()) {
            table.addCell(String.valueOf(item.getGTID()));
            table.addCell(String.valueOf(item.getRefno()));
            table.addCell(item.getDescription());
            table.addCell(String.valueOf(item.getAmount()));
        }
    }

    @FXML
    void handleactionbutton(ActionEvent event) {
        if (event.getSource() == one) {
            display.setText(display.getText() + "1");
        } else if (event.getSource() == two) {
            display.setText(display.getText() + "2");
        } else if (event.getSource() == three) {
            display.setText(display.getText() + "3");
        } else if (event.getSource() == four) {
            display.setText(display.getText() + "4");
        } else if (event.getSource() == five) {
            display.setText(display.getText() + "5");
        } else if (event.getSource() == six) {
            display.setText(display.getText() + "6");
        } else if (event.getSource() == seven) {
            display.setText(display.getText() + "7");
        } else if (event.getSource() == eight) {
            display.setText(display.getText() + "8");
        } else if (event.getSource() == nine) {
            display.setText(display.getText() + "9");
        } else if (event.getSource() == zero) {
            display.setText(display.getText() + "0");
        } else if (event.getSource() == clear) {
            display.setText("");
        } else if (event.getSource() == plus) {
            data = Float.parseFloat(display.getText());
            operation = 1;//Addition
            display.setText("");
        } else if (event.getSource() == multiplication) {
            data = Float.parseFloat(display.getText());
            operation = 2;//multiplication
            display.setText("");
        } else if (event.getSource() == minus) {
            data = Float.parseFloat(display.getText());
            operation = 3;//minus
            display.setText("");
        } else if (event.getSource() == divide) {
            data = Float.parseFloat(display.getText());
            operation = 4;//divide
            display.setText("");
        } else if (event.getSource() == equals) {
            Float secondOperand = Float.parseFloat(display.getText());
            switch (operation) {
                case 1://addition
                    Float ans = data + secondOperand;
                    display.setText(String.valueOf(ans));
                    break;
                case 2://multi
                    ans = data * secondOperand;
                    display.setText(String.valueOf(ans));
                    break;
                case 3://subs
                    ans = data - secondOperand;
                    display.setText(String.valueOf(ans));
                    break;
                case 4://div
                    ans = 0f;
                    try {
                        ans = data / secondOperand;
                    } catch (Exception e) {
                        display.setText("Error");
                    }
                    display.setText(String.valueOf(ans));
                    break;
            }
        }
    }


    /********************************************Siyam****************************************************/
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

                clearInvCat(event);
                txtInvCatName.requestFocus();

            } catch (SQLIntegrityConstraintViolationException e) {
                // Handle database errors caused by the uniqueness constraint
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Error Message");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Error adding inventory category: Category already exists.");
                errorAlert.showAndWait();
            } catch (SQLException ex) {
                ex.printStackTrace();
                // Handle other database or insertion errors
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

    public void tableInventoryCat() {
        int[] myIndex = new int[1];
        int[] id = new int[1];
        ObservableList<InventoryCategory> inventoryCategories = FXCollections.observableArrayList();

        try {
            pst = connect.prepareStatement("SELECT id,category from inventoryCat");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    InventoryCategory it = new InventoryCategory();

                    it.setId(rs.getString("id"));
                    it.setName(rs.getString("category"));
                    inventoryCategories.add(it);
                }
            }
            tableInvCat.setItems(inventoryCategories);
            colInvCatId.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getId()));
            colInvCatName.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getName()));

        } catch (Exception ex) {
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
        String name = txtInvCatName.getText().trim(); // Trim to remove leading/trailing whitespace
        int myIndex = tableInvCat.getSelectionModel().getSelectedIndex();

        if (myIndex < 0) {
            Alert noSelectionAlert = new Alert(Alert.AlertType.WARNING);
            noSelectionAlert.setTitle("Warning");
            noSelectionAlert.setHeaderText(null);
            noSelectionAlert.setContentText("Please select a category to update.");
            noSelectionAlert.showAndWait();
            return;
        }

        int id = Integer.parseInt(tableInvCat.getItems().get(myIndex).getId());

        if (name.isEmpty()) {
            // Show a warning if the category name is empty
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("Warning");
            warningAlert.setHeaderText(null);
            warningAlert.setContentText("Please enter a category name.");
            warningAlert.showAndWait();
            return;
        }

        try {
            pst = connect.prepareStatement("UPDATE inventoryCat SET category = ? WHERE id = ?");
            pst.setString(1, name);
            pst.setInt(2, id);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Inventory category updated successfully");
            alert.showAndWait();

            tableInventoryCat();
            clearInvCat(event);

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle database errors caused by the uniqueness constraint
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error Message");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Error updating inventory category: Category already exists.");
            errorAlert.showAndWait();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle database or insertion errors
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error Message");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Error updating inventory category: " + ex.getMessage());
            errorAlert.showAndWait();
        }
    }

    @FXML
    void deleteInvCat(ActionEvent event) {
        int myIndex = tableInvCat.getSelectionModel().getSelectedIndex();

        if (myIndex < 0) {
            Alert noSelectionAlert = new Alert(Alert.AlertType.WARNING);
            noSelectionAlert.setTitle("Warning");
            noSelectionAlert.setHeaderText(null);
            noSelectionAlert.setContentText("Please select a category to delete.");
            noSelectionAlert.showAndWait();
            return;
        }

        int id = Integer.parseInt(tableInvCat.getItems().get(myIndex).getId());

        try {
            pst = connect.prepareStatement("DELETE FROM inventoryCat WHERE id = ?");
            pst.setInt(1, id);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Inventory category deleted successfully");
            alert.showAndWait();

            tableInventoryCat();
            clearInvCat(event);

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle database or insertion errors
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error Message");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Error deleting inventory category: " + ex.getMessage());
            errorAlert.showAndWait();
        }
    }

    private void searchInventoryCategory(String searchText) {
        ObservableList<InventoryCategory> filteredList = FXCollections.observableArrayList();

        try {
            pst = connect.prepareStatement("SELECT id, category FROM inventoryCat WHERE category LIKE ?");
            pst.setString(1, "%" + searchText + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                InventoryCategory category = new InventoryCategory();

                category.setId(rs.getString("id"));
                category.setName(rs.getString("category"));
                filteredList.add(category);
            }

            tableInvCat.setItems(filteredList);
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle database errors
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error Message");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Error searching inventory categories: " + ex.getMessage());
            errorAlert.showAndWait();
        }
    }

    @FXML
    void clearInvCat(ActionEvent event) {
        txtInvCatName.setText("");
    }


    //Inventory Type
    private ObservableList<String> getCategoryList() {
        ObservableList<String> categories = FXCollections.observableArrayList();
        try {
            pst = connect.prepareStatement("SELECT category FROM inventoryCat");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                categories.add(rs.getString("category"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return categories;
    }

    @FXML
    void addInvType(ActionEvent event) {
        String category = invCatComboBox.getValue(); // Retrieve category from ComboBox
        String name = txtInvTypeName.getText().trim(); // Trim to remove leading/trailing whitespace
        String status = txtInvTypeStatus.getText().trim(); // Trim to remove leading/trailing whitespace
        int qty = 0;

        try {
            qty = Integer.parseInt(txtInvTypeQty.getText().trim());
        } catch (NumberFormatException e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error Message");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Please enter a valid quantity.");
            errorAlert.showAndWait();
            return;
        }

        if (category == null || name.isEmpty() || status.isEmpty()) {
            // Show a warning if any of the fields are empty
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("Warning");
            warningAlert.setHeaderText(null);
            warningAlert.setContentText("Please fill in all fields.");
            warningAlert.showAndWait();
            return;
        }

        try {
            pst = connect.prepareStatement("INSERT INTO inventory(inventoryName,inventoryCat,inventoryQty,inventoryStatus) VALUES(?,?,?,?)");
            pst.setString(1, name);
            pst.setString(2, category);
            pst.setInt(3, qty);
            pst.setString(4, status);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Inventory type added successfully");
            alert.showAndWait();

            tableInventoryType();
            clearInvType(event);
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle database or insertion errors
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error Message");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Error adding inventory type: " + ex.getMessage());
            errorAlert.showAndWait();
        }
    }


    public void tableInventoryType() {
        int[] myIndex = new int[1];
        int[] idType = new int[1];

        ObservableList<InventoryType> inventoryTypes = FXCollections.observableArrayList();
        ObservableList<String> categories = getCategoryList();

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

        // Set categories to the combo box
        invCatComboBox.setItems(categories);

        tableInvType.setRowFactory(tv -> {
            TableRow<InventoryType> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex[0] = tableInvType.getSelectionModel().getSelectedIndex();
                    idType[0] = Integer.parseInt(String.valueOf(tableInvType.getItems().get(myIndex[0]).getId()));
                    InventoryType selectedItem = tableInvType.getSelectionModel().getSelectedItem();
                    txtInvTypeName.setText(selectedItem.getName());
                    invCatComboBox.setValue(selectedItem.getCategory()); // Set selected category in the combo box
                    txtInvTypeQty.setText(String.valueOf(selectedItem.getQuantity()));
                    txtInvTypeStatus.setText(selectedItem.getStatus());
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

                String name = txtInvTypeName.getText().trim(); // Trim to remove leading/trailing whitespace
                String category = invCatComboBox.getValue(); // Retrieve category from ComboBox
                String status = txtInvTypeStatus.getText().trim(); // Trim to remove leading/trailing whitespace
                int qty = 0;

                try {
                    qty = Integer.parseInt(txtInvTypeQty.getText().trim());
                } catch (NumberFormatException e) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setTitle("Error Message");
                    errorAlert.setHeaderText(null);
                    errorAlert.setContentText("Please enter a valid quantity.");
                    errorAlert.showAndWait();
                    return;
                }

                if (name.isEmpty() || category == null || status.isEmpty()) {
                    // Show a warning if any of the fields are empty
                    Alert warningAlert = new Alert(Alert.AlertType.WARNING);
                    warningAlert.setTitle("Warning Message");
                    warningAlert.setHeaderText(null);
                    warningAlert.setContentText("Please fill in all fields.");
                    warningAlert.showAndWait();
                    return;
                }

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
                clearInvType(event);

            } catch (SQLException ex) {
                ex.printStackTrace();
                // Handle database errors
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
                    clearInvType(event);
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

    private void searchInventoryType(String searchText) {
        ObservableList<InventoryType> filteredList = FXCollections.observableArrayList();

        try {
            pst = connect.prepareStatement("SELECT id, inventoryName, inventoryCat, inventoryQty, inventoryStatus FROM inventory WHERE inventoryName LIKE ? OR inventoryCat LIKE ? OR inventoryStatus LIKE ?");
            pst.setString(1, "%" + searchText + "%");
            pst.setString(2, "%" + searchText + "%");
            pst.setString(3, "%" + searchText + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                InventoryType it = new InventoryType();

                it.setId(rs.getInt("id"));
                it.setName(rs.getString("inventoryName"));
                it.setCategory(rs.getString("inventoryCat"));
                it.setQuantity(rs.getInt("inventoryQty"));
                it.setStatus(rs.getString("inventoryStatus"));
                filteredList.add(it);
            }

            tableInvType.setItems(filteredList);
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle database errors
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error Message");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Error searching inventory types: " + ex.getMessage());
            errorAlert.showAndWait();
        }
    }

    @FXML
    void clearInvType(ActionEvent event) {
        txtInvTypeName.clear();
        invCatComboBox.getSelectionModel().clearSelection();
        txtInvTypeQty.clear();
        txtInvTypeStatus.clear();
    }

    @FXML
    void generatePDFInv(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            String filePath = file.getAbsolutePath();
            pdfGenerateInv(file, tableInvType);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PDF Generated");
            alert.setHeaderText(null);
            alert.setContentText("PDF file generated successfully!");
            alert.showAndWait();
        }
    }

    public static void pdfGenerateInv(File file, TableView<InventoryType> tableInvType) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            float[] columnWidths = {1f, 2f, 3f, 2f, 1f};
            table.setWidths(columnWidths);

            // Add table headers
            addTableHeaderInv(table);

            // Add table rows
            addRowsInv(table, tableInvType);

            document.add(table);
            document.close();

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void addTableHeaderInv(PdfPTable table) {
        String[] headers = {"Id", "Category", "Name", "Status", "QTY"};
        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(header));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(cell);
        }
    }

    private static void addRowsInv(PdfPTable table, TableView<InventoryType> tableView) {
        for (InventoryType item : tableView.getItems()) {
            table.addCell(String.valueOf(item.getId()));
            table.addCell(item.getCategory());
            table.addCell(item.getName());
            table.addCell(item.getStatus());
            table.addCell(String.valueOf(item.getQuantity()));
        }
    }

    public void IqSendEmail() {
        // Validate email, subject, and description
        if (!isValidEmail(txtIqEmail.getText())) {
            showEmailAlert(Alert.AlertType.ERROR, "Error", null, "Please enter a valid email address.");
            return;
        }
        if (txtIqSubject.getText().isEmpty()) {
            showEmailAlert(Alert.AlertType.ERROR, "Error", null, "Please enter a subject.");
            return;
        }
        if (txtIqDescription.getText().isEmpty()) {
            showEmailAlert(Alert.AlertType.ERROR, "Error", null, "Please enter a description.");
            return;
        }

        String from = "gsystem626@gmail.com";
        String host = "localhost";
        String port = "465";

        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");

        final String username = "gsystem626@gmail.com";
        final String password = "icbz jqsn vnha bgng";

        try {
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(username));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(txtIqEmail.getText(), false));
            msg.setSubject(txtIqSubject.getText());
            msg.setText(txtIqDescription.getText());

            msg.setSentDate(new Date());
            Transport.send(msg);

            // Show confirmation
            showEmailAlert(Alert.AlertType.INFORMATION, "Information Message", null, "E-Mail successfully Sent");

            // Clear fields
            txtIqEmail.clear();
            txtIqSubject.clear();
            txtIqDescription.clear();
        } catch (AddressException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void showEmailAlert(Alert.AlertType alertType, String title, String headerText, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
    public void switchform(ActionEvent event) {
        Dashboard_form.setVisible(false);
        Transactionnew_form.setVisible(false);
        MasterdataManagementform.setVisible(false);
        oderform.setVisible(false);
        billing_form.setVisible(false);
        payroll_form.setVisible(false);
        calendar_form.setVisible(false);
        inquiry_form.setVisible(false);
        allowances_form.setVisible(false);
        deduction_form.setVisible(false);
        salaryincrement_form.setVisible(false);
        salaryadvance_form.setVisible(false);
        payment_form.setVisible(false);
        Employee_form.setVisible(false);
        customer_form.setVisible(false);
        inventory_form.setVisible(false);


        if (event.getSource() == dasboardbtn) {
            Dashboard_form.setVisible(true);
            loadGoldRate();
        } else if (event.getSource() == transactionnewbtn) {
            Transactionnew_form.setVisible(true);
        } else if (event.getSource() == masterdatamanagementbtn) {
            MasterdataManagementform.setVisible(true);
        } else if (event.getSource() == ordermanagementbtn) {
            oderform.setVisible(true);
            orderSearch();
        } else if (event.getSource() == billingbtn) {
            billing_form.setVisible(true);
        } else if (event.getSource() == payrollbtn) {
            payroll_form.setVisible(true);
        } else if (event.getSource() == analyticsbtn) {
            calendar_form.setVisible(true);
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
        } else if (event.getSource() == m_employeebtn) {
            Employee_form.setVisible(true);
        } else if (event.getSource() == m_cudbtn) {
            customer_form.setVisible(true);
        } else if (event.getSource() == m_invenbtn) {
            inventory_form.setVisible(true);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addEmployeeShowListData();
        addCustomerShowListData();
        addOrderShowListData();
        orderCusId();
        orderEmpId();
        orderSpinner();
        dashboardNo_OR();
        dashboardNo_Emp();
        dashboardNoodOrGraph();
        dashboardNoTransGraph();
        populateCustomerNames();
        populateEmployeeNames();
        CB_calWeBTN.setOnAction(event -> calculateTotalWeight());
        CB_AmoCaBTN.setOnMouseClicked(event -> calculateTotalAmount());


        tableInventoryCat();
        txtSearchInvCat.textProperty().addListener((observable, oldValue, newValue) -> {
            searchInventoryCategory(newValue);
        });

        tableInventoryType();
        txtSearchInvType.textProperty().addListener((observable, oldValue, newValue) -> {
            searchInventoryType(newValue);
        });

        addSalaryAllowanceShowListData();
        orderSearch();
        showCashTransaction();
        showGoldTransaction();

        try {
            String whatsappWebUrl = "https://mysliit-my.sharepoint.com/personal/sa22447920_my_sliit_lk/_layouts/15/onedrive.aspx?isAscending=true&id=%2Fpersonal%2Fsa22447920%5Fmy%5Fsliit%5Flk%2FDocuments%2FInvoice&sortField=LinkFilename&view=0";
            Image qrCodeImage = generateQRCodeImage(whatsappWebUrl, 200, 200);
            paymentImage.setImage(qrCodeImage);
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions as needed
        }

        dateFocus = ZonedDateTime.now();
        today = ZonedDateTime.now();
        drawCalendar();

    }

    private void loadGoldRate() {
        final String API_KEY = "a73c1ddc6a36b7d12186518c0876c4d9";
        final String BASE_CURRENCY = "XAU";
        final String CURRENCIES = "LKR";
        final String API_URL = "https://api.metalpriceapi.com/v1/latest?api_key=" + API_KEY + "&base=" + BASE_CURRENCY + "&currencies=" + CURRENCIES;

        //https://api.metalpriceapi.com/v1/latest?api_key=a73c1ddc6a36b7d12186518c0876c4d9&base=XAU&currencies=USD
        try {
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse the JSON response
            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(response.toString());
            JSONObject rates = (JSONObject) jsonResponse.get("rates");
            double lkr = (double) rates.get("LKR");
            double lrkPerPawn = (lkr / 32 * 8);
            // Update the label with the gold rate
            txtGoldRate.setText(String.valueOf(String.format("%.2f", lrkPerPawn)));
        } catch (IOException e) {
            txtGoldRate.setText("Error loading gold rate");
            //e.printStackTraceΩrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

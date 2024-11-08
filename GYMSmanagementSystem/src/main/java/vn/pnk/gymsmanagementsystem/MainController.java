/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vn.pnk.gymsmanagementsystem;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import vn.pnk.gymsmanagementsystem.coaches.Coach;
import vn.pnk.gymsmanagementsystem.coaches.CoachListWrapper;
import vn.pnk.gymsmanagementsystem.customer.Customer;
import vn.pnk.gymsmanagementsystem.customer.CustomerListWrapper;
import vn.pnk.gymsmanagementsystem.payments.CustomerDataLoader;
import vn.pnk.gymsmanagementsystem.payments.Payment;

import vn.pnk.gymsmanagementsystem.utils.XMLUtils;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class MainController implements Initializable {

    @FXML
    private Button Coaches_updateBtn;

    @FXML
    private AnchorPane Dashboard_NC;

    @FXML
    private AnchorPane Dashboard_NM;

    @FXML
    private AnchorPane Dashboard_TI;

    @FXML
    private AnchorPane Dashboard_form;

    @FXML
    private AreaChart<String, Number> Dashboard_incomeChart;

    @FXML
    private ComboBox<String> coaches_Status;

    @FXML
    private Button coaches_addBtn;

    @FXML
    private TextArea coaches_address;

    @FXML
    private Button coaches_btn;

    @FXML
    private TextField coaches_coachID;

    @FXML
    private TableColumn<Coach, String> coaches_col_address;

    @FXML
    private TableColumn<Coach, String> coaches_col_coachID;

    @FXML
    private TableColumn<Coach, String> coaches_col_gender;

    @FXML
    private TableColumn<Coach, String> coaches_col_name;

    @FXML
    private TableColumn<Coach, String> coaches_col_phone;

    @FXML
    private TableColumn<Coach, String> coaches_col_status;

    @FXML
    private Button coaches_deleteBtn;
    
    @FXML
    private Label date;

    @FXML
    private AnchorPane coaches_form;

    @FXML
    private ComboBox<String> coaches_gender;

    @FXML
    private TextField coaches_name;

    @FXML
    private TextField coaches_phoneNumber;

    @FXML
    private Button coaches_resetBtn;

    @FXML
    private Button customer_addBtn;

    @FXML
    private TextArea customer_address;

    @FXML
    private Button customer_btn;
    
    @FXML 
    private Label formMessage;

    @FXML
    private Button customer_clearBtn;

    @FXML
    private TableColumn<Customer, String> customer_col_address;

    @FXML
    private TableColumn<Customer, String> customer_col_customerID;

    @FXML
    private TableColumn<Customer, String> customer_col_endDate;

    @FXML
    private TableColumn<Customer, String> customer_col_gender;

    @FXML
    private TableColumn<Customer, String> customer_col_name;

    @FXML
    private TableColumn<Customer, String> customer_col_phoneNumber;

    @FXML
    private TableColumn<Customer, String> customer_col_schedule;

    @FXML
    private TableColumn<Customer, String> customer_col_startDate;

    @FXML
    private TableColumn<Customer, String> customer_col_status;

    @FXML
    private TextField customer_customerID;

    @FXML
    private Button customer_deleteBtn;

    @FXML
    private DatePicker customer_endDate;

    @FXML
    private AnchorPane customer_form;

    @FXML
    private ComboBox<String> customer_gender;

    @FXML
    private TextField customer_name;

    @FXML
    private TextField customer_phoneNumber;

    @FXML
    private ComboBox<String> customer_schedule;

    @FXML
    private DatePicker customer_startDate;

    @FXML
    private ComboBox<String> customer_status;

    @FXML
    private Button customer_updateBtn;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Button logout;
    
    @FXML
    private TextField customer_id_payment;

    @FXML
    private TextField name_payment;

    @FXML
    private Button payment_btn;

    @FXML
    private TableColumn<Payment, String> payment_col_customerID;

    @FXML
    private TableColumn<Payment, String> payment_col_endDate;

    @FXML
    private TableColumn<Payment, String> payment_col_name;

    @FXML
    private TableColumn<Payment, String> payment_col_startDate;

    @FXML
    private TableColumn<Payment, String> payment_col_status;

    @FXML
    private AnchorPane payment_form;
    
    @FXML
    private TableView<Coach> coaches_table;
    
    @FXML
    private TableView<Customer> customer_table;
    
    @FXML
    private TableView<Payment> payment_table;
    
    @FXML
    private Label totalCoachesLabel;
    @FXML
    private Label totalCustomersLabel;
    
    @FXML
    private Label income;
    
    @FXML
    private Button pay_btn;
    
    @FXML
    private Label total_payment;
    
    @FXML
    private Label change_payment;
    
    @FXML
    private TextField payment_amount;
    
    @FXML
    private TextField startDate_payment;
    
    @FXML
    private TextField endDate_payment;
    
    private double x = 0;
    
    private double y = 0;
    
    @FXML
    private Label id;
    
    @FXML
    private Label name;
    
    private String[] gender = {"Male", "Female", "Others"};

    public void coachGenderList(){
        List<String> genderList = new ArrayList<>();
        
        for (String data: gender){
            genderList.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(genderList);
        coaches_gender.setItems(listData);
    }
    
     public void customerGenderList(){
        List<String> genderList = new ArrayList<>();
        
        for (String data: gender){
            genderList.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(genderList);
        customer_gender.setItems(listData);
    }
    
    private String[] status = {"Active", "Not Active"};
    
    public void coachStatus(){
        List<String> coachList = new ArrayList<>();
        
        for (String data: status){
            coachList.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(coachList);
        coaches_Status.setItems(listData);   
    }
    
    public void customerStatus(){
        List<String> customerList = new ArrayList<>();
        
        for (String data: status){
            customerList.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(customerList);
        customer_status.setItems(listData);    
    }
    
    private String[] ScheduleList = {"9AM - 11AM", "11AM - 1PM", "1PM - 5PM", "5PM - 7PM"};
    
    public void customerSchedule(){
        List<String> scheduleList = new ArrayList<>();
        
        for (String data: ScheduleList){
            scheduleList.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(scheduleList);
        customer_schedule.setItems(listData);       
    }
    
    /**
     * Initializes the controller class.
     */
    private CoachListWrapper coachListWrapper = new CoachListWrapper();
    private CustomerListWrapper customerListWrapper = new CustomerListWrapper();
    private ObservableList<Customer> customerList;
    private ObservableList<Coach> coachList;
    private ObservableList<Payment> paymentList;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        showLoginDate();
 
        List<String> coachDataList = XMLUtils.readDataFromXML("coaches.xml");
        for (String data : coachDataList) {
            String[] parts = data.split(", ");
            Coach coach = new Coach(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
            coachListWrapper.addCoach(coach);
        }
        
        coaches_col_coachID.setCellValueFactory(cellData -> cellData.getValue().coachIdProperty());
        coaches_col_name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        coaches_col_gender.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        coaches_col_phone.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
        coaches_col_address.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        coaches_col_status.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        coaches_table.setItems(coachListWrapper.getCoachList());
        
        // Khi người dùng chọn một hàng trong bảng
        coaches_table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Coach selectedCoach = newValue;

                coaches_coachID.setText(selectedCoach.getCoachId());
                coaches_name.setText(selectedCoach.getName());
                coaches_gender.setValue(selectedCoach.getGender());
                coaches_phoneNumber.setText(selectedCoach.getPhoneNumber());
                coaches_address.setText(selectedCoach.getAddress());
                coaches_Status.setValue(selectedCoach.getStatus());
            }
        });

        coachStatus();
        coachGenderList();
        
        List<String> customerDataList = XMLUtils.readCustomerDataFromXML("customers.xml");
        for (String data : customerDataList) {
            String[] parts = data.split(", ");
            Customer customer = new Customer(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8]);
            customerListWrapper.addCustomer(customer);
        }

        customer_col_customerID.setCellValueFactory(cellData -> cellData.getValue().customerIdProperty());
        customer_col_name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        customer_col_gender.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        customer_col_phoneNumber.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
        customer_col_address.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        customer_col_status.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        customer_col_schedule.setCellValueFactory(cellData -> cellData.getValue().scheduleProperty());
        customer_col_startDate.setCellValueFactory(cellData -> cellData.getValue().startDateProperty());
        customer_col_endDate.setCellValueFactory(cellData -> cellData.getValue().endDateProperty());

        customer_table.setItems(customerListWrapper.getCustomerList());
        
        // Khi người dùng chọn một hàng trong bảng
        customer_table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Customer selectedCustomer = newValue;

                customer_customerID.setText(selectedCustomer.getCustomerId());
                customer_name.setText(selectedCustomer.getName());
                customer_gender.setValue(selectedCustomer.getGender());
                customer_phoneNumber.setText(selectedCustomer.getPhoneNumber());
                customer_address.setText(selectedCustomer.getAddress());
                customer_status.setValue(selectedCustomer.getStatus());
                customer_schedule.setValue(selectedCustomer.getSchedule());
                customer_startDate.setValue(LocalDate.parse(selectedCustomer.getStartDate()));
                customer_endDate.setValue(LocalDate.parse(selectedCustomer.getEndDate()));
            }
        });
        
        customerStatus();
        customerGenderList();
        customerSchedule();
        
        payment_col_customerID.setCellValueFactory(cellData -> cellData.getValue().customerIdProperty());
        payment_col_name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        payment_col_startDate.setCellValueFactory(cellData -> cellData.getValue().startDateProperty());
        payment_col_endDate.setCellValueFactory(cellData -> cellData.getValue().endDateProperty());
        payment_col_status.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        loadCustomerData();
        
        payment_table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Payment selectedPayment = newValue;
                customer_id_payment.setText(selectedPayment.getCustomerId());
                name_payment.setText(selectedPayment.getName());
                startDate_payment.setText(selectedPayment.getStartDate());
                endDate_payment.setText(selectedPayment.getEndDate());

                calculateTotalPayment(selectedPayment.getCustomerId());
            }
        });
        
        updateCoachAndCustomerCount();
    }   
      
    private void loadCustomerData() {
        CustomerDataLoader loader = new CustomerDataLoader();
        List<Payment> payments = loader.loadPaymentsFromXML("customers.xml");
        ObservableList<Payment> paymentList = FXCollections.observableArrayList(payments);
        payment_table.setItems(paymentList);
    }

    @FXML
    public void logout(){
        try{
            Stage currentStage = (Stage) logout.getScene().getWindow(); 
            App.setRoot(currentStage, "login", 600, 400);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Thêm huấn luyện viên
    @FXML
    public void addCoach(ActionEvent event) {
        String coachID = coaches_coachID.getText();
        String name = coaches_name.getText();
        String gender = (String) coaches_gender.getValue();
        String phoneNumber = coaches_phoneNumber.getText();
        String address = coaches_address.getText();
        String status = (String) coaches_Status.getValue();

        Coach newCoach = new Coach(coachID, name, gender, phoneNumber, address, status);
        coachListWrapper.addCoach(newCoach);
        coaches_table.setItems(coachListWrapper.getCoachList()); 
        

        XMLUtils.writeDataToXML("coaches.xml", coachListWrapper.getCoachList());
        updateCoachAndCustomerCount();
    }
    
    // Xóa huấn luyện viên
    @FXML
    public void deleteCoach(ActionEvent event) {
        String coachID = coaches_coachID.getText();
        coachListWrapper.deleteCoach(coachID);
        coaches_table.setItems(coachListWrapper.getCoachList()); 
    }

    // Cập nhật huấn luyện viên
    @FXML
    public void updateCoach(ActionEvent event) {
        String coachID = coaches_coachID.getText();
        String name = coaches_name.getText();
        String gender = (String) coaches_gender.getValue();
        String phoneNumber = coaches_phoneNumber.getText();
        String address = coaches_address.getText();
        String status = (String) coaches_Status.getValue();

        Coach updatedCoach = new Coach(coachID, name, gender, phoneNumber, address, status);
        coachListWrapper.updateCoach(coachID, updatedCoach);
        coaches_table.setItems(coachListWrapper.getCoachList()); 
    }
    
    //Luu khach hang
    @FXML
    public void addCustomer(ActionEvent event) {
        String customerID = customer_customerID.getText();
        String name = customer_name.getText();
        String gender = (String) customer_gender.getValue();
        String phoneNumber = customer_phoneNumber.getText();
        String address = customer_address.getText();
        String status = (String) customer_status.getValue();
        String schedule = (String) customer_schedule.getValue();
        String startDate = customer_startDate.getValue().toString();
        String endDate = customer_endDate.getValue().toString();

        Customer newCustomer = new Customer(customerID, name, gender, phoneNumber, address, status, schedule, startDate, endDate);
        customerListWrapper.addCustomer(newCustomer);
        customer_table.setItems(customerListWrapper.getCustomerList());

        XMLUtils.writeCustomerDataToXML("customers.xml", customerListWrapper.getCustomerList());
        updateCoachAndCustomerCount();
        loadCustomerData();
    }
    
    //xoa khach hang
    @FXML
    public void deleteCustomer(ActionEvent event) {
        String customerID = customer_customerID.getText();
        customerListWrapper.deleteCustomer(customerID);
        customer_table.setItems(customerListWrapper.getCustomerList());

        XMLUtils.writeCustomerDataToXML("customers.xml", customerListWrapper.getCustomerList());
    }
    
    //update khach hang
    @FXML
    public void updateCustomer(ActionEvent event) {
        String customerID = customer_customerID.getText();
        String name = customer_name.getText();
        String gender = (String) customer_gender.getValue();
        String phoneNumber = customer_phoneNumber.getText();
        String address = customer_address.getText();
        String status = (String) customer_status.getValue();
        String schedule = (String) customer_schedule.getValue();
        String startDate = customer_startDate.getValue().toString();
        String endDate = customer_endDate.getValue().toString();

        Customer updatedCustomer = new Customer(customerID, name, gender, phoneNumber, address, status, schedule, startDate, endDate);
        customerListWrapper.updateCustomer(customerID, updatedCustomer);
        customer_table.setItems(customerListWrapper.getCustomerList());

        XMLUtils.writeCustomerDataToXML("customers.xml", customerListWrapper.getCustomerList());
        
        loadCustomerData();
    }
    
    @FXML
    public void resetForm(ActionEvent event) {
        // Reset coach
        coaches_coachID.clear();
        coaches_name.clear();
        coaches_phoneNumber.clear();
        coaches_address.clear();
        coaches_gender.getSelectionModel().clearSelection();
        coaches_Status.getSelectionModel().clearSelection();
    }

    @FXML
    public void resetForm_c(ActionEvent event) {
        // Reset cus
        customer_customerID.clear();
        customer_name.clear();
        customer_phoneNumber.clear();
        customer_address.clear();
        customer_gender.getSelectionModel().clearSelection();
        customer_status.getSelectionModel().clearSelection();
        customer_schedule.getSelectionModel().clearSelection();
        customer_startDate.setValue(null);
        customer_endDate.setValue(null);
    }
    @FXML
    public void switchForm(ActionEvent event){
        if (event.getSource() == dashboard_btn){
            
            Dashboard_form.setVisible(true);
            coaches_form.setVisible(false);
            customer_form.setVisible(false);
            payment_form.setVisible(false);
            
            formMessage.setText("Dashboard form");
            
        }else if (event.getSource() == coaches_btn){
            
            Dashboard_form.setVisible(false);
            coaches_form.setVisible(true);
            customer_form.setVisible(false);
            payment_form.setVisible(false);
            
            coachGenderList();
            coachStatus();
            
            formMessage.setText("Coach form");
        }else if (event.getSource() == customer_btn){
            
            Dashboard_form.setVisible(false);
            coaches_form.setVisible(false);
            customer_form.setVisible(true);
            payment_form.setVisible(false);
            
            customerStatus();
            customerGenderList();
            customerSchedule();
            
            formMessage.setText("Customer form");
            
        }else if (event.getSource() == payment_btn){
            
            Dashboard_form.setVisible(false);
            coaches_form.setVisible(false);
            customer_form.setVisible(false);
            payment_form.setVisible(true); 
            
            formMessage.setText("Payment form");
        }
    }
    
    private double daily_price = 2.00;

    @FXML
    private void calculateTotalPayment(String customerId) {
        double totalAmount = 0.0;
        LocalDate startDate = customer_startDate.getValue();
        LocalDate endDate = customer_endDate.getValue();

        // Kiểm tra ngày bắt đầu và ngày kết thúc
        if (startDate != null && endDate != null) {
            if (startDate.isAfter(endDate)) {
                change_payment.setText("none");
                return;
            }

            // Tính số ngày giữa 2 ngày
            long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
            totalAmount = daysBetween * daily_price;
        } else {
            change_payment.setText("none");
            return;
        }

        // Lấy số tiền khách hàng đã trả
        double amountPaid = 0.0;
        try {
            amountPaid = Double.parseDouble(payment_amount.getText());
        } catch (NumberFormatException e) {
            change_payment.setText("none");
            return;
        }

        // Tính tiền thừa
        double change = amountPaid - totalAmount;

        // Hiển thị kết quả
        change_payment.setText(String.format("%.2f", change));
        total_payment.setText(String.format("%.2f", totalAmount));
    }
    
    @FXML
    public long calculateTrainingDays(LocalDate startDate, LocalDate endDate) {
        if (startDate != null && endDate != null) {
            return ChronoUnit.DAYS.between(startDate, endDate);
        }
        return 0; 
    }
    
    @FXML
    private void updateCoachAndCustomerCount() {
        totalCoachesLabel.setText("" + coachListWrapper.getCoachList().size());
        totalCustomersLabel.setText("" + customerListWrapper.getCustomerList().size());
    }
    
    @FXML
    public void showLoginDate() {
        // Lấy ngày hiện tại
        LocalDate today = LocalDate.now();
        
        // Định dạng ngày theo kiểu bạn muốn (ví dụ: dd/MM/yyyy)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = today.format(formatter);
        
        // Hiển thị ngày vào Label
        date.setText("" + formattedDate);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.pnk.gymsmanagementsystem.payments;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Admin
 */
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class Payment {
    private final StringProperty customerId;
    private final StringProperty name;
    private final StringProperty startDate;
    private final StringProperty endDate;
    private final StringProperty status;
    private double paymentAmount;

    // Constructor
    public Payment(String customerID, String name, String startDate, String endDate, String status) {
        this.customerId = new SimpleStringProperty(customerID);
        this.name = new SimpleStringProperty(name);
        this.startDate = new SimpleStringProperty(startDate);
        this.endDate = new SimpleStringProperty(endDate);
        this.status = new SimpleStringProperty(status);
    }

    // Getter 
    public StringProperty customerIdProperty() {
        return customerId;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty startDateProperty() {
        return startDate;
    }

    public StringProperty endDateProperty() {
        return endDate;
    }

    public StringProperty statusProperty() {
        return status;
    }

    // Getter 
    public String getCustomerId() {
        return customerId.get();
    }

    public String getName() {
        return name.get();
    }

    public String getStartDate() {
        return startDate.get();
    }

    public String getEndDate() {
        return endDate.get();
    }

    public String getStatus() {
        return status.get();
    }
    
    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}

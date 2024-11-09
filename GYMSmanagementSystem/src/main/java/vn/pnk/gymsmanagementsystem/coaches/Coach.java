package vn.pnk.gymsmanagementsystem.coaches;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Coach {

    private StringProperty coachId;
    private StringProperty name;
    private StringProperty gender;
    private StringProperty phoneNumber;
    private StringProperty address;
    private StringProperty status;

    public Coach(String coachId, String name, String gender, String phoneNumber, String address, String status) {
        this.coachId = new SimpleStringProperty(coachId);
        this.name = new SimpleStringProperty(name);
        this.gender = new SimpleStringProperty(gender);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.address = new SimpleStringProperty(address);
        this.status = new SimpleStringProperty(status);
    }

    // Getter và Setter cho tất cả các thuộc tính
    public String getCoachId() {
        return coachId.get();
    }

    public StringProperty coachIdProperty() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId.set(coachId);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}

package vn.pnk.gymsmanagementsystem.customer;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {
    private final StringProperty customerId;
    private final StringProperty name;
    private final StringProperty gender;
    private final StringProperty phoneNumber;
    private final StringProperty address;
    private final StringProperty status;
    private final StringProperty schedule;
    private final StringProperty startDate;
    private final StringProperty endDate;

    public Customer(String customerId, String name, String gender, String phoneNumber, String address, String status, String schedule, String startDate, String endDate) {
        this.customerId = new SimpleStringProperty(customerId);
        this.name = new SimpleStringProperty(name);
        this.gender = new SimpleStringProperty(gender);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.address = new SimpleStringProperty(address);
        this.status = new SimpleStringProperty(status);
        this.schedule = new SimpleStringProperty(schedule);
        this.startDate = new SimpleStringProperty(startDate);
        this.endDate = new SimpleStringProperty(endDate);
    }

    public String getCustomerId() { 
        return customerId.get(); 
    }
    public String getName() { 
        return name.get(); 
    }
    public String getGender() { 
        return gender.get(); 
    }
    public String getPhoneNumber() { 
        return phoneNumber.get(); 
    }
    public String getAddress() { 
        return address.get(); 
    }
    public String getStatus() { 
        return status.get(); 
    }
    public String getSchedule() { 
        return schedule.get(); 
    }
    public String getStartDate() { 
        return startDate.get(); 
    }
    public String getEndDate() { 
        return endDate.get(); 
    }

    public StringProperty customerIdProperty() { 
        return customerId; 
    }
    public StringProperty nameProperty() { 
        return name; 
    }
    public StringProperty genderProperty() { 
        return gender; 
    }
    public StringProperty phoneNumberProperty() { 
        return phoneNumber; 
    }
    public StringProperty addressProperty() { 
        return address; 
    }
    public StringProperty statusProperty() { 
        return status; 
    }
    public StringProperty scheduleProperty() { 
        return schedule; 
    }
    public StringProperty startDateProperty() { 
        return startDate; 
    }
    public StringProperty endDateProperty() { 
        return endDate; 
    }

    public long calculateDaysBetweenStartAndEnd() {
        LocalDate start = LocalDate.parse((CharSequence) startDate);
        LocalDate end = LocalDate.parse((CharSequence) endDate);
        return ChronoUnit.DAYS.between(start, end);
    }
}

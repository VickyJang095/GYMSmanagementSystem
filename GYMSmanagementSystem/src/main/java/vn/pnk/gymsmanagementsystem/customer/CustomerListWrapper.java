package vn.pnk.gymsmanagementsystem.customer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CustomerListWrapper {
    private ObservableList<Customer> customerList = FXCollections.observableArrayList();

    public ObservableList<Customer> getCustomerList() {
        return customerList;
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public void deleteCustomer(String customerId) {
        customerList.removeIf(customer -> customer.getCustomerId().equals(customerId));
    }

    public void updateCustomer(String customerId, Customer updatedCustomer) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerId().equals(customerId)) {
                customerList.set(i, updatedCustomer);
                break;
            }
        }
    }
}

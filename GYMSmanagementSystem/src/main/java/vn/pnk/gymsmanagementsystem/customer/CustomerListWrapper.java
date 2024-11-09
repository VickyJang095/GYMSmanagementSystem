package vn.pnk.gymsmanagementsystem.customer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Collection;

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

    public ObservableList<Customer> searchCustomersByName(String name) {
        ObservableList<Customer> foundCustomers = FXCollections.observableArrayList();
        for (Customer customer : customerList) {
            if (customer.getName().toLowerCase().contains(name.toLowerCase())) {
                foundCustomers.add(customer);
            }
        }
        return foundCustomers;
    }

    public void clearCustomerList() {
        customerList.clear();
    }

    public void addAll(Collection<Customer> customers) {
        customerList.addAll(customers);
    }

    public Customer getCustomerByIndex(int index) {
        if (index >= 0 && index < customerList.size()) {
            return customerList.get(index);
        }
        return null;
    }

    public boolean isEmpty() {
        return customerList.isEmpty();
    }

    public int getCustomerCount() {
        return customerList.size();
    }

    public void updateTable(ObservableList<Customer> newCustomerList) {
        this.customerList.setAll(newCustomerList);
    }
}

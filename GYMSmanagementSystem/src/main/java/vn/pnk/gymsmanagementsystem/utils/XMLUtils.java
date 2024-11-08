package vn.pnk.gymsmanagementsystem.utils;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import vn.pnk.gymsmanagementsystem.coaches.Coach;
import vn.pnk.gymsmanagementsystem.customer.Customer;

public class XMLUtils {

    // Đọc dữ liệu từ tệp XML và trả về một danh sách các đối tượng
    public static List<String> readDataFromXML(String filePath) {
        List<String> data = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return data;  // Nếu tệp không tồn tại, trả về danh sách rỗng
            }
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            
            NodeList nodeList = document.getElementsByTagName("coach");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;
                
                // Đọc dữ liệu của mỗi huấn luyện viên
                String coachID = element.getElementsByTagName("coachID").item(0).getTextContent();
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String gender = element.getElementsByTagName("gender").item(0).getTextContent();
                String phoneNumber = element.getElementsByTagName("phoneNumber").item(0).getTextContent();
                String address = element.getElementsByTagName("address").item(0).getTextContent();
                String status = element.getElementsByTagName("status").item(0).getTextContent();
                
                // Thêm đối tượng huấn luyện viên vào danh sách
                data.add(coachID + ", " + name + ", " + gender + ", " + phoneNumber + ", " + address + ", " + status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void writeDataToXML(String filePath, List<Coach> coachList) {
        try {
            // Khởi tạo DocumentBuilder để tạo và thao tác với XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            
            // Tạo phần tử root (coaches)
            Element rootElement = document.createElement("coaches");
            document.appendChild(rootElement);
            
            // Tạo phần tử coach cho mỗi huấn luyện viên trong danh sách
            for (Coach coach : coachList) {
                Element coachElement = document.createElement("coach");
                rootElement.appendChild(coachElement);
                
                // Tạo các phần tử con cho mỗi thuộc tính của huấn luyện viên
                Element coachID = document.createElement("coachID");
                coachID.appendChild(document.createTextNode(coach.getCoachId()));
                coachElement.appendChild(coachID);

                Element name = document.createElement("name");
                name.appendChild(document.createTextNode(coach.getName()));
                coachElement.appendChild(name);

                Element gender = document.createElement("gender");
                gender.appendChild(document.createTextNode(coach.getGender()));
                coachElement.appendChild(gender);

                Element phoneNumber = document.createElement("phoneNumber");
                phoneNumber.appendChild(document.createTextNode(coach.getPhoneNumber()));
                coachElement.appendChild(phoneNumber);
                
                String address = coach.getAddress().replace(",", ";");
                Element addressElement = document.createElement("address");
                addressElement.appendChild(document.createTextNode(address));
                coachElement.appendChild(addressElement);

                Element status = document.createElement("status");
                status.appendChild(document.createTextNode(coach.getStatus()));
                coachElement.appendChild(status);
            }
            
            // Ghi dữ liệu vào tệp XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void writeCustomerDataToXML(String filePath, List<Customer> customers) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element rootElement = document.createElement("customers");
            document.appendChild(rootElement);

            for (Customer customer : customers) {
                Element customerElement = document.createElement("customer");
                rootElement.appendChild(customerElement);

                // Tạo các phần tử con cho các thuộc tính của customer
                Element customerId = document.createElement("customerID");
                customerId.appendChild(document.createTextNode(customer.getCustomerId()));
                customerElement.appendChild(customerId);

                Element name = document.createElement("name");
                name.appendChild(document.createTextNode(customer.getName()));
                customerElement.appendChild(name);

                Element gender = document.createElement("gender");
                gender.appendChild(document.createTextNode(customer.getGender()));
                customerElement.appendChild(gender);

                Element phoneNumber = document.createElement("phoneNumber");
                phoneNumber.appendChild(document.createTextNode(customer.getPhoneNumber()));
                customerElement.appendChild(phoneNumber);

                Element address = document.createElement("address");
                address.appendChild(document.createTextNode(customer.getAddress()));
                customerElement.appendChild(address);

                Element status = document.createElement("status");
                status.appendChild(document.createTextNode(customer.getStatus()));
                customerElement.appendChild(status);

                Element schedule = document.createElement("schedule");
                schedule.appendChild(document.createTextNode(customer.getSchedule()));
                customerElement.appendChild(schedule);

                Element startDate = document.createElement("startDate");
                startDate.appendChild(document.createTextNode(customer.getStartDate()));
                customerElement.appendChild(startDate);

                Element endDate = document.createElement("endDate");
                endDate.appendChild(document.createTextNode(customer.getEndDate()));
                customerElement.appendChild(endDate);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> readCustomerDataFromXML(String filePath) {
        List<String> customerData = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return customerData; // Nếu tệp không tồn tại, trả về danh sách rỗng
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            NodeList customerNodes = document.getElementsByTagName("customer");
            for (int i = 0; i < customerNodes.getLength(); i++) {
                Node customerNode = customerNodes.item(i);
                if (customerNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element customerElement = (Element) customerNode;

                    String customerId = customerElement.getElementsByTagName("customerID").item(0).getTextContent();
                    String name = customerElement.getElementsByTagName("name").item(0).getTextContent();
                    String gender = customerElement.getElementsByTagName("gender").item(0).getTextContent();
                    String phoneNumber = customerElement.getElementsByTagName("phoneNumber").item(0).getTextContent();
                    String address = customerElement.getElementsByTagName("address").item(0).getTextContent();
                    String status = customerElement.getElementsByTagName("status").item(0).getTextContent();
                    String schedule = customerElement.getElementsByTagName("schedule").item(0).getTextContent();
                    String startDate = customerElement.getElementsByTagName("startDate").item(0).getTextContent();
                    String endDate = customerElement.getElementsByTagName("endDate").item(0).getTextContent();

                    customerData.add(customerId + ", " + name + ", " + gender + ", " + phoneNumber + ", " + address + ", " + status + ", " + schedule + ", " + startDate + ", " + endDate);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerData;
    }
    
    public static List<Customer> readCustomersFromXML(String filePath) {
        List<Customer> customers = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return customers;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            NodeList nodeList = document.getElementsByTagName("customer");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element customerElement = (Element) node;

                String customerId = customerElement.getElementsByTagName("customerID").item(0).getTextContent();
                String name = customerElement.getElementsByTagName("name").item(0).getTextContent();
                String gender = customerElement.getElementsByTagName("gender").item(0).getTextContent();
                String phoneNumber = customerElement.getElementsByTagName("phoneNumber").item(0).getTextContent();
                String address = customerElement.getElementsByTagName("address").item(0).getTextContent();
                String status = customerElement.getElementsByTagName("status").item(0).getTextContent();
                String schedule = customerElement.getElementsByTagName("schedule").item(0).getTextContent();
                String startDate = customerElement.getElementsByTagName("startDate").item(0).getTextContent();
                String endDate = customerElement.getElementsByTagName("endDate").item(0).getTextContent();

                // Khởi tạo đối tượng Customer với dữ liệu đọc được từ XML
                Customer customer = new Customer(customerId, name, gender, phoneNumber, address, status, schedule, startDate, endDate);
                customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }
}

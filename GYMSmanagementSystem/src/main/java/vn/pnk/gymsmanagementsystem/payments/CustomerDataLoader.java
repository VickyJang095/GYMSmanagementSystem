/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.pnk.gymsmanagementsystem.payments;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CustomerDataLoader {

    public List<Payment> loadPaymentsFromXML(String filePath) {
        List<Payment> customers = new ArrayList<>();

        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList customerNodes = doc.getElementsByTagName("customer");

            for (int i = 0; i < customerNodes.getLength(); i++) {
                Node node = customerNodes.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String customerID = element.getElementsByTagName("customerID").item(0).getTextContent();
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String startDate = element.getElementsByTagName("startDate").item(0).getTextContent();
                    String endDate = element.getElementsByTagName("endDate").item(0).getTextContent();
                    String status = element.getElementsByTagName("status").item(0).getTextContent();

                    Payment customer = new Payment(customerID, name, startDate, endDate, status);
                    customers.add(customer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }
}


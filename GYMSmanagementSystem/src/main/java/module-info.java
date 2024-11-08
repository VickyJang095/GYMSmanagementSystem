module vn.pnk.gymsmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.base;
    requires javafx.graphics;
    requires jakarta.xml.bind; 

    opens vn.pnk.gymsmanagementsystem to javafx.fxml; 
    opens vn.pnk.gymsmanagementsystem.User to jakarta.xml.bind; 
    exports vn.pnk.gymsmanagementsystem; 
}

module vn.pnk.gymsmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.base;
    requires javafx.graphics;

    opens vn.pnk.gymsmanagementsystem to javafx.fxml;
    exports vn.pnk.gymsmanagementsystem;
}

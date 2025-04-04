module com.example.exp.travelgogui {
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires com.fasterxml.jackson.dataformat.xml;
    requires com.dlsc.formsfx;
    requires javafx.controls;
    requires com.fasterxml.jackson.databind;
    requires com.ctc.wstx;
    requires java.desktop;

    opens com.example.exp.travelgogui to javafx.fxml;
    exports com.example.exp.travelgogui;
    exports com.example.exp.travelgogui.travel_database_screen.backend;
    opens com.example.exp.travelgogui.travel_database_screen.backend to javafx.fxml;
    exports com.example.exp.travelgogui.travel_database_screen;
    opens com.example.exp.travelgogui.travel_database_screen to javafx.fxml;
    exports com.example.exp.travelgogui.login_screen.backend to com.fasterxml.jackson.databind;
}
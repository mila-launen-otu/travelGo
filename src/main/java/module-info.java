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
    exports com.example.exp.travelgogui.backend;
    opens com.example.exp.travelgogui.backend to javafx.fxml;
}
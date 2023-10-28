module com.example.timeconverionapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.timeconverionapp to javafx.fxml;
    exports com.example.timeconverionapp;
}
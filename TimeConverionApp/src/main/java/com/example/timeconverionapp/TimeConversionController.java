package com.example.timeconverionapp;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class TimeConversionController implements Initializable {
    @FXML
    private ComboBox<String> sourceComboBox;
    @FXML
    private ComboBox<String> destinationComboBox;
    @FXML
    private Label sourceTimeLabel;
    @FXML
    private Label destinationTimeLabel;
    private void onConvertButtonClick() {
        convertTime(null); // You can reuse the existing conversion logic
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize ComboBoxes with country time zones
        sourceComboBox.getItems().addAll(
                "Europe/Bucharest", // Romania
                "Europe/Berlin",    // Germany
                "Europe/London",    // England
                "Asia/Shanghai",    // China
                "Europe/Istanbul",  // Turkey
                "America/Denver",   // New Mexico
                "America/New_York", // Washington, DC
                "Australia/Sydney", // Australia
                "Europe/Rome",      // Italy
                "Europe/Madrid"     // Spain
        );
        destinationComboBox.getItems().addAll(
                "Europe/Bucharest",
                "Europe/Berlin",
                "Europe/London",
                "Asia/Shanghai",
                "Europe/Istanbul",
                "America/Denver",
                "America/New_York",
                "Australia/Sydney",
                "Europe/Rome",
                "Europe/Madrid"
        );
    }

    public void convertTime(ActionEvent event) {
        String sourceCountry = sourceComboBox.getValue();
        String destinationCountry = destinationComboBox.getValue();

        if (sourceCountry != null && !sourceCountry.isEmpty() &&
                destinationCountry != null && !destinationCountry.isEmpty()) {
            ZoneId sourceTimeZone = ZoneId.of(sourceCountry);
            ZoneId destinationTimeZone = ZoneId.of(destinationCountry);

            ZonedDateTime sourceCountryTime = ZonedDateTime.now(sourceTimeZone);
            ZonedDateTime destinationCountryTime = ZonedDateTime.now(destinationTimeZone);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            sourceTimeLabel.setText("Source Country Time: " + sourceCountryTime.format(formatter));
            destinationTimeLabel.setText("Destination Country Time: " + destinationCountryTime.format(formatter));
        } else {
            sourceTimeLabel.setText("");
            destinationTimeLabel.setText("");
        }
    }
}

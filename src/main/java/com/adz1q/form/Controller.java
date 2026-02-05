package com.adz1q.form;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private CheckBox chx1;

    @FXML
    private CheckBox chx2;

    @FXML
    private CheckBox chx3;

    @FXML
    private CheckBox chx4;

    @FXML
    private Button btnGet;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnClose;

    @FXML
    private TextArea txtDescription;

    private CheckBox[] checkBoxes;
    private StringBuilder description = new StringBuilder();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        checkBoxes = new CheckBox[]{ chx1, chx2, chx3, chx4 };

        btnGet.setOnAction(e -> {
            description = new StringBuilder();

            if (txtFirstName.getText().isBlank()
                    || txtLastName.getText().isBlank()) {
                return;
            }

            description.append(txtFirstName.getText())
                    .append(" ")
                    .append(txtLastName.getText());

            for (var chx : checkBoxes) {
                check(chx);
            }

            txtDescription.setText(description.toString());
        });

        btnClear.setOnAction(e -> {
            txtFirstName.clear();
            txtLastName.clear();
            txtDescription.clear();
            description = new StringBuilder();

            for (var chx : checkBoxes) {
                chx.setSelected(false);
            }
        });

        btnClose.setOnAction(e -> Platform.exit());
    }

    private void check(CheckBox chx) {
        if (chx.isSelected()) {
            description.append("\n")
                    .append(chx.getText());
        }
    }
}

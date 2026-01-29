module com.adz1q.form {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.adz1q.form to javafx.fxml;
    exports com.adz1q.form;
}
module com.bodyfit {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.bodyfit to javafx.fxml;
    exports com.bodyfit;
}
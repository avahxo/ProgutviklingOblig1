module programutvikling {
    requires javafx.controls;
    requires javafx.fxml;

    opens programutvikling to javafx.fxml;
    exports programutvikling;
}
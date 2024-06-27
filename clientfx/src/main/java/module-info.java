module clientfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens clientfx to javafx.fxml;
    exports clientfx;
}

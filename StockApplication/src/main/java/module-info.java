module org.roehampton.sad_project.sad_stock_price_app {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.roehampton.sad_project.sad_stock_price_app to javafx.fxml;
    exports org.roehampton.sad_project.sad_stock_price_app;
}

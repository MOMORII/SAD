module org.roehampton.sad_project.sad_stock_price_app {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.roehampton.sad_project.sad_stock_price_app to javafx.fxml;
    opens org.roehampton.sad_project.sad_stock_price_app.data to javafx.base;

    exports org.roehampton.sad_project.sad_stock_price_app;
    exports org.roehampton.sad_project.sad_stock_price_app.business_model;
    exports org.roehampton.sad_project.sad_stock_price_app.data;
    exports org.roehampton.sad_project.sad_stock_price_app.ui;
    opens org.roehampton.sad_project.sad_stock_price_app.ui to javafx.fxml;


}

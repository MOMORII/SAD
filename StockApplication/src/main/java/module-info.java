module org.roehampton.sad_project.sad_stock_price_app {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.roehampton.sad_project.sad_stock_price_app to javafx.fxml;
    opens org.roehampton.sad_project.sad_stock_price_app.data to javafx.base;

    exports org.roehampton.sad_project.sad_stock_price_app;
    exports org.roehampton.sad_project.sad_stock_price_app.data;
    exports org.roehampton.sad_project.sad_stock_price_app.fetching;
    exports org.roehampton.sad_project.sad_stock_price_app.storage;
    exports org.roehampton.sad_project.sad_stock_price_app.UI;
    opens org.roehampton.sad_project.sad_stock_price_app.fetching to javafx.base;


}

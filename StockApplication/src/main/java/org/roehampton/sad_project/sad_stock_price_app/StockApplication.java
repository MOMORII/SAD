/**

CHANGES TO BE MADE (SUGGESTIONS FROM PRODUCT OWNER):

1. Implement error-catching (e.g., empty search bar, numbers,, and invalid stock symbols)

2. Switch APIs from yahooFinance to Alphavantage (free, relatively simple, and easy to use/implement into existing code)
^^^ please look up documentation if need be, resources should be readily available online for you to use

3. Make a "history" of stock symbols over a period of time, rather than just the current stock price at that time

4. Evidence, at least, one of each S.O.L.I.D principle applied in any area of the code.

5. Ensure that the component UML diagram and business UMLs are implemented into the code correctly.

6. Many classes are too simplistic and only PRINT out their functions to the terminal, rather than actually doing them. Please fix.

7. ALSO, make sure all the interfaces in 'business_model' have been readjusted and implemented, according to the component UML

ADDITIONAL CHANGE THAT NEEDS TO BE MADE: Stock symbol does not automatically appear under its bar. It should show up without needing to press 'GET PRICE' twice.
((also please add comments beneath the code blocks so it's clearer what happens, if possible whenever you're able to -keisha))
(( ensure the code blocks aren't just systemout (aka printing to the terminal) than actually doing what they're supposed to -keisha ))

**/

package org.roehampton.sad_project.sad_stock_price_app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * StockApplication is the entry point of the JavaFX app.
 *
 * SOLID:
 *  - Single Responsibility Principle (SRP): Only responsible for bootstrapping the JavaFX runtime
 *    and loading the main FXML.
 *  - No direct involvement with business logic or data storage; it just sets up the stage/scene.
 *
 * SOA:
 *  - Part of the overall architecture, but does not implement domain logic itself;
 *    it delegates UI handling to MainController, which in turn orchestrates the other services.
 */
public class StockApplication extends Application
{

    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/org/roehampton/sad_project/sad_stock_price_app/hello-view.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Stock Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

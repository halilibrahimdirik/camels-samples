package org.example;

import org.apache.camel.main.Main;
import org.example.routes.DirectEndPointRouter;

import java.util.concurrent.TimeUnit;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        Main main = new Main();
        //main.configure().addRoutesBuilder(new MyRouteBuilder());

        // Add routes to the camel context
        main.configure().addRoutesBuilder(new DirectEndPointRouter());

        main.run(args);
        main.getCamelContext().getShutdownStrategy().setTimeUnit(TimeUnit.SECONDS);
        main.getCamelContext().getShutdownStrategy().setTimeout(5);
        main.getCamelContext().getShutdownStrategy().setShutdownNowOnTimeout(true);
        main.getCamelContext().shutdown();


    }

}


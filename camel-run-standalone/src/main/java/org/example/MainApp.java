package org.example;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        // Create a new instance of Camel's Main class
        Main main = new Main();
        //main.configure().addRoutesBuilder(new MyRouteBuilder());

        // Create a new RouteBuilder object to hold our Camel routes
        RouteBuilder routeBuilder = new RouteBuilder() {
            public void configure() {
                from("timer://foo?period=2000")  // Trigger every 2 seconds
                        .setBody().simple("Hello, world!") // Change the Exchange Body to Hello world
                        .to("log:mylogger"); // Use the Log component to write out the contents of the Exchange
            }
        };
        main.configure().addRoutesBuilder(routeBuilder);
        main.configure().setDurationMaxSeconds(20); // Shut down after 20 seconds

        // Start the CamelContext
        // The Camel route will keep running, until terminated using Ctrl+C
        main.run(args);


    }

}


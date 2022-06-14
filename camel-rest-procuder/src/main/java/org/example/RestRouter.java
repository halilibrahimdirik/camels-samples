package org.example;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // call the embedded rest service from the PetController
        restConfiguration()
                .host("localhost")
                .port(8080);


        from("timer:hello?period={{timer.period}}")
                .setHeader("id", simple("${random(1,3)}"))
                .to("rest:get:pets/{id}")
                .log("${body}");
    }

}

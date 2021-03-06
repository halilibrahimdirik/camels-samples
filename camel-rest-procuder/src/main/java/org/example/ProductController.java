package org.example;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * Used for simulating a rest service which we can run locally inside Spring Boot
 */
@RestController
public class ProductController {

    private static final String[] PETS = new String[]{"Snoopy", "Fido", "Tony the Tiger"};

    @GetMapping(value = "/pets/{id}")
    public Map<String, String> petById(@PathVariable("id") Integer id) {
        if (id != null && id > 0 && id <= PETS.length + 1) {
            int index = id - 1;
            String pet = PETS[index];
            return Collections.singletonMap("name", pet);
        } else {
            return Collections.emptyMap();
        }
    }

}


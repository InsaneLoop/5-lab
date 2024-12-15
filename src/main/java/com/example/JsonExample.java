package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonExample {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Person person = objectMapper.readValue(new File("src/main/resources/input.json"), Person.class);
        person.setName("John Doe");
        person.getAddress().setCity("San Francisco");

        objectMapper.writeValue(new File("output.json"), person);
    }
}

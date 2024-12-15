package com.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class XmlExample {
    public static void main(String[] args) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();

        Person person = xmlMapper.readValue(new File("src/main/resources/input.xml"), Person.class);
        person.setName("John Doe");
        person.getAddress().setCity("San Francisco");

        xmlMapper.writeValue(new File("output.xml"), person);
    }
}

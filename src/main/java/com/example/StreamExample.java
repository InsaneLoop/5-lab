package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setName("Person" + i);
            person.setStudent(random.nextBoolean());

            Address address = new Address();
            address.setStreet("Street" + i);
            address.setCity("City" + random.nextInt(5));
            address.setState("State" + random.nextInt(3));
            person.setAddress(address);

            people.add(person);
        }

        List<Person> sortedPeople = people.stream()
                .sorted(Comparator.comparing(Person::getName)
                        .thenComparing(p -> p.getAddress().getCity()))
                .collect(Collectors.toList());

        List<Person> filteredPeople = sortedPeople.stream()
                .filter(p -> p.isStudent() && p.getAddress().getCity().equals("City1"))
                .collect(Collectors.toList());

        filteredPeople.forEach(p -> System.out.println(p.getName()));
    }
}

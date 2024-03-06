package org.academy2024.lab3;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {


    private record PersonRecord(String name, int age) {}

    @Test
    void testSetUniquinessProperty() {

        Set<PersonRecord> persons = new HashSet<>();
        persons.add(new PersonRecord("John", 25));
        persons.add(new PersonRecord("Jane", 30));
        persons.add(new PersonRecord("Doe", 35));

        // Adding a duplicate entry
        persons.add(new PersonRecord("John", 25));

        assertEquals(3, persons.size());
    }

}

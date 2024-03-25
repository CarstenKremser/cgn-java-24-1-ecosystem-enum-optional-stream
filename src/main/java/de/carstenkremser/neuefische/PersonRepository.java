package de.carstenkremser.neuefische;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PersonRepository {
    private Map<Integer,Person> persons = new HashMap();

    Optional<Person> getById(int id) {
        return Optional.ofNullable(persons.get(id));
    }

    void add(Person person) {
        persons.put(person.id(), person);
    }
}

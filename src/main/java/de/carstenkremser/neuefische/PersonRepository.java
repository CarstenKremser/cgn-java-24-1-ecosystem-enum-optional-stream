package de.carstenkremser.neuefische;

import java.util.*;

public class PersonRepository {
    private Map<Integer,Person> persons = new HashMap();

    Optional<Person> getById(int id) {
        return Optional.ofNullable(persons.get(id));
    }

    void add(Person person) {
        persons.put(person.id(), person);
    }

    int countOfGender(Gender gender) {
        int count = 0;
        for (Person person : persons.values()) {
            if (person.gender() == gender) {
                count++;
            }
        }
        return count;
    }

    Optional<Person> getByName(String name) {
        for (Person person : persons.values()) {
            if (person.name().equals(name)) {
                return Optional.of(person);
            }
        }
        return Optional.empty();
    }

    List<Person> getPersonsWithFavoriteWeekday(DaysOfWeek day) {
        List<Person>results = new ArrayList<>();
        for (Person  person : persons.values()) {
            if(person.favoriteDay().equals(day)) {
                results.add(person);
            }
        }
        return results;
    }
}

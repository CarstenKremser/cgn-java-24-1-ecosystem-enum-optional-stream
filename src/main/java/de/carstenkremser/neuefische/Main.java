package de.carstenkremser.neuefische;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepository();

        personRepository.add(new Person(1,"Anna",DaysOfWeek.SUNDAY,Gender.FEMALE));
        personRepository.add(new Person(2,"Bruno",DaysOfWeek.WEDNESDAY,Gender.MALE));
        personRepository.add(new Person(3,"Carla",DaysOfWeek.MONDAY,Gender.FEMALE));
        personRepository.add(new Person(4,"Daniel",DaysOfWeek.THURSDAY,Gender.MALE));
        personRepository.add(new Person(5,"Franziska",DaysOfWeek.SATURDAY,Gender.FEMALE));
        personRepository.add(new Person(6,"Georg",DaysOfWeek.WEDNESDAY,Gender.MALE));
        personRepository.add(new Person(7,"Hannah",DaysOfWeek.SUNDAY,Gender.FEMALE));
        personRepository.add(new Person(8,"Ingo",DaysOfWeek.FRIDAY,Gender.MALE));

        int randomId = (int)Math.round(Math.random()*12);
        Optional<Person> optionalPerson = personRepository.getById(randomId);
        if(optionalPerson.isPresent()){
            Person person = optionalPerson.get();
            System.out.println(person.name() + ": Favorite Day is " + person.favoriteDay());
            System.out.println(person.name() + ": Favorite Day is " + getWeekdayName(person.favoriteDay()));
        } else {
            System.out.println("Person with id " + randomId + " does not exist");
        }

        for (Gender gender:Gender.values()) {
            System.out.println("Gender: " + gender + " count: " + personRepository.countOfGender(gender));
        }

        String[] names = new String[] {"Anna", "Bertha", "Carla", "Dana"};
        for (String name : names) {
            Optional<Person> optionalPerson1 = personRepository.getByName(name);
            if(optionalPerson1.isPresent()) {
                System.out.println("Person with name " + name + ": " + optionalPerson1.get());
            } else {
                System.out.println("There is no person with name " + name);
            }
        }

        for (DaysOfWeek day: DaysOfWeek.values()) {
            System.out.println("Persons with favorite day " + day + ": " + personRepository.getPersonsWithFavoriteWeekday(day));
        }
    }

    public static String getWeekdayName(DaysOfWeek day) {
        return switch (day) {
            case SATURDAY, SUNDAY -> "Weekend";
            default -> day.toString();
        };
    }
}
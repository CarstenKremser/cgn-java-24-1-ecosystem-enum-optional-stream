package de.carstenkremser.neuefische;

import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepository();

        personRepository.add(new Person(1,"Anna",DaysOfWeek.SUNDAY));
        personRepository.add(new Person(2,"Bruno",DaysOfWeek.WEDNESDAY));
        personRepository.add(new Person(3,"Carla",DaysOfWeek.MONDAY));
        personRepository.add(new Person(4,"Daniel",DaysOfWeek.THURSDAY));
        personRepository.add(new Person(5,"Franziska",DaysOfWeek.SATURDAY));
        personRepository.add(new Person(6,"Georg",DaysOfWeek.WEDNESDAY));
        personRepository.add(new Person(7,"Hannah",DaysOfWeek.SUNDAY));
        personRepository.add(new Person(8,"Ingo",DaysOfWeek.FRIDAY));

        int randomId = (int)Math.round(Math.random()*12);
        Optional<Person> optionalPerson = personRepository.getById(randomId);
        if(optionalPerson.isPresent()){
            Person person = optionalPerson.get();
            System.out.println(person.name() + ": Favorite Day is " + person.favoriteDay());
            System.out.println(person.name() + ": Favorite Day is " + getWeekdayName(person.favoriteDay()));
        } else {
            System.out.println("Person with id " + randomId + " does not exist");
        }


        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
    }

    public static String getWeekdayName(DaysOfWeek day) {
        return switch (day) {
            case SATURDAY, SUNDAY -> "Weekend";
            default -> day.toString();
        };
    }
}
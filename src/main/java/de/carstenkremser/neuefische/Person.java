package de.carstenkremser.neuefische;

public record Person(
        int id,
        String name,
        DaysOfWeek favoriteDay
) {
}

package de.carstenkremser.neuefische;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class StreamExercise {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays
                .stream(new int[]{4,6,8,2,69,2,8,2,9,2,99,6,89,56,82,98,2,8})
                .boxed()
                .toList();

        List<Integer> evenNumbers = numbers.stream().filter(i -> (i%2==0)).toList();

        List<Integer> doubledNumbers = numbers.stream().map(i -> i*2).toList();

        List<Integer> sortedNumbers = numbers.stream().sorted().toList();

        int sumOfNumbers = numbers.stream().reduce(0,(prev,current) -> prev+current).intValue();

        System.out.println("even numbers:");
        evenNumbers.stream().forEach(x -> System.out.print(x+" "));
        System.out.println();

        System.out.println("doubled numbers:");
        doubledNumbers.stream().forEach(x -> System.out.print(x+" "));
        System.out.println();

        System.out.println("sorted numbers:");
        sortedNumbers.stream().forEach(x -> System.out.print(x+" "));
        System.out.println();

        System.out.println("sum of numbers: " + sumOfNumbers);
        System.out.println();

        try {
            System.out.println("=== File students.csv:");
            Files.lines(Path.of("students.csv")).forEach(System.out::println);
            System.out.println("=== Header removed:");
            Files.lines(Path.of("students.csv"))
                    .skip(1)
                    .forEach(System.out::println);

            System.out.println("=== create Student:");
            List<Student> students = Files.lines(Path.of("students.csv"))
                    .skip(1)
                    .map(line -> {
                        if (line.trim().length() > 0) {
                            String[] l = line.split("\\s*,\\s*");
                            int id = Integer.valueOf(l[0]);
                            int age = Integer.valueOf(l[3]);
                            return new Student(id, l[1], l[2], age);
                        } else {
                            return null;
                        }
                    })
                    .toList();

            System.out.println(students);

            System.out.println("=== removed invalid lines and duplicates:");
            Files.lines(Path.of("students.csv"))
                    .skip(1)
                    .filter(l -> !l.isEmpty())
                    .distinct()
                    .forEach(System.out::println);



        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }


    }



}

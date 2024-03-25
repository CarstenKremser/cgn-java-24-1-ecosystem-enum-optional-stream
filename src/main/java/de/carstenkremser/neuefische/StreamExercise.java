package de.carstenkremser.neuefische;

import java.util.ArrayList;
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





    }

}

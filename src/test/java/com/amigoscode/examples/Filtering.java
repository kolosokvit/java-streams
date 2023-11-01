package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtering {

    @Test
    public void filter() throws Exception {
        List<Car> cars = MockData.getCars();

        List<Car> volvoXcAfter2010 =
                cars.stream()
                        .filter(car -> car.getMake().equals("Volvo"))
                        .filter(car -> car.getModel().contains("XC"))
                        .filter(car -> car.getYear() > 2010).toList();

        volvoXcAfter2010.forEach(System.out :: println);
    }

    @Test
    public void dropWhile() throws Exception {
        //using filter
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();

        //using dropWhile
        //Returns, if this stream is ordered, a stream consisting of the remaining elements of this stream
        //after dropping the longest prefix of elements that match the given predicate.
        System.out.println("using dropWhile");
        Stream.of(2, 4, 6, 8, 9, 10, 12).dropWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
    }

    @Test
    public void takeWhile() throws Exception {
        // using filter
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();

        //using takeWhile
        //Returns, if this stream is ordered, a stream consisting of the longest prefix of elements
        //taken from this stream that match the given predicate.
        System.out.println("using take while");
        Stream.of(2, 4, 6, 8, 9, 10, 12).takeWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
    }

    @Test
    public void findFirst() throws Exception {
        //This is a short-circuiting terminal operation.
        //Returns an Optional describing the first element of this stream,
        //or an empty Optional if the stream is empty.
        //If the stream has no encounter order, then any element may be returned.

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = Arrays.stream(numbers).filter(n -> n > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(result);
    }

    @Test
    public void findAny() throws Exception {
        //This is a short-circuiting terminal operation.
        //Returns an Optional describing some element of the stream,
        //or an empty Optional if the stream is empty.
        //The behavior of this operation is explicitly nondeterministic;
        //it is free to select any element in the stream

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
        int result = Arrays.stream(numbers).filter(n -> n > 5)
                .findAny()
                .orElse(-1);
        System.out.println(result);
    }

    @Test
    public void allMatch() throws Exception {
        //This is a short-circuiting terminal operation.
        //Returns whether all elements of this stream match the provided predicate.
        //May not evaluate the predicate on all elements if not necessary for determining the result.
        //If the stream is empty then true is returned and the predicate is not evaluated.

        int[] even = {2, 4, 6, 8, 10};
        System.out.println(Arrays.stream(even).allMatch(i -> i % 2 == 0));
    }

    @Test
    public void anyMatch() throws Exception {
        //This is a short-circuiting terminal operation.
        //Returns whether any elements of this stream match the provided predicate.
        //May not evaluate the predicate on all elements if not necessary for determining the result.
        //If the stream is empty then false is returned and the predicate is not evaluated.

        int[] evenAndOneOdd = {2, 4, 6, 8, 10, 11};
        System.out.println(Arrays.stream(evenAndOneOdd).allMatch(i -> i % 2 == 0));
    }

}




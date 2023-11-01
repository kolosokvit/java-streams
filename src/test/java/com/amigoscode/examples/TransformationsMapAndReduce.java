package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();
        List<PersonDTO> personDTOS = people.stream()
                .map(person -> {
                    return new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
                })
                .toList();
        personDTOS.forEach(System.out :: println);
    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
        OptionalDouble averagePrice = cars.stream()
                .mapToDouble(Car::getPrice)
                .average();
        System.out.println(averagePrice);
    }

    @Test
    public void reduce() {
        //Performs a reduction on the elements of this stream, using the provided identity value
        // and an associative accumulation function, and returns the reduced value.
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};


        int sum = Arrays.stream(integers).reduce(0, (subtotal, next) -> subtotal + next);
        System.out.println(sum);
    }
}


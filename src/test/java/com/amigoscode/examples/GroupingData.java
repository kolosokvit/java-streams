package com.amigoscode.examples;


import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GroupingData {

    @Test
    public void simpleGrouping() throws Exception {
        //grouping cars by year
        Map<Integer, List<Car>> carsByYear = MockData.getCars()
                .stream()
                .collect(Collectors.groupingBy(Car::getYear));
        carsByYear.forEach((year, cars) -> {
            System.out.println("Year " + year);
            cars.forEach(System.out::println);
            System.out.println("---------------------");
        });
    }

    @Test
    public void groupingAndCounting() throws Exception {
        List<String> names = List.of(
                "John",
                "John",
                "Mariam",
                "Alex",
                "Mohammado",
                "Mohammado",
                "Vincent",
                "Alex",
                "Alex"
        );

        //grouping and counting names
        Map<String, Long> map = names.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting())
                );
        System.out.println(map);

        //grouping and counting colors
        Map<String, Long> colors = MockData.getCars()
                .stream()
                .collect(Collectors.groupingBy(Car::getColor,
                        Collectors.counting()));
        System.out.println(colors);
    }
}
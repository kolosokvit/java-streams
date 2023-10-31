package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkingWithStreams {

    @Test
    void streams() {
        List<String> names = List.of("Amigoscode", "Alex", "Zara");
        List<String> list = names.stream()           //build operation
                .limit(2)                     //intermediate operation
                .toList();       //terminal operation
    }
}

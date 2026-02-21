package dev.lpa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UtilitiesTestParameterized {

    private static Utilities util;


    @BeforeAll
    public static void setup() {
        util = new Utilities();
    }



//    @org.junit.jupiter.api.Test
    @ParameterizedTest
    @MethodSource("testConditions")
     void removePairs(String input, String output){
        assertEquals(output,util.removePairs(input));
    }

    static Stream<Arguments> testConditions() {
        return Stream.of(
                Arguments.of("ABCDEFF","ABCDEF"),
                Arguments.of("AB88EFFG","AB8EFG"),
                Arguments.of("112233445566","123456"),
                Arguments.of("A","A")
        );
    }
}

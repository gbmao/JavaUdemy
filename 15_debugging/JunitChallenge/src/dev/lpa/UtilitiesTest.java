package dev.lpa;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    private static Utilities util;

    @org.junit.jupiter.api.BeforeAll
    public static void setup(){
        util = new Utilities();
    }



    @org.junit.jupiter.api.Test
    void everyNthChar() throws Exception {
//        Utilities util = new Utilities();
        char[] test = {'h', 'e', 'l', 'l', 'o'};
        char[] expected = {'e','l'};
//        assertArrayEquals( expected, util.everyNthChar(test, 2));

        char[] output = util.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 2);
        assertArrayEquals(new char[] {'e','l'}, output);

        char[] output2 = util.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 8);
        assertArrayEquals(new char[]{'h', 'e', 'l', 'l', 'o'}, output2);
    }

    @org.junit.jupiter.api.Test
    void removePairs() {

//        Utilities util = new Utilities();

        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF",util.removePairs("ABCCABDEEF"));
        assertEquals("A", util.removePairs("A"));
        assertNull(null, util.removePairs(null));

//        System.out.println(util.removePairs("AABAASD"));
    }

    @org.junit.jupiter.api.Test
    void converter() {
//        Utilities util = new Utilities();
        assertEquals(300,util.converter(10,5));

    }

    @org.junit.jupiter.api.Test
    void converter_arithmeticException(){
//        Utilities util = new Utilities();
        ArithmeticException exception = assertThrows(
                ArithmeticException.class, () -> util.converter(10,0)
        );

        assertEquals("/ by zero", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
//        Utilities util = new Utilities();

        assertEquals("AB",util.nullIfOddLength("AB"));
        assertNull(util.nullIfOddLength("ABC"));
    }
}
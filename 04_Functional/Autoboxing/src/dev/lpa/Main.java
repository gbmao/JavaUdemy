package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Integer boxedInt = Integer.valueOf(15); //preferred but unnecessary
        Integer deprecatedBoxing = new Integer(15); // deprecated since jdk 9
        int unboxedInt = boxedInt.intValue(); //unnecessary

        //Automatic
        Integer autoBoxed = 15;
        int autoUnboxed = autoBoxed;
        System.out.println(autoBoxed.getClass().getName());
//        System.out.println(autoUnboxed.getClass().getName());


        Double resultBoxed = getLiteralDoublePrimitive();
        double resultUnboxed = getDoubleObject();

        Integer[] wrapperArray = new Integer[5];
//        int[] wrapperArray = new int[5];
        wrapperArray[0] = 50;
        System.out.println(Arrays.toString(wrapperArray));


        Character[] characterArray = {'a', 'b', 'c', 'd'};
        System.out.println(Arrays.toString(characterArray));

        var  ourList = getList(1, 2, 3, 4, 5);
        System.out.println(ourList);

    }

    private static ArrayList<Integer> getList(int... varargs) {

        ArrayList<Integer> aList = new ArrayList<>();
        for (int i : varargs) {
            aList.add(i);
        }
        return aList;
    }

    private static int returnInt(Integer i) {
        return i;
    }

    private static Integer returnAnInteger(int i) {
        return i;
    }

    private static Double getDoubleObject() {
        return 100.00;
    }

    private static double getLiteralDoublePrimitive() {

        return 100.0;
    }
}

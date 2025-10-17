package com.challenge;

import com.challenge.model.LPAStudent;
import com.challenge.model.Student;
import com.challenge.util.QueryList;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        QueryList<LPAStudent> queryList = new QueryList<>();
        for (int i = 0; i < 5; i++) {
            queryList.add(new LPAStudent());
        }
//        System.out.println(Arrays.deepToString(queryList));
        System.out.println("Ordered");
//        queryList.sort(Comparator.reverseOrder());
        printList(queryList);

    }
    public static void printList(List<?> students) {

        for (var student : students) {
            System.out.println(student);
        }
    }
}



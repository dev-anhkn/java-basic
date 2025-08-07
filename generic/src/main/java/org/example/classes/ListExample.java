package org.example.classes;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        System.out.println(strings);

        List<Integer> integers = new ArrayList<>();
        integers.add(100);
        System.out.println(integers);
    }
}

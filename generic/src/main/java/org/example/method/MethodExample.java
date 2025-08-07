package org.example.method;

public class MethodExample {
    public static void main(String[] args) {

        GenericMethod genericMethod = new GenericMethod();

        Integer[] integers = {1, 2, 3, 4};
        genericMethod.printArray(integers);

        String[] strings = {"A", "B", "C", "D"};
        genericMethod.printArray(strings);

    }
}

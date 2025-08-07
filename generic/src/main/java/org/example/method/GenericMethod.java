package org.example.method;

public class GenericMethod {

    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public <T> T getValue(T input) {
        return input;
    }

}

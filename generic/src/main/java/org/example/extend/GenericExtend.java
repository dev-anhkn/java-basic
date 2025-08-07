package org.example.extend;

public class GenericExtend {

    public <T extends Number> void display(T value) {
        System.out.println(value);
    }

}

package org.example.service;

public class ContainerExample {
    public static void main(String[] args) {

        Container<String> stringContainer = new ContainerImpl<>();
        stringContainer.add("Hello");
        String string = stringContainer.get();
        System.out.println(string);

        Container<Integer> integerContainer = new ContainerImpl<>();
        integerContainer.add(100);
        System.out.println(integerContainer.get());
    }
}

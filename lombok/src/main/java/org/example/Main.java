package org.example;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Nga");
        person.setAge(18);
        person.getName();
        person.getAge();

        Person nga = new Person("Nga", 18);
    }
}
package org.example.method;

public class MethodReturnExample {
    public static void main(String[] args) {

        GenericMethod genericMethod = new GenericMethod();

        Integer integer = genericMethod.getValue(100);
        System.out.println(integer);

        String string = genericMethod.getValue("Generic");
        System.out.println(string);
    }
}

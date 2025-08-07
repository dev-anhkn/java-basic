package org.example.wildcard;


import org.example.classes.GenericClass;

public class WildcardExample {
    public static void main(String[] args) {
        GenericClass<?> box = new GenericClass<>(20);
        System.out.println(box.getValue());
        //box.setValue(10); // Lỗi

        GenericClass<? extends Number> boxNumber = new GenericClass<>(30);
        System.out.println(boxNumber.getValue());
        //boxNumber.setValue(10); // Lỗi

        GenericClass<? super Integer> boxInt = new GenericClass<>(40);
        System.out.println(boxInt.getValue());
        boxInt.setValue(10);// OK

    }
}

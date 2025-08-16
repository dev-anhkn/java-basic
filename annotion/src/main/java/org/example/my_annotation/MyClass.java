package org.example.my_annotation;

public class MyClass {

    @MyAnnotation(value = "Hello", version = 2)
    public void myMethod() {
        System.out.println("Using custom annotation!");
    }

    @MyAnnotation("World")//Không cần chỉ định version vì đã có giá trị mặc định
    public void anotherMethod() {
        System.out.println("Using custom annotation with default version!");
    }

}

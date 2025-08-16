package org.example.my_annotation;

import java.lang.reflect.*;

public class AnnotationReader {

    public static void main(String[] args) throws Exception {
        Method method = MyClass.class.getMethod("myMethod"); // myMethod của lớp MyClass
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        if (annotation != null) {
            System.out.println("Value: " + annotation.value());
            System.out.println("Version: " + annotation.version());
        }
    }

}

package org.example.my_annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {

    String value(); // Thuộc tính bắt buộc

    int version() default 1; // Thuộc tính có giá trị mặc định
}

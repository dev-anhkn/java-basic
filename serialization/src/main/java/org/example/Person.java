package org.example;

import java.io.Serializable;

// Lớp Person thực thi Serializable
class Person implements Serializable {

    // Khai báo serialVersionUID
    private static final long serialVersionUID = 2L;

    private String name;

    private int age;

    private transient String password; // Trường này sẽ không được serializable

    public Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person { " +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                " }";
    }
}


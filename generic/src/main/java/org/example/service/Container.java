package org.example.service;

interface Container<T> {

    void add(T item);

    T get();
}

package org.example;

import io.reactivex.rxjava3.core.Observable;
import org.example.rxjava.Chap1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        new Chap1().createObservable();
    }
}
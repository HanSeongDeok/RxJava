package org.example.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class Chap1 {
    public void createObservable(){
        Observable.create(s -> {
            s.onNext("Hello World - ");
            s.onComplete();
        }).subscribe(System.out::println);
    }
}

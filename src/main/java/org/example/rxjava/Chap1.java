package org.example.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import org.example.rxjava.dump.Cache;

import java.util.Optional;

public class Chap1 {
    public void createObservable(){
        /**
         * Observable 동기 방식의 예시
         */
        Observable.create(s -> {
            s.onNext(printHelloWorld());
            s.onNext(printHan());
            s.onComplete();
        }).subscribe(System.out::println);

        Cache cache = new Cache();
        String SOME_KEY = "";
        Observable.create(s -> {
            s.onNext(cache.get(SOME_KEY));
        }).subscribe(System.out::println);

        /**
         * Observable 비동기 방식의 예시
         */
        Observable.create(s -> {
            Object fromCache = cache.getFromCache(SOME_KEY);
            // 동기 방식
            if (Optional.ofNullable(fromCache).isPresent()){
                s.onNext(fromCache);
                s.onComplete();
            }
            // 비동기 방식
            else {
                new Thread(() -> {
                    s.onNext(new Cache());
                }).start();
            }
        }).subscribe(v -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(v);
        });
    }

    public String printHelloWorld(){
        System.out.println(Thread.currentThread().getName());
        return "Hello World - ";
    }

    public String printHan(){
        System.out.println(Thread.currentThread().getName());
        return "Han";
    }
}

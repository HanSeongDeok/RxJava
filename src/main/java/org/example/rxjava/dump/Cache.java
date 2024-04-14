package org.example.rxjava.dump;

public class Cache {
    public Object get(String key){
        return this;
    }

    public Object getFromCache(String key){
        if (key.equals("x")){
            return this;
        } else {
            return null;
        }
    }

    public String toString(){
        return "Cache";
    }
}

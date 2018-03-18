package ru.tinkoff.fintech2.utils;

public class Utils {

    public String getPath(String fileName){
        return getClass().getClassLoader().getResource(fileName).getPath();
    }

}

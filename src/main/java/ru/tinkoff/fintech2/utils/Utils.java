package ru.tinkoff.fintech2.utils;

import java.io.InputStream;

public class Utils {

    public String getPath(String fileName){
        return getClass().getClassLoader().getResource(fileName).getPath();
    }

    public InputStream getIObyFilename(String fileName) {
        return getClass().getClassLoader().getResourceAsStream(fileName);
    }
}

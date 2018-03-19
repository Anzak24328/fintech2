package ru.tinkoff.fintech2.processing;

import ru.tinkoff.fintech2.utils.Random;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            new CreateDocument().create(System.getProperty("user.dir")+ File.separator+ Random.getInt(100,999)+".xls");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

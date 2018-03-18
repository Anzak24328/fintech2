package ru.tinkoff.fintech2.processing;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            new CreateDocument().create(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()+ File.separator+"result.XLS");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

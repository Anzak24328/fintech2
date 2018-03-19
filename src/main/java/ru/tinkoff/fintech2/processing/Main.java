package ru.tinkoff.fintech2.processing;

import com.itextpdf.text.DocumentException;
import ru.tinkoff.fintech2.utils.Random;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            new CreateDocument().createDocs(System.getProperty("user.dir")+ File.separator);
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }


    }


}

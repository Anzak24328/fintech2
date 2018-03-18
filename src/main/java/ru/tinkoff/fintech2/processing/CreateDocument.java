package ru.tinkoff.fintech2.processing;

import ru.tinkoff.fintech2.jaxb.*;
import ru.tinkoff.fintech2.pojo.Person;
import ru.tinkoff.fintech2.utils.Random;

import java.time.LocalDate;

public class CreateDocument {

    public void create() {
        System.out.println(getRandomPerson());
    }


    private String getPath(String fileName){
       return getClass().getClassLoader().getResource(fileName).getPath();
    }




}

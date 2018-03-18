package ru.tinkoff.fintech2.utils;

import ru.tinkoff.fintech2.jaxb.enums.Gender;

import java.time.LocalDate;
import java.util.ArrayList;

public class Random {

    public static int getInt(int min, int max) {
        max -=min;
        return (int) (Math.random() * ++max) + min;
    }

    public static Gender getGender(){
        if (getInt(0,100) < 50) return Gender.MAN;
        else return Gender.WOMEN;
    }

    public static  <T> T getRowFromList(ArrayList<T> list) {
        return list.get(getInt(0, list.size()-1));
    }

    public static LocalDate getBirthDate(){
        int year = getInt(1900, 2017);
        int day = getInt(1, 365);
        LocalDate birthDate = LocalDate.of(year, 1, 1);
        if (birthDate.isLeapYear()) day = getInt(1, 366);
        return LocalDate.ofYearDay(year, day);
    }
}

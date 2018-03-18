package ru.tinkoff.fintech2.pojo;

import ru.tinkoff.fintech2.jaxb.*;
import ru.tinkoff.fintech2.processing.ListOperations;
import ru.tinkoff.fintech2.processing.XmlParser;
import ru.tinkoff.fintech2.utils.Random;

import java.time.LocalDate;
import java.util.List;

public class PersonImpl {

    private Person getRandomPerson(){
        Names names = new XmlParser().getList(getPath("namelist.xml"), Names.class);
        Cities cities = new XmlParser().getList(getPath("cities.xml"), Cities.class);
        Streets streets = new XmlParser().getList(getPath("streets.xml"), Streets.class);
        Gender gender = Random.getGender();
        LocalDate birthDate = Random.getBirthDate();
        String genStr = "М";
        if (gender == Gender.WOMEN) genStr = "Ж";
        City city = Random.getRowFromList(cities.getCities());
        return new Person(
                Random.getRowFromList(new ListOperations().getNameSubList(gender, NameType.FIRST, names)),
                Random.getRowFromList(new ListOperations().getNameSubList(gender, NameType.LAST, names)),
                Random.getRowFromList(new ListOperations().getNameSubList(gender, NameType.MIDDLE, names)),
                LocalDate.now().getYear()-birthDate.getYear(),
                genStr,
                birthDate,
                Random.getRowFromList(cities.getCities()).getCity(),
                city.getIndex() +String.format("%06d",  Random.getInt(0,999)),
                city.getRegion(),
                city.getCity(),
                Random.getRowFromList(streets.getStreets()),
                Random.getInt(1,100),
                Random.getInt(1,1000));
    }

    public List<Person> getListOfRandomPerson(){
        
    }
}

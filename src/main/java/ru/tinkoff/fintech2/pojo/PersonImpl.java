package ru.tinkoff.fintech2.pojo;

import ru.tinkoff.fintech2.jaxb.Cities;
import ru.tinkoff.fintech2.jaxb.City;
import ru.tinkoff.fintech2.jaxb.Names;
import ru.tinkoff.fintech2.jaxb.Streets;
import ru.tinkoff.fintech2.jaxb.enums.Gender;
import ru.tinkoff.fintech2.jaxb.enums.NameType;
import ru.tinkoff.fintech2.utils.ListOperations;
import ru.tinkoff.fintech2.utils.Random;
import ru.tinkoff.fintech2.utils.Utils;
import ru.tinkoff.fintech2.utils.XmlParser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonImpl {

    private Person getRandomPerson(){
        Names names = new XmlParser().getList(new Utils().getIObyFilename("namelist.xml"), Names.class);
        Cities cities = new XmlParser().getList(new Utils().getIObyFilename("cities.xml"), Cities.class);
        Streets streets = new XmlParser().getList(new Utils().getIObyFilename("streets.xml"), Streets.class);
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
                city.getIndex() +String.format("%03d",  Random.getInt(0,999)),
                city.getRegion(),
                city.getCity(),
                Random.getRowFromList(streets.getStreets()),
                Random.getInt(1,100),
                Random.getInt(1,150));
    }

    public List<Person> getListOfRandomPerson(){
        ArrayList<Person> list = new ArrayList<>();
          for (int i = 0; i< Random.getInt(1,30); i++){
            list.add(getRandomPerson());
        }
        return list;
    }
}

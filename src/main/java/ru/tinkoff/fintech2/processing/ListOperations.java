package ru.tinkoff.fintech2.processing;

import ru.tinkoff.fintech2.jaxb.Gender;
import ru.tinkoff.fintech2.jaxb.Name;
import ru.tinkoff.fintech2.jaxb.NameType;
import ru.tinkoff.fintech2.jaxb.Names;

import java.util.ArrayList;

public class ListOperations {

    public ArrayList<String> getNameSubList(Gender gender, NameType nameType, Names names) {
        ArrayList list = new ArrayList();
        for (Name name: names.getList()){
            if (name.getGender() == gender & name.getType() == nameType) list.add(name.getValue());

        }
        return list;
    }

}

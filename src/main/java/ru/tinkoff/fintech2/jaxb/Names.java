package ru.tinkoff.fintech2.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "namelist")
public class Names {

    private ArrayList<Name> list;

    public Names(ArrayList<Name> list) {
        this.list = list;
    }

    public Names() {
    }

    @XmlElement(name = "name")
    public ArrayList<Name> getList() {return list;}
    public void setList(ArrayList<Name> list) {this.list = list;}

    @Override
    public String toString() {
        return "Names{" +
                "list=" + list +
                '}';
    }
}

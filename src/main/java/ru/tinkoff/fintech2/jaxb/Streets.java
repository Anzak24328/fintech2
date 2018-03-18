package ru.tinkoff.fintech2.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "streets")
public class Streets {

    private ArrayList<String> streets;

    public Streets(ArrayList<String> streets) {
        this.streets = streets;
    }

    public Streets() {
    }

    @XmlElement(name = "street")
    public ArrayList<String> getStreets() {return streets;}
    public void setStreets(ArrayList<String> streets) {this.streets = streets;}

    @Override
    public String toString() {
        return "Streets{" +
                "streets=" + streets +
                '}';
    }
}

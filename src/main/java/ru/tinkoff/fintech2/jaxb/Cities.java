package ru.tinkoff.fintech2.jaxb;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "cities")
public class Cities {

    private ArrayList<City> cities;

    public Cities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public Cities() {
    }

    @XmlElement(name = "city")
    public ArrayList<City> getCities() {return cities;}
    public void setCities(ArrayList<City> cities) {this.cities = cities;}

    @Override
    public String toString() {
        return "Cities{" +
                "cities=" + cities +
                '}';
    }
}

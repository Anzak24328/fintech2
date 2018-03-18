package ru.tinkoff.fintech2.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "city")
public class City {

    private int index;
    private String region;
    private String city;

    public City(int index, String region, String city) {
        this.index = index;
        this.region = region;
        this.city = city;
    }

    public City() {
    }

    @XmlAttribute(name = "index")
    public int getIndex() {return index;}
    public void setIndex(int index) {this.index = index;}

    @XmlAttribute(name = "region")
    public String getRegion() {return region;}
    public void setRegion(String region) {this.region = region;}

    @XmlAttribute(name = "city")
    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}

    @Override
    public String toString() {
        return "City{" +
                "index=" + index +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

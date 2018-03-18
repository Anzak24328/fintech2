package ru.tinkoff.fintech2.jaxb;

import ru.tinkoff.fintech2.jaxb.enums.Gender;
import ru.tinkoff.fintech2.jaxb.enums.NameType;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "name")
public class Name {

    private NameType type;
    private Gender gender;
    private String value;

    public Name(NameType type, Gender gender, String value) {
        this.type = type;
        this.gender = gender;
        this.value = value;
    }

    public Name() {
    }

    @XmlAttribute(name = "type")
    public NameType getType() {return type;}
    public void setType(NameType type) {this.type = type;}

    @XmlAttribute(name = "gender")
    public Gender getGender() {return gender;}
    public void setGender(Gender gender) {this.gender = gender;}

    @XmlValue
    public String getValue() {return value;}
    public void setValue(String value) {this.value = value;}

    @Override
    public String toString() {
        return "Name{" +
                "type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

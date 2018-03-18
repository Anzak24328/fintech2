package ru.tinkoff.fintech2.jaxb;

import javax.xml.bind.annotation.XmlEnumValue;

public enum Gender {
    @XmlEnumValue(value = "m")
    MAN,
    @XmlEnumValue(value = "w")
    WOMEN
}

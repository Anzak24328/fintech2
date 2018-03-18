package ru.tinkoff.fintech2.jaxb.enums;

import javax.xml.bind.annotation.XmlEnumValue;

public enum NameType {
    @XmlEnumValue(value = "first")
    FIRST,
    @XmlEnumValue(value = "last")
    LAST,
    @XmlEnumValue(value = "middle")
    MIDDLE
}

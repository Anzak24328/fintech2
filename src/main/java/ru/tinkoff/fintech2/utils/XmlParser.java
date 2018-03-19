package ru.tinkoff.fintech2.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;

public class XmlParser {

    public <T> T getList(InputStream path, Class<T> tClass){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(tClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (T) unmarshaller.unmarshal(path);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }


}

package ru.tinkoff.fintech2.processing;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlParser {

    public <T> T getList(String path, Class<T> tClass){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(tClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }


}

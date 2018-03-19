package ru.tinkoff.fintech2.processing;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import ru.tinkoff.fintech2.pojo.Person;
import ru.tinkoff.fintech2.pojo.PersonImpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CreateDocument {

    public void create(String path) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("fintech2");
        getSheetHead(sheet);
        addRows(sheet);
        workbook.write(new FileOutputStream(path));
        workbook.close();
    }

    private Row getSheetHead(Sheet sheet){
        Row row = sheet.createRow(0);
        String[] head = {"Имя","Фамилия","Отчество","Возраст","Пол","Дата рождения","Место рождения","Индекс","Страна","Регион","Город","Улица","Дом","Квартира"};
        for (int i = 0; i<head.length;i++){
            Cell firstName = row.createCell(i);
            firstName.setCellValue(head[i]);
        }
        return row;
    }

    private Sheet addRows(Sheet sheet) {
        List<Person> persons = new PersonImpl().getListOfRandomPerson();
        for (int f = 1; f < persons.size()+1; f++) {
            int k = f-1;
            Row row = sheet.createRow(f);
            row.createCell(0).setCellValue(persons.get(k).getFirstName());
            row.createCell(1).setCellValue(persons.get(k).getLastName());
            row.createCell(2).setCellValue(persons.get(k).getMiddleName());
            row.createCell(3).setCellValue(persons.get(k).getAge());
            row.createCell(4).setCellValue(persons.get(k).getGender());
            row.createCell(5).setCellValue(persons.get(k).getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            row.createCell(6).setCellValue(persons.get(k).getBirthPlace());
            row.createCell(7).setCellValue(persons.get(k).getIndex());
            row.createCell(8).setCellValue(persons.get(k).getCountry());
            row.createCell(9).setCellValue(persons.get(k).getRegion());
            row.createCell(10).setCellValue(persons.get(k).getCity());
            row.createCell(11).setCellValue(persons.get(k).getStreet());
            row.createCell(12).setCellValue(persons.get(k).getHouse());
            row.createCell(13).setCellValue(persons.get(k).getApartment());
        }
        for (int i = 0; i < 14; i++) sheet.autoSizeColumn(i, true);
        return sheet;
    }

}

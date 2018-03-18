package ru.tinkoff.fintech2.processing;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateDocument {

    public void create(String path) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("fintech2");
        Row head = getSheetHead(sheet);
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


}

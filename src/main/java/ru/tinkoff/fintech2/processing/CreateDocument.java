package ru.tinkoff.fintech2.processing;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import ru.tinkoff.fintech2.pojo.Person;
import ru.tinkoff.fintech2.pojo.PersonImpl;
import ru.tinkoff.fintech2.utils.Random;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CreateDocument {

    private static final String[] HEAD = {"Имя","Фамилия","Отчество","Возраст","Пол","Дата рождения","Место рождения","Индекс","Страна","Регион","Город","Улица","Дом","Квартира"};

    public void createDocs(String path) throws IOException, DocumentException {
        List<Person> persons = new PersonImpl().getListOfRandomPerson();
        createPDFDoc(path+ Random.getInt(100,999)+".pdf", persons);
        createExcelDoc(path+ Random.getInt(100,999)+".xls", persons);
    }

    private void createExcelDoc(String path, List<Person> persons) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("fintech2");
        getSheetHead(sheet);
        addRows(sheet, persons);
        workbook.write(new FileOutputStream(path));
        workbook.close();
    }

    private Row getSheetHead(Sheet sheet){
        Row row = sheet.createRow(0);
        for (int i = 0; i<HEAD.length;i++){
            Cell firstName = row.createCell(i);
            firstName.setCellValue(HEAD[i]);
        }
        return row;
    }

    private Sheet addRows(Sheet sheet, List<Person> persons) {
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

    private void createPDFDoc(String path, List<Person> persons) throws IOException, DocumentException {
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.add(createPdfTable(persons));
        document.close();
    }

    private PdfPTable createPdfTable(List<Person> persons) throws IOException, DocumentException {
        PdfPTable table = new PdfPTable(HEAD.length);
        table.setWidthPercentage(95);
        Font helv = new Font(BaseFont.createFont("C:/Windows/Fonts/arialbd.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
        for (int i = 0; i<HEAD.length;i++){
            PdfPCell cell = new PdfPCell(new Phrase(HEAD[i],helv));
            table.addCell(cell);
        }
        for (Person p :persons) {
            PdfPCell cell = new PdfPCell(new Phrase(p.getFirstName(), helv));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(p.getLastName(), helv));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(p.getMiddleName(), helv));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(String.valueOf(p.getAge()), helv));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(p.getGender(), helv));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(p.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), helv));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(p.getBirthPlace(), helv));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(p.getIndex(), helv));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(p.getCountry(), helv));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(p.getRegion(), helv));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(p.getCity(), helv));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(p.getStreet(), helv));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(String.valueOf(p.getHouse()), helv));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(String.valueOf(p.getApartment()), helv));
            table.addCell(cell);
        }
        return table;
    }




}

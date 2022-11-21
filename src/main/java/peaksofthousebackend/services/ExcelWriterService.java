package peaksofthousebackend.services;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import peaksofthousebackend.models.Student;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExcelWriterService {

    public Workbook getExcelFile(List<Student> studentList) throws IOException {

        try {
            Workbook workbook = new XSSFWorkbook();
            LocalDate date = LocalDate.now();
            String formatDate = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))
            Sheet sheet = workbook.createSheet(formatDate);

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("№");
            header.createCell(1).setCellValue("Имя");
            header.createCell(2).setCellValue("Фамилия");
            header.createCell(3).setCellValue("Номер телефона");
            header.createCell(4).setCellValue("Дата рождения");
            header.createCell(5).setCellValue("Почта");
            header.createCell(6).setCellValue("Область");
            header.createCell(7).setCellValue("Формат");
            header.createCell(8).setCellValue("Доп. номер телефона");
            header.createCell(9).setCellValue("Комментарий");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeight((short) 14);
            headerFont.setColor(IndexedColors.RED.getIndex());

            int rowNum = 1;
            int counter = 1;
            for (Student student : studentList.stream().
                    sorted(Comparator.comparing(Student::getRegisterDate).reversed()).collect(Collectors.toList())) {

                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(counter++);
                row.createCell(1).setCellValue(student.getName());
                row.createCell(2).setCellValue(student.getLastName());
                row.createCell(3).setCellValue(student.getPhoneNumber());
                row.createCell(4).setCellValue(student.getDateOfBirth());
                row.createCell(5).setCellValue(student.getEmail());
                row.createCell(6).setCellValue(student.getBanner().getBanner());
                row.createCell(7).setCellValue(student.getFormat().name());
                row.createCell(8).setCellValue(student.getExtraPhoneNumber());
                row.createCell(8).setCellValue(student.getComment());
            }
            return workbook;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

package com.expManageSys.ems.service;

import com.expManageSys.ems.modal.Expense;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; // Import for XSSFWorkbook
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ReportService {

    public void generateExcelReport(List<Expense> expenses, String filePath) throws IOException {
        // Create a new workbook
        Workbook workbook = new XSSFWorkbook(); // Use XSSFWorkbook for .xlsx format
        Sheet sheet = workbook.createSheet("Expenses");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Description");
        headerRow.createCell(2).setCellValue("Amount");
        headerRow.createCell(3).setCellValue("User  ID");

        // Populate the sheet with expense data
        int rowNum = 1;
        for (Expense expense : expenses) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(expense.getId());
            row.createCell(1).setCellValue(expense.getDescription());
            row.createCell(2).setCellValue(expense.getAmount().doubleValue());
            row.createCell(3).setCellValue(expense.getUser ().getId());
        }

        // Write the output to a file
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        } finally {
            workbook.close(); // Close the workbook to free resources
        }
    }
}
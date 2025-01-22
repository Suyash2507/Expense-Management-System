package com.expManageSys.ems.controller;

import com.expManageSys.ems.modal.Expense;
import com.expManageSys.ems.service.ExpenseService;
import com.expManageSys.ems.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private ReportService reportService;

    @GetMapping("/{userId}")
    public List<Expense> getAllExpenses(@PathVariable Long userId) {
        return expenseService.getAllExpenses(userId);
    }

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.saveExpense(expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }

    @PostMapping("/report")
    public ResponseEntity<String> generateReport(@RequestParam Long userId) {
        List<Expense> expenses = expenseService.getAllExpenses(userId);
        String filePath = "path/to/your/report/Expenses_Report.xlsx"; // Specify your file path
        try {
            reportService.generateExcelReport(expenses, filePath);
            return ResponseEntity.ok("Report generated successfully: " + filePath);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to generate report: " + e.getMessage());
        }
    }
}

package com.project.springbootdemo.serviceimpl;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springbootdemo.model.ExpenseTrackerModel;
import com.project.springbootdemo.repository.ExpenseTrackerRepository;
import com.project.springbootdemo.service.ExpenseTrackerService;

@Service
public class ExpenseTrackerServiceImpl implements ExpenseTrackerService {

	@Autowired
	ExpenseTrackerRepository expenseTrackerRepository;

	@Override
	public ExpenseTrackerModel addExpense(ExpenseTrackerModel expense) {
		String response = "";
		try {
			expenseTrackerRepository.save(expense);
			response = "Data Saved successfully + " + expense.toString();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception at generateExcelReport " + e);
			response = "Data Failed to save  " + e;

		}

		return expense;
	}

	@Override
	public ByteArrayOutputStream generateExcelReport() {

		try {

			List<ExpenseTrackerModel> getAllExpData = expenseTrackerRepository.findAll();
			
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("Expenses");

			// Create header row
			org.apache.poi.ss.usermodel.Row headerRow = sheet.createRow(0);
			String[] headers = { "Exp ID", "Exp Date", "Exp Description", "Exp Category", "Exp Amount",
					"Exp Created Date Time" };

			for (int i = 0; i < headers.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(headers[i]);
			}

			// Fill data rows
			int rowNum = 1;
			for (ExpenseTrackerModel expense : getAllExpData) {
			org.apache.poi.ss.usermodel.Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(expense.getExpId());
			row.createCell(1).setCellValue(expense.getExpDateTime().toString());
			row.createCell(2).setCellValue(expense.getExpDescription());
			row.createCell(3).setCellValue(expense.getExpCategory());
			row.createCell(4).setCellValue(expense.getExpAmount());
			row.createCell(5).setCellValue(expense.getExpCreatedDateTime().toString());
			}

			// Write to output stream
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			workbook.write(outputStream);
			workbook.close();

			return outputStream;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception at generateExcelReport " + e);
		}

		return null;
	}

}

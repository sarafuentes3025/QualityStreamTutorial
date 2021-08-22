package com.qualityStream.tutorial;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteExcelFile {

  public void writeCellValue(String filePath, String sheetName, int rowNumber, int cellNumber, String resultText) throws IOException {
    File file = new File(filePath);

    FileInputStream inputStream = new FileInputStream(file);

    XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);

    XSSFSheet newSheet = newWorkBook.getSheet(sheetName);

    XSSFRow row = newSheet.getRow(rowNumber);

    XSSFCell firstCell = row.getCell(cellNumber - 1);

    System.out.println("first cell value is:" + firstCell.getStringCellValue());

    XSSFCell nextCell = row.createCell(cellNumber);
    nextCell.setCellValue(resultText);

    System.out.println("nextCell value:" + nextCell.getStringCellValue());

    inputStream.close();

    FileOutputStream outputStream = new FileOutputStream(file);

    newWorkBook.write(outputStream);

    outputStream.close();

  }
}

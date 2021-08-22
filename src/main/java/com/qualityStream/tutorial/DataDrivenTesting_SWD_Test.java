package com.qualityStream.tutorial;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class DataDrivenTesting_SWD_Test {

  private WebDriver driver;
  private WriteExcelFile writeExcelFile;
  private ReadExcelFile readExcelFile;
  private By searchBoxLocator = By.id("search_query_top");
  private By searchBtnLocator = By.name("submit_search");
  private By resultTextLocator = By.cssSelector("span.heading-counter");

  @BeforeEach
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    driver = new ChromeDriver();
    writeExcelFile = new WriteExcelFile();
    readExcelFile = new ReadExcelFile();

    driver.get("http://automationpractice.com");
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void test() throws InterruptedException, IOException {
    String filePath = "/Users/sarafuentes/Desktop/Test.xlsx";

    String searchText = readExcelFile.getCellValue(filePath, "Sheet1", 0, 0);

    driver.findElement(searchBoxLocator).sendKeys(searchText);
    driver.findElement(searchBtnLocator).click();
    String resultText = driver.findElement(resultTextLocator).getText();

    System.out.println("Page result text:"+resultText);

    readExcelFile.readExcel(filePath,"Sheet1");

    writeExcelFile.writeCellValue(filePath, "Sheet1", 0, 1, resultText);

    readExcelFile.readExcel(filePath, "Sheet1");

  }

}

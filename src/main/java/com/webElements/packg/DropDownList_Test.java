package com.webElements.packg;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DropDownList_Test {

  private WebDriver driver;
  DropDownList_Page ddLPage;

  @BeforeEach
  public void setUp() {
    ddLPage = new DropDownList_Page(driver);
    driver = ddLPage.chromeDriverConnection();
    driver.manage().window().maximize();

  }

  @AfterEach
  public void tearDown() {

  }

  @Test
  public void testing_classic_DDL() {
    ddLPage.visit("http://demo.guru99.com/test/newtours/index.php");
    ddLPage.signIn();
    assertThat(ddLPage.selectDropDownList_Passengers()).isEqualTo("4");
    assertThat(ddLPage.selectDropDownList_DepartingFrom()).isEqualTo("Paris");
  }
}
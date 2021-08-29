package com.webElements.packg;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

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

//  @Test
//  public void testing_classic_DDL() {
//    ddLPage.visit("http://demo.guru99.com/test/newtours/index.php");
//    ddLPage.signIn();
//    assertThat(ddLPage.selectDropDownList_Passengers()).isEqualTo("4");
//    assertThat(ddLPage.selectDropDownList_DepartingFrom()).isEqualTo("Paris");
//    assertThat(ddLPage.selectDropDownList_OnMonth()).isEqualTo("September");
//    assertThat(ddLPage.selectDropDownList_OnDay()).isEqualTo("15");
//    assertThat(ddLPage.selectDropDownList_ArrivingIn()).isEqualTo("San Francisco");
//    assertThat(ddLPage.selectDropDownList_ReturningMonth()).isEqualTo("September");
//    assertThat(ddLPage.selectDropDownList_ReturningDay()).isEqualTo("31");
//  }

  @Test
  public void testing_React_DDL() throws InterruptedException {
    ddLPage.visit("https://react-bootstrap.github.io/components/dropdowns/");
    ddLPage.selectReactDropDownList();
  }
}

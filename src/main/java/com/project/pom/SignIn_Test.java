package com.project.pom;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignIn_Test {

  private static WebDriver driver;
  SignInPage signInPage;

  @BeforeEach
  public void setUp() {
    signInPage = new SignInPage(driver);
    driver = signInPage.chromeDriverConnection();
    signInPage.visit("http://demo.guru99.com/test/newtours/index.php");
  }

  @AfterEach
  public void tearDown() {
//    driver.quit();
  }

  @Test
  public void test() throws InterruptedException {
    signInPage.signIn();
    Thread.sleep(2_000);
    assertTrue(signInPage.isHomePageDisplayed());
  }
}

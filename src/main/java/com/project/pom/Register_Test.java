package com.project.pom;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Register_Test {

  private WebDriver driver;
  RegisterPage registerPage;

  @BeforeEach
  public void setUp() {
    registerPage = new RegisterPage(driver);
    driver = registerPage.chromeDriverConnection();
    registerPage.visit("http://demo.guru99.com/test/newtours/register.php");
  }

  @AfterEach
  public void tearDown() {
    //    driver.quit();
  }

  @Test
  public void test() throws InterruptedException {
    registerPage.registerUser();
    Thread.sleep(2_000);
    assertThat(registerPage.registeredMessage()).isEqualTo("Note: Your user name is qualityAdmin.");
  }
}

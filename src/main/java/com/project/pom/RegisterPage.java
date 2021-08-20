package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends Base {

  By registerLinkLocator = By.linkText("REGISTER");
  By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");

  By userNameLocator = By.id("email");
  By passwordLocator = By.name("password");
  By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");

  By registerBtnLocator = By.name("submit");

  By registeredMessage = By.tagName("font");

  public RegisterPage(WebDriver driver) {
    super(driver);
  }

  public void registerUser() throws InterruptedException {
    click(registerLinkLocator);
    Thread.sleep(2_000);
    if (isDisplayed(registerPageLocator)) {
      type("qualityAdmin", userNameLocator);
      type("pass1", passwordLocator);
      type("pass1", confirmPasswordLocator);
      click(registerBtnLocator);
    } else {
      System.out.println("Register pages was not found");
    }
  }

  public String registeredMessage() {
    List<WebElement> font = findElements(registeredMessage);
    return getText((By) font.get(5));
  }
}
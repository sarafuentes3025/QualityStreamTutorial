package com.webElements.packg;

import com.project.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownList_Page extends Base {

  //  dropDownList classic - Mercury Tours Page http://demo.guru99.com/test/newtours/index.php
  By flightsLinkLocator = By.linkText("Flights");
  By dropDownList_Passengers = By.name("passCount");
  By dropDownList_DepartingFrom = By.name("fromPort");
  By dropDownList_OnMonth = By.name("fromMonth");
  By dropDownList_OnDay = By.name("fromDay");
  By dropDownList_ArrivingIn = By.name("toPort");
  By dropDownList_ReturningMonth = By.name("toMonth");
  By dropDownList_ReturningDay = By.name("toDay");

  By userLocator = By.name("userName");
  By passLocator = By.name("password");
  By signInBtnLocator = By.name("submit");

  //  dropDownList bootstrap and react - https://react-bootstrap.github.io/components/dropdowns/
  By dropDownListBtn = By.id("dropdown-basic");
  By option2 = By.cssSelector("div[aria-labelledby='dropdown-basic']>a[href='#/action-2']");

  public DropDownList_Page(WebDriver driver) {
    super(driver);
  }

  public void signIn() {
    if (isDisplayed(userLocator)) {
      type("qualityAdmin", userLocator);
      type("pass1", passLocator);
      click(signInBtnLocator);
      click(flightsLinkLocator);
    } else {
      System.out.println("username textBox was not present");
    }
  }

  public String selectDropDownList_Passengers() {
    WebElement dropDownList = findElement(dropDownList_Passengers);
    List<WebElement> options = dropDownList.findElements(By.tagName("option"));
    for (WebElement option : options) {
      if (getText(option).equals("4")) {
        click(option);
      }
    }

    String selectedOption = "";
    for (WebElement option : options) {
      if (option.isSelected())
        selectedOption = getText(option);
    }
    return selectedOption;
  }

  public String selectDropDownList_DepartingFrom() {
    Select selectList = new Select(findElement(dropDownList_DepartingFrom));
    selectList.selectByVisibleText("Paris");
    return getText(selectList.getFirstSelectedOption());
  }

  public String selectDropDownList_OnMonth() {
    Select selectList = new Select(findElement(dropDownList_OnMonth));
    selectList.selectByVisibleText("September");
    return getText(selectList.getFirstSelectedOption());
  }

  public String selectDropDownList_OnDay() {
    Select selectList = new Select(findElement(dropDownList_OnDay));
    selectList.selectByVisibleText("15");
    return getText(selectList.getFirstSelectedOption());
  }

  public String selectDropDownList_ArrivingIn() {
    Select selectList = new Select(findElement(dropDownList_ArrivingIn));
    selectList.selectByVisibleText("San Francisco");
    return getText(selectList.getFirstSelectedOption());
  }

  public String selectDropDownList_ReturningMonth() {
    Select selectList = new Select(findElement(dropDownList_ReturningMonth));
    selectList.selectByVisibleText("September");
    return getText(selectList.getFirstSelectedOption());
  }

  public String selectDropDownList_ReturningDay() {
    Select selectList = new Select(findElement(dropDownList_ReturningDay));
    selectList.selectByVisibleText("31");
    return getText(selectList.getFirstSelectedOption());
  }

  public void selectReactDropDownList() throws InterruptedException {
    Thread.sleep(10_000);
    click(dropDownListBtn);
    Thread.sleep(10_000);
    click(option2);
  }
}

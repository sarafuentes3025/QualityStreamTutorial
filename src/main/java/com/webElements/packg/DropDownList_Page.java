package com.webElements.packg;

import com.project.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownList_Page extends Base {

//  dropDownList classic - Mercury Tours Page http://demo.guru99.com/test/newtours/index.php
//  dropDownList bootstrap and react - https://react-bootstrap.github.io/components/dropdowns/

  By flightsLinkLocator = By.linkText("Flights");
  By dropDownList_Passengers = By.name("passCount");
  By dropDownList_DepartingFrom = By.name("fromPort");

  By userLocator = By.name("userName");
  By passLocator = By.name("password");
  By signInBtnLocator = By.name("submit");


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
}

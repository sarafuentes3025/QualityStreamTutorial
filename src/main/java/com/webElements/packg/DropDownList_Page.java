package com.webElements.packg;

import com.project.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownList_Page extends Base {

//  dropDownList classic - Mercury Tours Page http://demo.guru99.com/test/newtours/index.php
//  dropDownList bootstrap and react - https://react-bootstrap.github.io/components/dropdowns/

  By flightsLinkLocator = By.linkText("Flights");
  By dropDownList_Passengers = By.name("passCount");
  By dropDownList_DepartingFrom =  By.name("fromPort");

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
    } else {
      System.out.println("username textBox was not present");
    }
  }

  public String selectDropDownList_Passengers(){
    Select selectList = new Select(findElement(dropDownList_DepartingFrom));
    selectList.selectByVisibleText("Paris");
    return getText(selectList.getFirstSelectedOption());
  }

}

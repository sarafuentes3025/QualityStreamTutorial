import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MercuryTours_AutomatedTest {

  public static WebDriver driver;
  By registerLinkLocator = By.linkText("REGISTER");
  By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
  By userNameLocator = By.id("email");
  By passwordLocator = By.name("password");
  By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
  By registerBtnLocator = By.name("submit");
  By userLocator = By.name("userName");
  By passLocator = By.name("password");
  By signInBtnLocator = By.name("submit");
  By homePageLocator = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3");

  @BeforeAll
  static void setUp() {
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @AfterAll
  static void tearDown() {
//    driver.quit();
  }

  @Test
  public void registerUser() {
    driver.get("http://demo.guru99.com/test/newtours/register.php");
    driver.findElement(registerLinkLocator).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    if (driver.findElement(registerPageLocator).isDisplayed()) {
      driver.findElement(userNameLocator).sendKeys("qualityAdmin");
      driver.findElement(passwordLocator).sendKeys("pass1");
      driver.findElement(confirmPasswordLocator).sendKeys("pass1");

      driver.findElement(registerBtnLocator).click();
    } else {
      System.out.println("Register pages was not found");
    }

    List<WebElement> fonts = driver.findElements(By.tagName("font"));

    assertEquals("Note: Your user name is qualityAdmin.", fonts.get(5).getText());
  }

  @Test
  public void signIn() {
    driver.get("http://demo.guru99.com/test/newtours/index.php");
    if (driver.findElement(userLocator).isDisplayed()) {
      driver.findElement(userLocator).sendKeys("qualityAdmin");
      driver.findElement(passLocator).sendKeys("pass1");
      driver.findElement(signInBtnLocator).click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      assertTrue(driver.findElement(homePageLocator).isDisplayed());
    } else {
      System.out.println("username texbox was not present");
    }
  }
}

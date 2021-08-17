import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MercuryTours_AutomatedTest {

  public static WebDriver driver;
  By registerLinkLocator = By.linkText("REGISTER");
  By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
  By userNameLocator = By.id("email");
  By passwordLocator = By.name("password");
  By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
  By registerBtnLocator = By.name("submit");

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
  public void registerUser() throws InterruptedException {
    driver.get("http://demo.guru99.com/test/newtours/register.php");
    driver.findElement(registerLinkLocator).click();
    Thread.sleep((2_000));
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
}

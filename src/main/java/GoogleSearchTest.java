import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchTest {

  private static WebDriver driver;
  By videoLinkLocator = By.cssSelector("a[href='https://www.youtube.com/watch?v=R_hh3jAqn8M']");

  @BeforeAll
  static void setUp() {
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @Test
  public void testGooglePage() {
    driver.get("https://www.google.com/");
    WebElement searchBox = driver.findElement(By.name("q"));

    searchBox.clear();

    searchBox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software");

    searchBox.submit();

//  Implicit Wait
//    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//    Explicit Wait
//    WebDriverWait eWait = new WebDriverWait(driver, 10);
//    eWait.until(ExpectedConditions.titleContains("quality-stream"));
//    assertThat(driver.getTitle()).contains("quality-stream Introducción a la Automatización de Pruebas de Software - Buscar con Google");

//    FluentWait
    Wait<WebDriver> fWait = new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(10))
        .pollingEvery(Duration.ofSeconds(2))
        .ignoring(NoSuchFieldException.class);

    WebElement video = fWait.until(webDriver -> driver.findElement(videoLinkLocator));
    assertTrue(video.isDisplayed());
  }

  @AfterAll
  static void tearDown() {
    driver.quit();
  }
}

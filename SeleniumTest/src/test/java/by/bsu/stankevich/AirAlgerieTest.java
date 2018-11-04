package by.bsu.stankevich;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AirAlgerieTest {
    private final static String URL = "https://airalgerie.dz";

    private final static String CHROMEDRIVER_PATH = "D:/others/chromedriver.exe";

    private final static String SELECT_ID = "JS_countryList";

    private final static String CITY_NAME = "New York";

    private final static String EN_LANGUAGE = "ENGLISH";

    private final static String LANGUAGE_BUTTON_ID = "en";

    private WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void testLanguageSwitch) {
        WebElement element = driver.findElement(By.id(SELECT_ID));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(CITY_NAME);
        WebElement languageButton = driver.findElement(By.id(LANGUAGE_BUTTON_ID));
        String lang = languageButton.getAttribute("innerText");
        Assert.assertEquals(EN_LANGUAGE, lang);
        driver.quit();
    }
}

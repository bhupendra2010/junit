package actionclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;


public class KeysDemo {
   private WebDriver driver;
   private String baseurl;

    @Before
    public void srtup() throws InterruptedException {
        driver = new ChromeDriver();
        baseurl = "https://learn.letskodeit.com/p/practice";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
        @Test
        public void TestKeys () throws InterruptedException {
            driver.get(baseurl);
            Thread.sleep(2000);
            Actions action = new Actions(driver);
            action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
            Thread.sleep(3000);
        }

        @After
        public void teardown () throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }
    }

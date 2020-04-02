package actionclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseHooverAction {
    private WebDriver driver;
    private String baseurl;
    JavascriptExecutor jse;

    @Before
    public void srtup() {
        driver=new ChromeDriver();
        baseurl="https://learn.letskodeit.com/p/practice";
        jse=(JavascriptExecutor)driver;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    public void TestMouse() throws InterruptedException {
        driver.get(baseurl);
        jse.executeScript("window.scrollBy(0,800)");
        Thread.sleep(2000);

        WebElement mainelement=driver.findElement(By.id("mousehover"));

        Actions action=new Actions(driver);
        action.moveToElement(mainelement).perform();
        Thread.sleep(2000);

       // WebElement subelement=driver.findElement(By.cssSelector("div a[href='#top']"));
       // action.moveToElement(subelement).click().perform();

        WebElement secondelement=driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Reload']"));
        action.moveToElement(secondelement).click().perform();
    }
   // @After
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
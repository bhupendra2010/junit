package Switchwindow;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SwitchFrame {

    private WebDriver driver;
    private String baseurl;

    @Before
    public void setup(){
        driver=new ChromeDriver();
        baseurl="https://learn.letskodeit.com/p/practice";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseurl);

    }

    @Test
    public void Test() throws InterruptedException {
        Thread.sleep(2000);
        //driver.switchTo().frame("courses-iframe");
        driver.switchTo().frame(0);
        WebElement searchbox=driver.findElement(By.id("search-courses"));
        searchbox.sendKeys("python");

        driver.switchTo().defaultContent();
        Thread.sleep(6000);
        driver.findElement(By.id("name")).sendKeys("Test Successful");
    }
    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}



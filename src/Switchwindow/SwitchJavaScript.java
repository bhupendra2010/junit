package Switchwindow;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SwitchJavaScript {
    private WebDriver driver;
    private String baseurl;

    @Before
    public void setup(){
        driver=new ChromeDriver();
        baseurl ="https://learn.letskodeit.com/p/practice";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseurl);
    }
    @Test
    public  void  Test1() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("name")).sendKeys("bhupendra");
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    @Test
    public void Test2() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("name")).sendKeys("bhupendra");
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();
        alert.accept();

    }
}

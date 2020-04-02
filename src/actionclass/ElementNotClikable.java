package actionclass;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ElementNotClikable {
    private WebDriver driver;
    private String baseurl;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        baseurl = "https://freecrm.com/index.html";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseurl);
    }
    @Test
            public void Test(){
        driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("Bhupendra");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Bhupen");

       // WebElement loginbutton = driver.findElement(By.cssSelector("div[class='ui fluid large blue submit button']"));
        //loginbutton.click();

        WebDriverWait wait=new WebDriverWait(driver,3);
        WebElement loginbutton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='ui fluid large blue submit button']")));


    }
}

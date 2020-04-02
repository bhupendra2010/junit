import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SwitchWindow {
    private WebDriver driver;
    private String baseurl;
    @Before
    public void setup() {
         driver=new ChromeDriver();
         baseurl="https://www.currys.co.uk/gbuk/index.html";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseurl);

    }

    @Test

    public void Test(){
        WebElement openwindow= driver.findElement(By.id("openwindow"));
        openwindow.click();

    }
}
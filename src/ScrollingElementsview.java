import com.sun.prism.j2d.J2DPipeline;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ScrollingElementsview {
    private WebDriver driver;
    private JavascriptExecutor js;

    @Before
    public void setup(){
        driver=new ChromeDriver();
        js=(JavascriptExecutor)driver;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void testjavascript() throws InterruptedException {
        js.executeScript("window.location='https://www.currys.co.uk/gbuk/index.html'");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,1900)");
        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,-1900)");
        Thread.sleep(2000);

       // WebElement element=driver.findElement(By.cssSelector("a[title='Team Knowhow']"));
        //js.executeScript("argument[0].scrollIntoView(true);",element);
       // Thread.sleep(2000);
    }
    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


        }
import com.sun.deploy.cache.BaseLocalApplicationProperties;
import org.junit.After;
import org.junit.Before;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Demo {
    static WebDriver driver;


    @Before
    public void openBrowser(){
         driver=new ChromeDriver();
         driver.get("https://www.currys.co.uk/gbuk/index.html");


         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         driver.manage().window().maximize();

    }


    @Test
    public void Testmehods() throws InterruptedException {

        driver.findElement(By.cssSelector("#search")).sendKeys("ipads");
        driver.findElement(By.cssSelector("#search")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        List<WebElement> productWebElements = driver.findElements(By.cssSelector("button[class='TT--CTA-in-PLP']"));
        if (productWebElements.size() == 0) {
        }
        Random random = new Random();
        int randomNumber = random.nextInt(productWebElements.size()-1);
        WebElement selectedElements=productWebElements.get(randomNumber);
        String selectedproductname =selectedElements.getText();
        selectedElements.click();

        addtobasket();
        basket();
        checkout();

    }


        public void addtobasket() throws InterruptedException {
        String parentHandle=driver.getWindowHandle();
        WebElement openwindow = driver.findElement(By.cssSelector("button[class='TT--CTA-in-PLP']"));
        openwindow.click();

            Set<String>handles= driver.getWindowHandles();
            for (String handle: handles){
                if(!handle.equals(parentHandle)){
                    driver.switchTo().window(handle);
                    Thread.sleep(2000);
                    WebElement addproduct = driver.findElement(By.cssSelector("div.TT--Credit-Fixed:nth-child(12) div.product-page.sticky-container:nth-child(4) section:nth-child(2) div.desktop:nth-child(3) div.channels.space-b:nth-child(4) div.space-b.center:nth-child(1) > button.Button__StyledButton-gFCKw.kFWjUG"));
                    addproduct.click();
                    driver.close();
                    break;


                }
                driver.switchTo().window(parentHandle);
                driver.findElement(By.cssSelector("#search")).sendKeys("iphone");
                driver.findElement(By.cssSelector("#search")).sendKeys(Keys.ENTER);
                driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

            }



        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            }
    public void basket(){
        driver.findElement(By.cssSelector("span[class='dc-icon dc-icon-basket dc-header-item__icon']")).click();

    }
    public void checkout(){
        driver.findElement(By.cssSelector("button[data-interaction='Continue to basket']")).click();
       driver.findElement(By.cssSelector("span[style='vertical-align: middle;']")).click();
    }

//    @After
            public void teardown () {

                driver.quit();
            }
        }

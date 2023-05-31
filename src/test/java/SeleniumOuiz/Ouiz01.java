package SeleniumOuiz;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;

public class Ouiz01 {
   static WebDriver driver;
    @Test
    public void test01() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.navigate().to("h");
        driver.getTitle();
        driver.manage( ).window( ).setPosition(new Point( 80 , 0 ));
        System.out.println("x:80,y:0");
        Thread.sleep(4000);
        driver.getCurrentUrl();
        driver.navigate().to("https://www.letgo.com");
        driver.manage( ).window( ).setPosition(new Point( 100 , 300 ));
        //Ödev-->driver.get() ile driver.navigate().to()

        System.out.println("x:100,y:300");
        Thread.sleep(3000);
        System.out.println(driver.getPageSource());
        driver.getWindowHandles();
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());
        driver.manage().window().getPosition();
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // ExpectedConditions.titleIs()
//        driver.findElement().click();
//        driver.findElement().getText();
//        driver.findElement().submit();
//        driver.findElement().sendKeys();
        driver.close();
        driver.quit();


    }
//    public void waitAndClick(WebDriver driver, WebElement element){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
//    }
    }



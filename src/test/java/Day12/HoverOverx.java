package Day12;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HoverOverx {
    //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2. "Hover over Me First" kutusunun ustune gelin
    //3. "Link 1" e tiklayin
    //4. Popup mesajini yazdirin
    //5. Popup'i tamam diyerek kapatin
    //6. "Click and hold" kutusuna basili tutun
    //7. "Click and hold" kutusunda cikan yaziyi yazdirin
    //8. "Double click me" butonunu cift tiklayin
    //9. "Double click me" butonunun renk değiştridiğini doğrulayın
    WebDriver driver;


    @Before
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void Test1()  {
        //Actions Class Home Work
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoverOverMeFirst= driver.findElement(By.xpath("(//div[@class='dropdown hover'])"));
        actions.moveToElement(hoverOverMeFirst).perform();
        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])")).click();
        //4- Popup mesajini yazdirin
        System.out.println("Pop-up mesaji : "+driver.switchTo().alert().getText());
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold=driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();
        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("Click and hold kutusu : "+clickAndHold.getText());
        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickMe=driver.findElement(By.tagName("h2"));
        actions.doubleClick(doubleClickMe).perform();
        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        WebElement doubleColour=driver.findElement(By.xpath("//div[@id='double-click']"));
        Assert.assertTrue(doubleColour.getAttribute("class").equals("div-double-click double"));
        System.out.println();
        //div-double-click double

    }
    @After
    public void tearDown(){

        driver.quit();
    }
}

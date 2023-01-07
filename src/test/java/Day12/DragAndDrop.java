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

import java.time.Duration;

public class DragAndDrop {
    /*
    #go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
   #Fill in capitals by country
  */
    /*
     #url'ye gidin: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    #Ülkeye göre başkentleri doldurun
   */
    WebDriver driver;


    @Before
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
    }
    @After
    public void tearDown(){
        // driver.quit();
    }
    @Test
    public void test(){
        dhtml_fill_in_capitals_by_country();

    }
    public void dhtml_fill_in_capitals_by_country() {
        WebElement Rome=driver.findElement(By.xpath("(//div[@id='box6'])"));
        WebElement Italy=driver.findElement(By.xpath("(//div[@id='box106'])"));

        WebElement Madrid=driver.findElement(By.xpath("(//div[@id='box7'])"));
        WebElement Spain=driver.findElement(By.xpath("(//div[@id='box107'])"));

        WebElement Oslo=driver.findElement(By.xpath("(//div[@id='box1'])"));
        WebElement Norway=driver.findElement(By.xpath("(//div[@id='box101'])"));

        WebElement Copenhagen=driver.findElement(By.xpath("(//div[@id='box4'])"));
        WebElement Denmark=driver.findElement(By.xpath("(//div[@id='box104'])"));

        WebElement Seoul=driver.findElement(By.xpath("(//div[@id='box5'])"));
        WebElement SKorea=driver.findElement(By.xpath("(//div[@id='box105'])"));

        WebElement Stockholm=driver.findElement(By.xpath("(//div[@id='box2'])"));
        WebElement Sweden=driver.findElement(By.xpath("(//div[@id='box102'])"));

        WebElement Washington=driver.findElement(By.xpath("(//div[@id='box3'])"));
        WebElement UnitedStates=driver.findElement(By.xpath("(//div[@id='box103'])"));

        Actions actions=new Actions(driver);

        actions.dragAndDrop(Rome,Italy).perform();
        actions.dragAndDrop(Madrid, Spain).perform();
        actions.dragAndDrop(Oslo,Norway).
                dragAndDrop(Copenhagen, Denmark)
                .dragAndDrop(Seoul, SKorea)
                .dragAndDrop(Stockholm, Sweden)
                .dragAndDrop(Washington, UnitedStates)
                .perform();

        Assert.assertTrue(driver.findElement(By.xpath("(//div[@style='visibility: visible; background-color: rgb(0, 255, 0);'])[1]")).isDisplayed());
    }
}

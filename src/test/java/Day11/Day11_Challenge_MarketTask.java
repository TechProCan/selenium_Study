package Day11;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Day11_Challenge_MarketTask {
    WebDriver driver;


    @Before
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        go_to_amazonTR();
        accept_Cookies_Amazon();
        arama_yapar("iPhone13 512");
        amazonda_görüntülenen_ilgili_sonuclar_iceriyormu("iphone 13 512");
        clickIPhoneAtTheTopOfTheList(1);
        logTheFollowingValuesForEachSize();

    }
    public void go_to_amazonTR(){
        driver.get("https://www.amazon.com.tr/");
        WebDriverWait wait= wait=new WebDriverWait(driver,Duration.ofSeconds(5L));
        wait.until(ExpectedConditions.titleContains("Amazon"));

    }
    public void accept_Cookies_Amazon(){
        WebDriverWait wait= wait=new WebDriverWait(driver,Duration.ofSeconds(5L));
        WebElement cookies=driver.findElement(By.id("sp-cc-accept"));
        wait.until(ExpectedConditions.visibilityOf(cookies));
        cookies.click();
    }
    public void arama_yapar(String aranacakKelime) {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(aranacakKelime + Keys.ENTER);
    }
    public void amazonda_görüntülenen_ilgili_sonuclar_iceriyormu(String arananKelime) {
        WebDriverWait wait= wait=new WebDriverWait(driver,Duration.ofSeconds(5L));
      WebElement resultText=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])//span[@class='a-color-state a-text-bold']"));
      wait.until(ExpectedConditions.visibilityOf(resultText));
      Assert.assertTrue(resultText.getText().contains(arananKelime));
    }
    public void clickIPhoneAtTheTopOfTheList(int index) {
        WebDriverWait wait= wait=new WebDriverWait(driver,Duration.ofSeconds(5L));
       WebElement TopOfTheList= driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])"+"["+index+"]"+""));
       wait.until(ExpectedConditions.visibilityOf(TopOfTheList));
       TopOfTheList.click();
    }
    public void logTheFollowingValuesForEachSize() throws InterruptedException {
//********************************* güncel  sayfa yapısı ************************************************************
            WebElement element = null;
            try {
                for (int i = 0; i <3 ; i++) {
                element = driver.findElement(By.xpath("(//input[@name='"+i+"'])[2]"));
                    element.click();
                    Thread.sleep(5000);
                    System.out.println(driver.findElement(By.id("productTitle")).getText()+" "+"Size : "+driver.findElement(By.xpath("//span[@id='inline-twister-expanded-dimension-text-size_name']")).getText());
                    System.out.println("Color: "+driver.findElement(By.xpath("//span[@id='inline-twister-expanded-dimension-text-color_name']")).getText()+" "+"Price : "+driver.findElement(By.xpath("//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@class='a-price-whole']")).getText()+","+driver.findElement(By.xpath("//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@class='a-price-fraction'][normalize-space()='30']")).getText()+"TL");
                    System.out.println("Stock: "+driver.findElement(By.xpath("//span[@class='a-size-medium a-color-success']")).getText());
                    System.out.println("1------------------------------------------------------------------------------------------------------------------------");



                }
            } catch (NoSuchElementException e) {
                System.out.println("Element could not be found-1: ");
                }
        //********************  ilkel sayfa yapısı ***********************************************
        List<WebElement> productSize = null;
            try {
            productSize = driver.findElements(By.xpath("//p[@class='a-text-left a-size-base']"));
            for (int i=productSize.size()-1 ; i >=0 ; i--) {
                productSize.get(i).click();

                    Thread.sleep(5000);

                System.out.println(driver.findElement(By.id("productTitle")).getText()+" "+"Size : "+driver.findElement(By.xpath("(//span[@class='selection'])[1]")).getText());
                System.out.println("Color: "+driver.findElement(By.xpath("(//span[@class='selection'])[2]")).getText()+" "+"Price : "+driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText()+","+driver.findElement(By.xpath("//span[@class='a-price-fraction']")).getText()+"TL");
                System.out.println("Stock: "+driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-success'])")).getText());
                System.out.println("2-------------------------------------------------------------------------------------------------------------------------");

               }
            } catch (NoSuchElementException e) {
            System.out.println("Elements could not be found-2: ");
               }

        }

    }


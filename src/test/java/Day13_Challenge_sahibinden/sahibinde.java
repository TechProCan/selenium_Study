package Day13_Challenge_sahibinden;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class sahibinde extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //sahibinden.com a gidin
        driver.get("https://www.sahibinden.com");
        //anasayfada oldugunuzu dogrulayin
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.sahibinden.com"));
        driver.findElement(By.id("onetrust-close-btn-container")).click();
        //detayli arama tiklayin
        driver.findElement(By.xpath("//*[@title='Detaylı Arama']")).click();
        //detayli arama sayfasina geldiginizi dogrulatin
        Assert.assertTrue(driver.getTitle().contains("Detaylı Arama"));
        //emlak-konut-satilik seceneklerini secip
        //altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin
        driver.findElement(By.xpath("(//li/span)[5]")).click();
        driver.findElement(By.xpath("(//li/span)[15]")).click();
        driver.findElement(By.xpath("(//li/span)[24]")).click();
        driver.findElement(By.xpath("//span[@href='#ANY']")).click();

        detayli_Arama_Adres("izmir", "bayrakli", "adalet mah.");
        detayli_Arama_Fiyat("4.000","4.000.000","USD");
        detayli_Arama_Brut("180","400");
        detayli_Arama_Oda_Sayisi("10+2","11-15 arası","1",6,4);
        click_Arama_Yap_Button();

        //cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin
        verify_Result("adalet mah.");
        write_Result();
    }

    public void detayli_Arama_Adres(String il, String ilce, String Mah) throws InterruptedException {
        WebElement Adres1 = driver.findElement(By.xpath("(//*[@class='faceted-select'])[1]"));
        Adres1.click();
        waitFor(2);
        driver.findElement(By.xpath("(//ul[@class='address-search-list']//li[@data-label='"+il+"'])")).click();
        waitFor(2);

        WebElement Adres2 = driver.findElement(By.xpath("(//*[@class='faceted-select'])[2]"));
        Adres2.click();
        waitFor(2);
        driver.findElement(By.xpath("(//ul[@class='address-search-list']//li[@data-label='"+ilce+"'])")).click();
        waitFor(2);
        driver.findElement(By.xpath("//a[@class='collapse-pane']")).click();

        WebElement Adres3 = driver.findElement(By.xpath("(//*[@class='faceted-select'])[3]"));
        Adres3.click();
        waitFor(2);
        driver.findElement(By.xpath("(//ul[@class='address-search-list']//li[@data-label='"+Mah+"'])")).click();
        waitFor(2);
        driver.findElement(By.xpath("//a[@class='collapse-pane']")).click();
    }

    public void detayli_Arama_Fiyat(String minTL,String maxTL,String currency){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        Select price_currency=new Select(driver.findElement(By.xpath("//select[@name='price_currency']")));
        price_currency.selectByVisibleText(currency);


       WebElement MinTL=driver.findElement(By.xpath("(//td)[6]//input[1]"));
       wait.until(ExpectedConditions.visibilityOf(MinTL));
       MinTL.sendKeys(minTL);

        WebElement MaxTL=driver.findElement(By.xpath("(//td)[6]//input[2]"));
        wait.until(ExpectedConditions.visibilityOf(MaxTL));
        MaxTL.sendKeys(maxTL);
    }

    public void detayli_Arama_Brut(String minBrut,String maxBrut){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));


        WebElement MinBrut=driver.findElement(By.xpath("(//td)[8]//input[1]"));
        wait.until(ExpectedConditions.visibilityOf(MinBrut));
        MinBrut.sendKeys(minBrut);

        WebElement MaxBrut=driver.findElement(By.xpath("(//td)[8]//input[2]"));
        wait.until(ExpectedConditions.visibilityOf(MaxBrut));
        MaxBrut.sendKeys(maxBrut);
    }

    public void detayli_Arama_Oda_Sayisi(String odaSayisi,String binaY,String Bkat,int katS,int İsi) throws InterruptedException {


        //odaTipi
        driver.findElement(By.xpath("(//span[contains(text(),'Tümü')])[5]")).click();

        waitFor(3);

        WebElement odaTipi = driver.findElement(By.xpath("//*[@id='a20']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style')", odaTipi);
        Select select = new Select(odaTipi);
        select.selectByVisibleText(odaSayisi);
//BinaYaşı
        driver.findElement(By.xpath("(//span[contains(text(),'Tümü')])[6]")).click();
        waitFor(3);
        WebElement BinaYasi = driver.findElement(By.xpath("//*[@id='a812']"));
        JSExecutorSelectVisibleText(BinaYasi,binaY);

//BulunduguKat
        WebElement bulunduguKat=driver.findElement(By.xpath("(//span[contains(text(),'Tümü')])[7]"));
        bulunduguKat.click();
        waitFor(3);
        WebElement BulunduguKat = driver.findElement(By.xpath("//*[@id='a811']"));
        JSExecutorSelectVisibleText(BulunduguKat,Bkat);


//KatSayısı
        WebElement KSayisi=driver.findElement(By.xpath("(//span[contains(text(),'Tümü')])[8]"));
        KSayisi.click();
        waitFor(3);
        WebElement KatSayısı = driver.findElement(By.xpath("//*[@id='a810']"));
       JSExecutorSelectIndex(KatSayısı,katS);


//Isıtma
        WebElement İstma=driver.findElement(By.xpath("(//span[contains(text(),'Tümü')])[9]"));
        İstma.click();
        waitFor(3);
        WebElement Isıtma = driver.findElement(By.xpath("//*[@id='a23']"));
        JSExecutorSelectIndex(Isıtma,İsi);


    }
    public void click_Arama_Yap_Button(){

        WebElement aramaButton = driver.findElement(By.xpath("//button[@class='btn mtdef']"));
      scrollToElement(aramaButton);
        aramaButton.click();
    }

    public void verify_Result(String Mah){
        WebElement resultText=driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(resultText.getText().toLowerCase().contains(Mah.toLowerCase()));
    }
    public void write_Result(){
        WebElement searchResult=driver.findElement(By.xpath("//span[@id='saveSearchResult']"));
        System.out.println("Search Result : "+searchResult.getText());
    }


}

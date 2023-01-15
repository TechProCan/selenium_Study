package Day14_Challenge_n11;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.time.Duration;


public class n_11 {
    WebDriver driver;
    private String n11Url = "https://www.n11.com/";
    private String n11ValidEmail = "test.123.yap@gmail.com";
    private String n11ValidPassword = "Deneme123!";
   private String element1 ="div.inputField:nth-child(1) > div:nth-child(3) > div:nth-child(1)";
    private String element2 = "div.errorMessage:nth-child(4) > div:nth-child(1)";


    @Before
    public void setup()  {


        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//20 SANIYEYE KADAR BEKLE.SELENIUM
    }

    @After
    public void tearDown(){
         driver.quit();
    }

    @Test
    public void test01() {
        Login_N11(n11ValidEmail, n11ValidPassword, "DD");

    }

    @Test
    public void test02() throws InterruptedException {

        INLogin_N11("n11ValidEmail", n11ValidPassword);
        Assert.assertTrue(driver.findElement(By.cssSelector(element1)).isDisplayed());
    }

    @Test
    public void test03() throws InterruptedException {


        INLogin_N11(n11ValidEmail, "n11ValidPassword");
        Assert.assertTrue(driver.findElement(By.cssSelector(element2)).isDisplayed());
    }

    @Test
    public void test04() throws InterruptedException {


        INLogin_N11("n11ValidEmail", "n11ValidPassword");
        Assert.assertTrue(driver.findElement(By.cssSelector(element1)).isDisplayed());
    }

    @Test
    public void test05() throws InterruptedException {


        INLogin_N11(n11ValidEmail, " ");
        Assert.assertTrue(driver.findElement(By.cssSelector(element2)).isDisplayed());
    }

    @Test
    public void test06() throws InterruptedException {


        INLogin_N11(" ", n11ValidPassword);
        Assert.assertTrue(driver.findElement(By.cssSelector(element1)).isDisplayed());
    }

    @Test
    public void test07() throws InterruptedException {

        INLogin_N11(" ", "");
        Assert.assertTrue(driver.findElement(By.cssSelector(element1)).isDisplayed());
    }


    public void Login_N11(String email, String password, String expectedResult) {
        driver.get(n11Url);
        driver.findElement(By.xpath("//a[@class='btnSignIn']")).click();

        // Enter email and password
        WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys(password);

        // Click login button
        driver.findElement(By.xpath("//div[@id='loginButton']")).click();

        // Check for the expected result
        String actualResult = driver.findElement(By.xpath("//a[@class='user']")).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    public void INLogin_N11(String email, String password) throws InterruptedException {
        driver.get(n11Url);
        driver.findElement(By.xpath("//a[@class='btnSignIn']")).click();

        // Enter email and password
        WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys(password);


        // Click login button
        driver.findElement(By.xpath("//div[@id='loginButton']")).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).perform();
       Thread.sleep(3000);


    }
}

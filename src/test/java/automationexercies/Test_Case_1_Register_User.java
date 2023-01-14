package automationexercies;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Test_Case_1_Register_User {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

*/
    WebDriver driver;


    @Before
    public void setUp(){
        ChromeOptions options=new ChromeOptions();
        options.addExtensions(new File(".\\libs\\extension_4_6_0_0.crx"));
        DesiredCapabilities capabitilites = new DesiredCapabilities();
        capabitilites.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
       // driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
naviga_to_url();
verify_home_page_is_Visible();
click_Sign_Up_Login();
verify_New_User_SignUp();
enter_name_emailAdress("Can","ecan3115@gmail.com");
click_Signup_Button();
Verify_that_ENTER_ACCOUNT_INFORMATION_is_visible();
Fill_details();


    }
    public void naviga_to_url(){
        driver.get("https://automationexercise.com/");
        Assert.assertTrue(driver.getTitle().equals("Automation Exercise"));
    }
    public void verify_home_page_is_Visible(){
       Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());
    }
    public void click_Sign_Up_Login(){
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();

    }
    public void verify_New_User_SignUp(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement title=driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']"));
        wait.until(ExpectedConditions.visibilityOf(title));
        Assert.assertTrue(title.getText().contains("Signup!"));
    }
    public void enter_name_emailAdress(String name,String email){
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);
    }
    public void click_Signup_Button(){
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
    }
    public void Verify_that_ENTER_ACCOUNT_INFORMATION_is_visible(){
        String element=driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]")).getText();
        Assert.assertTrue(element.contains("ACCOUNT"));
    }
    public void Fill_details() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        WebElement userName = driver.findElement(By.xpath("//input[@id='name']"));
        userName.clear();
        userName.sendKeys("name");
        WebElement userPassword = driver.findElement(By.xpath("//input[@id='password']"));
        userPassword.sendKeys("passwords");
        WebElement date = driver.findElement(By.xpath("//*[@id='days']"));
        date.click();
        date.sendKeys("3");
        WebElement month = driver.findElement(By.xpath("//*[@id='months']"));
        month.click();
        month.sendKeys("may");
        WebElement year = driver.findElement(By.xpath("//*[@id='years']"));
        year.click();
        year.sendKeys("1980");
        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();
        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@id=\"optin\"]")).click();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
        firstName.sendKeys("Can");
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
        lastName.sendKeys("EFE");
        WebElement company = driver.findElement(By.xpath("//*[@id=\"company\"]"));
        company.sendKeys("cosmos");
        WebElement adresses = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
        adresses.sendKeys("antalya");
        WebElement adresses2 = driver.findElement(By.xpath("//*[@id=\"address2\"]"));
        adresses2.sendKeys("dosemealti");
        WebElement country = driver.findElement(By.xpath("//*[@id=\"country\"]"));
        country.click();
        country.sendKeys("canada".toLowerCase());
        WebElement state = driver.findElement(By.xpath("//*[@id=\"state\"]"));
        state.sendKeys("Sivas");
        WebElement city = driver.findElement(By.xpath("//*[@id=\"city\"]"));
        city.sendKeys("Gurun");
        WebElement zipcode = driver.findElement(By.xpath("//*[@id=\"zipcode\"]"));
        zipcode.sendKeys("58100");
        WebElement mobileNumber = driver.findElement(By.xpath("//*[@id=\"mobile_number\"]"));
        mobileNumber.sendKeys("123456789");
        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();
        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreate = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
       Assert.assertTrue(accountCreate.isDisplayed());
       WebElement ContinueButton=driver.findElement(By.xpath("//div[@class='pull-right']"));
       Thread.sleep(3000);
        //driver.navigate().refresh();
       //15. Click 'Continue' button
        ContinueButton.click();
        //16. Verify that 'Logged in as username' is visible

        WebElement loggedInAsUsername = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
       wait.until(ExpectedConditions.visibilityOf(loggedInAsUsername));


        if (loggedInAsUsername.isDisplayed()){
            System.out.println("Logged in as username testing PASSED");
        }else System.out.println("Logged in as username testing FAILED");
        //17. Click 'Delete Account' button
        WebElement deleteAccount = driver.findElement(By.xpath("//a[@href='/delete_account']"));
        deleteAccount.click();
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDelete = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        String arananKelime = "ACCOUNT DELETED!";
        if (accountDelete.equals(arananKelime)){
            System.out.println("ACCOUNT DELETED! testing PASSED");
        }else System.out.println("ACCOUNT DELETED! testing FAILED");


    }
}

//package SeleniumOuiz;
//
//import org.apache.commons.io.FileUtils;
//import org.junit.Test;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.asserts.SoftAssert;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class Ouiz03 {
//    static WebDriver driver;
//
//    @Test
//    public void test01() throws InterruptedException {
//        driver = new ChromeDriver();
////        SoftAssert softAssert = new SoftAssert();
////        String rooney="Claruswa";
////        softAssert.assertTrue(rooney.equals("Clarusway"));
////
////        System.out.println("Soft Assert çalisti");
////        Assert.assertTrue(rooney.equals("Claruswa"));
////        System.out.println("Hard Assert çalisti");
////
////        softAssert.assertAll();
//
//driver.get("www.clarusway.com");
//
//
//
//
//
//
//
//        @Given("^Open the Firefox and launch the application$")
//        public void open_the_Firefox_and_launch_the_application() throws Throwable
//        {
//            System.out.println("This Step open the Firefox and launch the application.");
//        }
//
//        @When("^Enter the Username and Password$")
//        public void enter_the_Username_and_Password() throws Throwable
//        {
//            System.out.println("This step enter the Username and Password on the login page.");
//        }
//
//        @Then("^Reset the credential$")
//        public void Reset_the_credential() throws Throwable
//        {
//            System.out.println("This step click on the Reset button.");
//        }
//
//
//    }
//
//    //========ScreenShot Web Element(Bir webelementin resmini alma)=====//
//    public static String getScreenshotWebElement(String name, WebElement element) throws IOException {
//        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//        // TakesScreenshot is an interface of selenium that takes the screenshot
//        File source = element.getScreenshotAs(OutputType.FILE);
//        // full path to the screenshot location
//        String wElementSS = System.getProperty("user.dir") + "/target/WElementScreenshots/" + name + date + ".png";
//        File finalDestination = new File(wElementSS);
//        // save the screenshot to the path given
//        FileUtils.copyFile(source, finalDestination);
//        return  wElementSS;
//    }
//}
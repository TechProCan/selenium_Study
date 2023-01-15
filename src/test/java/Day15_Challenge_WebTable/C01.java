package Day15_Challenge_WebTable;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01 extends TestBase {

    @Test
    public void test01(){
        //https://www.way2automation.com/angularjs-protractor/webtables/
        //tüm E-mail leri yazdırın
        //Tüm E-maillerin "@" işareti içerdiğini doğrulayin

        driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");
        List<WebElement> list=driver.findElements(By.xpath("//table[@class='smart-table table table-striped']//tbody//td[7]"));
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).getText());
            Assert.assertTrue(list.get(i).getText().contains("@"));

        }
    }
}

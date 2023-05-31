package SeleniumOuiz;

import org.testng.annotations.Test;

public class C03_DependsOn {
    @Test( dependsOnMethods = "test02")
    public void test01() {
        System.out.println("Test01 is runnung ...");
    }
    @Test
    public void test02() {
        System.out.println("Test02 is runnung ...");
    }
    @Test(priority = -1)
    public void test03() {
        System.out.println("Test03 is runnung ...");
    }
    @Test()
    public void test04() {
        System.out.println("Test04 is runnung ...");
    }
    @Test(priority = 1)
    public void test05() {
        System.out.println("Test05 is runnung ...");
    }
}
package SeleniumOuiz;


import org.testng.annotations.Test;

public class DependsOn {

    @Test(dependsOnMethods = "test02")
    public void test01(){
        System.out.println("1.Test");
    }
@Test
    public void test02(){
        System.out.println("2.Test");
    }
@Test(priority = -1)
    public void test03(){
        System.out.println("3.Test");
    }

}

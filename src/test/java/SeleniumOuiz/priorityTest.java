package SeleniumOuiz;


import org.testng.annotations.Test;

public class priorityTest {

    @Test(priority = 1)//import JUnit'ten olursa priority'i kullanamayız
  public void test01(){
      System.out.println("1.Test");
  }
    @Test
    public void test02(){
        System.out.println("2.Test");
    }
    @Test (priority = 3)
    public void test03(){
        System.out.println("3.Test");
    }
    @Test
    public void test04(){
        System.out.println("4.Test");
    }

}

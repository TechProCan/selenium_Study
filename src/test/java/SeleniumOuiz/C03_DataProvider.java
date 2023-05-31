package SeleniumOuiz;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C03_DataProvider {
        @DataProvider(name = "testdata")
        public Object[][] testData() {
            return new Object[][] {
                    { "John", 25, "Male", true },
                    { "Jane", 30, "Female", false },
                    { "Tom", 35, "Male", true }
            };
        }

        @Test(dataProvider = "testdata")
        public void testMethod(String name, int age, String gender, boolean isActive) {
            System.out.println("Name: " + name + ", Age: " + age + ", Gender: " + gender + ", isActive: " + isActive);
        }
    }


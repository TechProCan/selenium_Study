package SeleniumOuiz;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ouiz02 {

    @BeforeClass
    public static void setUpBeforeClass() {
        // Bu metod, test sınıfının tüm test metotları çalışmadan önce sadece bir kez çağırılır
        // Örneğin, veritabanı bağlantısı açma işlemleri bu metodda yapılabilir.
        System.out.println("setUpBeforeClass metodu çalıştı");
    }

    @Before
    public void setUp() {
        // Bu metod, her test metodu çalışmadan önce çağırılır
        // Örneğin, her test için gerekli nesnelerin başlatılması bu metodda yapılabilir.
        System.out.println("setUp metodu çalıştı");
    }

    @Test
    public void test1() {
        // Bu metot bir test metodu olarak işaretlendi
        // Bu metot test edilecek işlevi içermeli
        System.out.println("test1 metodu çalıştı");
    }

    @Test
    public void test2() {
        // Bu metot bir test metodu olarak işaretlendi
        // Bu metot test edilecek işlevi içermeli
        System.out.println("test2 metodu çalıştı");
    }

    @Ignore
    @Test
    public void test3() {
        // Bu metot da bir test metodu olarak işaretlendi, ancak @Ignore notasyonu nedeniyle çalıştırılmayacak
        System.out.println("test3 metodu çalıştı");
    }

    @After
    public void tearDown() {
        // Bu metod, her test metodu çalıştıktan sonra çağırılır
        // Örneğin, her test için gerekli nesnelerin sonlandırılması bu metodda yapılabilir.
        System.out.println("tearDown metodu çalıştı");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        // Bu metod, test sınıfının tüm test metotları çalıştıktan sonra sadece bir kez çağırılır
        // Örneğin, veritabanı bağlantısı kapatma işlemleri bu metodda yapılabilir.
        System.out.println("tearDownAfterClass metodu çalıştı");
//        Assert.assertFalse();
//        Assert.assertArrayEquals();
//        //Assert.assertTrueNull()
//        Assert.assertNotNull();
//        Assert.assertNull();
    }
}



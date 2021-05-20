package Try1;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @Test()
    public void test1(){
        System.out.println("Test1");
    }
    @Test()
    public void test2(){
        System.out.println("Test2");
    }
    @BeforeSuite
    public void testBeforeSuite(){
        System.out.println("beforeSuite");
    }
    @AfterSuite
    public void testAfterSuite(){
        System.out.println("AfterSuite");
    }
    @BeforeTest
    public void testBeforeTest(){
        System.out.println("BeforeTest");
    }
    @AfterTest()
    public void testAfterTest(){
        System.out.println("AfterTest");
    }
    @BeforeClass()

        public void testBeforeClass(){
        System.out.println("BeforeClass");
    }
    @AfterClass()
    public void testAfterClass(){
        System.out.println("AfterClass");
    }
    @BeforeMethod()
    public void testabeforeMethod(){
        System.out.println("BeforeMethod");
    }
    @AfterMethod()
    public void testAfterMethod(){
        System.out.println("AfterMethod");
    }

}

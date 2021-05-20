package Try1;

import org.testng.annotations.Test;

public class TestNgPractice {

    @Test(dependsOnMethods= {"testTestNg3","testTestNg2"} , groups = "Sanity")

    public void testTestNg1(){
        System.out.println("Test 1");

    }
    @Test( alwaysRun = true, groups = "Functional")
    public void testTestNg2(){
        System.out.println("Test 2");

    }

    @Test( alwaysRun = true)
    public void testTestNg3(){
        System.out.println("Test 3");

    }
    @Test( alwaysRun = true, groups = "Sanity")
    public void testTestNg4(){
        System.out.println("Test 4");

    }
    @Test( alwaysRun = false, groups = "Functional")
    public void testTestNg5(){
        System.out.println("Test 5");

    }
    @Test(enabled = true)
    public void testTestNg6(){
        System.out.println("Test 6");

    }

}

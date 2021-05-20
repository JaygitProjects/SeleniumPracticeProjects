package Try1;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionDemo {
    @Test(priority = 1, groups = {"TestFail"})
    public void testFalse() {

        System.out.println("****This is test False in 1st test case****");
           Assert.assertFalse(true);
        /*SoftAssert sa = new SoftAssert();*/
        /*sa.assertTrue(false, "This is false condition");*/

        System.out.println("This is end of 1st test ");
       /* sa.assertAll();*/

    }

    @Test(priority = 2,groups = {"TestPass"})
    public void testTrue() {

        System.out.println("****This is test true in 2nd test case *****");
        //   Assert.assertTrue(true);
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(true, "This is true condition");
        sa.assertAll();
        System.out.println("This is end of 2nd test");
    }
    @Test(priority = 3, groups = {"TestPass"})
    public void testTrue2(){
        System.out.println("**This is start of test3 true");
    }
    @Test (priority = 4, groups = {"testPassAndFail","TestFail"})
    public void testSoftAssertion() {
        System.out.println("************Test 3 *************");
        SoftAssert softAssert = new SoftAssert();

        int expectedVal = 123;
        int actualVal = 456;
        System.out.println("My first line of code exec..");

        softAssert.assertEquals(actualVal, expectedVal, "Integers are unequal...");//error
        softAssert.assertTrue(2 > 1, "condition evaluated to false"); // no error
        softAssert.assertTrue(false, "condition evaluated to false"); // error
        softAssert.assertFalse(true, "condition evaluated to true"); // error

        System.out.println("My last line of code exec..");
        softAssert.assertAll();
    }
}
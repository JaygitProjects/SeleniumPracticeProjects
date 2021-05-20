package JavaConcepts;

import org.testng.annotations.Test;

public class StaticAndNonStaticDifference {
    static String name = "Jayanthi";
    @Test
    public static void testTry2(){

        System.out.println(name);
        sum();
       StaticAndNonStaticDifference t2 = new StaticAndNonStaticDifference();
       t2.add();


    }
    public void add(){
        System.out.println("I am add");
        System.out.println(name);

    }
    public static void sum(){
        System.out.println("I am sum");
        System.out.println(name);

    }
}

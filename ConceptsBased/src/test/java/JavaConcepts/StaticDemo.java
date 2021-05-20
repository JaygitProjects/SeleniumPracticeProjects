package JavaConcepts;

import org.testng.annotations.Test;

public class StaticDemo {
    public static String name = "Jayanthi";
    static int age = 35;
    String name1 = "Raja";
    int age1= 45;

@Test
public static void testStatic(){

    StaticDemo dm = new StaticDemo();
    System.out.println("Name and age fro Static method :"+ dm.name1+""+dm.age1);
    System.out.println("Name and age fro Static method :"+ name+", "+age);

}
@Test
    public void testNonStatic(){

    System.out.println("Name and age from Non-Static method :"+name1+ ", "+ age1);
    System.out.println("Name and age fro Static method :"+ name+", "+age);

}

}

package Try1;

import org.testng.annotations.Test;

public class BasicStringMethods {
    @Test
    public void testTry(){
        String a = "Jay";
        a="Raj";

        String b = "I am  Jay";
        String c= "i,am,a,girl";
        System.out.println(a);
        System.out.println(a.charAt(2));
        System.out.println(b.length());

        System.out.println(String.join("*", "I", "am", "Jay"));//adds * in between each word
        System.out.println(a.toLowerCase());
        System.out.println(String.valueOf("j"));
        System.out.println(a.replace("R", "J"));// not working
        System.out.println(a.substring(1));//display from index i
        System.out.println(b.substring(7, 9));//displays char from index 7 to 8
        System.out.println(a.isEmpty());

        System.out.println(a.equalsIgnoreCase(b));

        System.out.println(b.replace(" ", "*"));
        System.out.println(b.trim());

        System.out.println(b.charAt(5));
        System.out.println(b.concat("Raj"));
        System.out.println(b.contains("J"));
        System.out.println(b.indexOf("y"));
        System.out.println(b.toUpperCase());
        char c1 = 'a';
        char c2 = 'J';
        System.out.println((c1 + c2));//will convert to ascii code
        long id = 125;
        System.out.println((id + 5));
    }
}

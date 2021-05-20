package JavaConcepts;

import org.testng.annotations.Test;

public class String_Buffer_Builder {
    @Test
    public void testStrings(){
        String name = "Jayanthi";
        System.out.println("**** String is IMMUTABLE ******");
        StringBuffer sBuff=new StringBuffer("Jayanthi");
        System.out.println(name.concat("Balakrishnan"));
        System.out.println("String :" +name+"\n");
        System.out.println("*** String Buffer is MUTABLE *****");
        System.out.println(sBuff.append("Balakrishnan"));
        System.out.println("String Buffer:"+ sBuff);
        System.out.println("replace: "+sBuff.replace(1, 3, "a"));//changes 1st and 2nd index to a
        System.out.println("reverse: "+sBuff.reverse());
        System.out.println("2nd reverse: "+sBuff.reverse());
        System.out.println("capacity : " +sBuff.capacity());
        System.out.println("delete : " + sBuff.delete(1, 7));
        System.out.println("After deletion : " + sBuff);
    }
}


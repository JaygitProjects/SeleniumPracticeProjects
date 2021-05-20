package JavaConcepts;

import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class Loop {
    @Test
    public void testLoop(){
        //loop check
        int i = 0;
        while(i<10){
            System.out.println("while loop : " + i);
            i++;
        }
        for(int j = 0; j<10;j++){
            System.out.println(("For loop : " + j));
        }
        String k[] = {"Jay","Raj"};
        for (String o : k) {
            System.out.println(o);
        }
    }
}

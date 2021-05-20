package Try1;

import org.testng.annotations.Test;

public class IncrementDrecrement {

    @Test
    public void testIncDec(){
        int i = 10;
        System.out.println("i++ :" + i++);
        System.out.println("++i :" + ++i);
        System.out.println("i-- :" + i--);
        System.out.println("--i :" + --i);
        // System.out.println("j-- :" + j--);
        //        System.out.println("--j :" + --j);
    }
}

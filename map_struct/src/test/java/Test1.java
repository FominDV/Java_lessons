import org.junit.jupiter.api.MethodOrderer;
import org.junit.Test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test1 {

    @Test
    @Order(1)
    public void t1_1(){
        System.out.println("t1_1");
    }

    @Test
    @Order(3)
    public void t1_2(){
        System.out.println("t1_2");
    }

    @Test
    @Order(2)
    public void t1_3(){
        System.out.println("t1_3");
    }
}

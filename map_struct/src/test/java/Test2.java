import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test2 {

    @Test
    @Order(1)
    public void t2_1(){
        System.out.println("t2_1");
    }

    @Test
    @Order(3)
    public void t2_2(){
        System.out.println("t2_2");
    }

    @Test
    @Order(2)
    public void t2_3(){
        System.out.println("t2_3");
    }
}

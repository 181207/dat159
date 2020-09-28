import junit.framework.*;
import no.hvl.dat159.*;

public class Test extends TestCase {
   protected int value1, value2;
   protected Vehicle v1, v2;

   
   // assigning the values
   protected void setUp(){
      value1 = 3;
      value2 = 3;
   }

   // test method to add two values
   public void testAdd(){
      double result = value1 + value2;
      assertTrue(result == 6);
   }
}
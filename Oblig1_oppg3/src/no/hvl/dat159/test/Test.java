package no.hvl.dat159.test;
import junit.framework.*;
import no.hvl.dat159.*;

public class Test extends TestCase {
   protected Car car;
   protected Motorcycle mc = new Motorcycle();

   
   // assigning the values
   protected void setUp(){
      car = new Car();
      mc = new Motorcycle();
   }

   // test method to add two values
   // Supposed to fail after pulling up the method dobbeltAntallhjul from subclasses
   public void testAdd(){
      int carResult = car.dobbeltAntallHjul();
      int mcResult = mc.dobbeltAntallHjul();
      
      assertTrue(carResult == 8);
      assertTrue(mcResult == 4);
   }
}
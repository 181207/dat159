package no.hvl.dat159;

//If you "pull up" the method dobbeltAntallHjul my Junit test will fail. 
//the return value will change since this hjul() method is private and will 
//not be visible from Vehicle class. It will therefor use its own hjul() method.
public class Car extends Vehicle {
	private int hjul(){
		return 4;
	}
}

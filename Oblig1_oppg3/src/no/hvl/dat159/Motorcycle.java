package no.hvl.dat159;

//pull up the method dobbeltAntallHjul and you will change the behavior of the code
//the return value from dobbeltAntallHjul will not change since hjul() in vehicle is private
public class Motorcycle extends Vehicle {
	private int hjul(){
		return 2;
	}
	
	//method below is in the subclasses Car and Motorcycle before the refactoring/pull up.
	public int dobbeltAntallHjul() {
		return hjul() * 2;
	}
}

package no.hvl.dat159;

//pull up the method dobbeltAntallHjul and you will change the behavior of the code
//the return value from dobbeltAntallHjul will not change since hjul() in vehicle is private
public class Motorcycle extends Vehicle {
	public int hjul(){
		return 2;
	}
}

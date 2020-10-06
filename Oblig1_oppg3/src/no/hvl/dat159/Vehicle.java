package no.hvl.dat159;
//if you pull up and the method hjul() is private in vehicle the call on hjul() from a car instance will now return 2. 
public class Vehicle {
	private int hjul(){
		return 2;
	}
	
	//method below is in the class Vehicle after the refactoring/pull up.
//	public int dobbeltAntallHjul() {
//		return hjul() * 2;
//	}
}

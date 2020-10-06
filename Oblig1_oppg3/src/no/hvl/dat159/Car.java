package no.hvl.dat159;


public class Car extends Vehicle {
	private int hjul(){
		return 4;
	}
	
	//method below is in the subclasses Car and Motorcycle before the refactoring/pull up.
	public int dobbeltAntallHjul() {
		return hjul() * 2;
	}
}

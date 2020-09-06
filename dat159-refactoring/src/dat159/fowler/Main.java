package dat159.fowler;

import dat159.fowler.*;

public class Main {

	public static void main(String[] args) {
		Customer c1 = new Customer("Karl");
		
		Movie m1 = new Movie("Kapteinen", Movie.CHILDRENS);
		Movie m2 = new Movie("Hesten", Movie.CHILDRENS);
		
		//renting moving m1 for 5 days
		Rental r1 = new Rental(m1, 5);
		c1.addRental(r1);
		
		System.out.println(c1.statement());
		
		c1.addRental(new Rental(m2, 10));
		
		System.out.println(c1.statement());

	}

}


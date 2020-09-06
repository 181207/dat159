package dat159.fowler;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        // extracting method here Movie. It includes the code needed to as desccribed in the name.
        //Adding rentals as parameter becasuse they are local in the scope

        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();
            //Extracting the local variable this movie
            Movie thisMovie = each.getMovie();
            
            // determine amount for each line
            //extracting method to calculate thisAmount
            thisAmount = calculateTotalAmount(each);
            
            frequentRenterPoints += calculateFRP(each);
            //show figures for this rental
            result += "\t" + thisMovie.getTitle()+ "\t" +
                    String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
                " frequent renter points";
        return result;
    }
    
    private double calculateTotalAmount(Rental each) {
        Movie thisMovie = each.getMovie();
		double thisAmount = 0;

        switch (thisMovie.getPriceCode()) {
	        case Movie.REGULAR:
	            thisAmount += 2;
	            if (each.getDaysRented() > 2)
	                thisAmount += (each.getDaysRented() - 2) * 1.5;
	            break;
	        case Movie.NEW_RELEASE:
	            thisAmount += each.getDaysRented() * 3;
	            break;
	        case Movie.CHILDRENS:
	            thisAmount += 1.5;
	            if (each.getDaysRented() > 3)
	                thisAmount += (each.getDaysRented() - 3) * 1.5;
	            break;
        }
        return thisAmount;
    }
    
    private double calculateFRP(Rental each) {
    	double frequentRenterPoints = 1;
        Movie thisMovie = each.getMovie();
        // add bonus for a two day new release rental

        if ((thisMovie.getPriceCode() == Movie.NEW_RELEASE) &&
                each.getDaysRented() > 1) frequentRenterPoints ++;

        return frequentRenterPoints;	
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }
}

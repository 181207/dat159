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
    
    private double calculateTotalAmount(Rental rental) {
        Movie thisMovie = rental.getMovie();
        return thisMovie.getPrice(rental.getDaysRented());
    }
    
    private double calculateFRP(Rental each) {
    	double frequentRenterPoints = 1;
        Movie thisMovie = each.getMovie();
        // add bonus for a two day new release rental
        
        //making a call to FreqentRenterpoints in movie
        thisMovie.addFrequentRenterpoints(each);

        return frequentRenterPoints;	
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }
}

package dat159.fowler;

public class NewRelease extends Movie {

	public NewRelease(String title) {
		super(title,1 );
	}
	
    public double getPrice(int daysRented){
        return daysRented * 3;
    }
    
    public double addFrequentRenterpoints(Rental rental) {

        if (rental.getDaysRented() > 1) {
        	return 1;
        }
        return 0;

    }
}

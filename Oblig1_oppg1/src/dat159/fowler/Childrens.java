package dat159.fowler;

public class Childrens extends Movie {

	public Childrens(String title) {
		super(title,2);
	}
	
    public double getPrice(int daysRented){
    	double price = 1.5;
        if (daysRented > 3) {
            price += (daysRented - 3) * 1.5;
        }
        return price;
    }
}

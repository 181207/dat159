package dat159.fowler;

public abstract class Movie {
    private String _title;
    private int _priceCode;
  
    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }
    public Movie(String title) {
        _title = title;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int _priceCode) {
        this._priceCode = _priceCode;
    }

    public String getTitle() {
        return _title;
    }
    
    public double addFrequentRenterpoints(Rental rental) {
    	return 0;
    }
    
    public abstract double getPrice(int daysRented);
    
}

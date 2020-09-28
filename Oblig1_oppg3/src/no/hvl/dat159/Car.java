package no.hvl.dat159;

public class Car extends Vehicle {
	private int numberOfDoors;
	private int seats;
	private int wheels;

	
	public Car() {
		super();
		this.numberOfDoors = 4;
	}
	
	public Car( int seats, int wheels, int numberOfDoors) {
		super(seats,wheels);
		this.numberOfDoors = numberOfDoors;
	}

	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}
	
	public double seatsPerWheel() {
		return this.getWheels() / this.getSeats();
	}

}

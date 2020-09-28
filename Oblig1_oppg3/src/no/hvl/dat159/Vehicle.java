package no.hvl.dat159;

public class Vehicle {
	private int seats;
	private int wheels;
	
	public Vehicle() {
		this.seats=4;
		this.wheels=4;
	}
	
	public Vehicle(int seats, int wheels) {
		this.seats = seats;
		this.wheels = wheels;
	}

	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getWheels() {
		return wheels;
	}
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
}

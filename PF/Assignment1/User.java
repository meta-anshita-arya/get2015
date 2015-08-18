
//program to store user deatils
public class User {
 String username;
 String toPlace;
 String fromPlace;
 int seats;
 double price;
public User(String username, String toPlace, String fromPlace, int seats,
		double price) {
	super();
	this.username = username;
	this.toPlace = toPlace;
	this.fromPlace = fromPlace;
	this.seats = seats;
	this.price = price;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getToPlace() {
	return toPlace;
}
public void setToPlace(String toPlace) {
	this.toPlace = toPlace;
}
public String getFromPlace() {
	return fromPlace;
}
public void setFromPlace(String fromPlace) {
	this.fromPlace = fromPlace;
}
public int getSeats() {
	return seats;
}
public void setSeats(int seats) {
	this.seats = seats;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
}

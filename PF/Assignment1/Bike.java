// bike class 
public class Bike extends Vehicle {

	private boolean selfStart;
	private double helmetPrice;

	// getter setter
	public boolean getSelfStart() {
		return selfStart;
	}

	public void setSelfStart(boolean selfStart) {
		this.selfStart = selfStart;
	}

	public double getHelmetPrice() {
		return helmetPrice;
	}

	public void setHelmetPrice(double helmetPrice) {
		this.helmetPrice = helmetPrice;
	}

	// override calculateOnRoadPrice of vehicle
	double calculateOnRoadPrice() {
		return super.calculateOnRoadPrice() + 100;
	}

	@Override
	public String toString() {
		return "Bike [Make=" + getMake() + ", Model=" + getModel()
				+ ", Engine In CC=" + getEngineInCC() + ", Fuel Capacity="
				+ getFuelCapacity() + ", Milage=" + getMilage() + ", Price="
				+ getPrice() + ", Road Tax=" + getRoadTax() + ", Self Start="
				+ selfStart + ", Helmet Price=" + helmetPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(helmetPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (selfStart ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Bike))
			return false;
		Bike other = (Bike) obj;
		if (Double.doubleToLongBits(helmetPrice) != Double
				.doubleToLongBits(other.helmetPrice))
			return false;
		if (selfStart != other.selfStart)
			return false;
		return true;
	}

}

// Vehicle class

public abstract class Vehicle {

	private String make;
	private String model;
	private double engineInCC;
	private double fuelCapacity;
	private double milage;
	private double price;
	private double roadTax;

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getEngineInCC() {
		return engineInCC;
	}

	public void setEngineInCC(double engineInCC) {
		this.engineInCC = engineInCC;
	}

	public double getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public double getMilage() {
		return milage;
	}

	public void setMilage(double milage) {
		this.milage = milage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRoadTax() {
		return roadTax;
	}

	public void setRoadTax(double roadTax) {
		this.roadTax = roadTax;
	}

	// calculates road price
	double calculateOnRoadPrice() {
		return (price + roadTax);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(engineInCC);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(fuelCapacity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		temp = Double.doubleToLongBits(milage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(roadTax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Vehicle))
			return false;
		Vehicle other = (Vehicle) obj;
		if (Double.doubleToLongBits(engineInCC) != Double
				.doubleToLongBits(other.engineInCC))
			return false;
		if (Double.doubleToLongBits(fuelCapacity) != Double
				.doubleToLongBits(other.fuelCapacity))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (Double.doubleToLongBits(milage) != Double
				.doubleToLongBits(other.milage))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(roadTax) != Double
				.doubleToLongBits(other.roadTax))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehicle [make=" + make + ", model=" + model + ", engineInCC="
				+ engineInCC + ", fuelCapacity=" + fuelCapacity + ", milage="
				+ milage + ", price=" + price + ", roadTax=" + roadTax + "]";
	}

}

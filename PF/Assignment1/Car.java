// car class

public class Car extends Vehicle {

	private boolean AC;
	private boolean powerSteering;
	private boolean accessoryKit;

	public boolean getAC() {
		return AC;
	}

	public void setAC(boolean aC) {
		AC = aC;
	}

	public boolean getPowerSteering() {
		return powerSteering;
	}

	public void setPowerSteering(boolean powerSteering) {
		this.powerSteering = powerSteering;
	}

	public boolean getAccessoryKit() {
		return accessoryKit;
	}

	public void setAccessoryKit(boolean accessoryKit) {
		this.accessoryKit = accessoryKit;
	}

	// override calculateOnRoadPrice of vehicle
	double calculateOnRoadPrice() {
		return super.calculateOnRoadPrice() + 200;
	}

	@Override
	public String toString() {
		return "Car [Make=" + getMake() + ", Model=" + getModel()
				+ ", Engine In CC=" + getEngineInCC() + ", Fuel Capacity"
				+ getFuelCapacity() + ", Milage=" + getMilage() + ", Price="
				+ getPrice() + ", Road Tax=" + getRoadTax() + ", AC=" + AC
				+ ", Power Steering=" + powerSteering + ", Accessory Kit="
				+ accessoryKit + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (AC ? 1231 : 1237);
		result = prime * result + (accessoryKit ? 1231 : 1237);
		result = prime * result + (powerSteering ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Car))
			return false;
		Car other = (Car) obj;
		if (AC != other.AC)
			return false;
		if (accessoryKit != other.accessoryKit)
			return false;
		if (powerSteering != other.powerSteering)
			return false;
		return true;
	}

}

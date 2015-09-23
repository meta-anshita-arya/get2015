public class Car extends Vehicle {
	private boolean AC;
	private boolean powerSteering;
	private boolean accessoryKit;

	// getters and setters

	public boolean isAC() {
		return AC;
	}

	public void setAC(boolean aC) {
		AC = aC;
	}

	public boolean isPowerSteering() {
		return powerSteering;
	}

	public void setPowerSteering(boolean powerSteering) {
		this.powerSteering = powerSteering;
	}

	public boolean isAccessoryKit() {
		return accessoryKit;
	}

	public void setAccessoryKit(boolean accessoryKit) {
		this.accessoryKit = accessoryKit;
	}

}

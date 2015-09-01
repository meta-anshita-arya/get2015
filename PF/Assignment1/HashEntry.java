//Class to manage student entry in hash maps
public class HashEntry {
	private int key;
	private int age;
	private String name;

	HashEntry(int key, int age, String name) {
		this.key = key;
		this.age = age;
		this.name = name;
	}

	public int getKey() {
		return key;
	}

	public int getAge() {
		return age;
	}

	// return name
	public String getName() {
		return name;
	}

	// set name
	public void setName(String name) {
		this.name = name;
	}

	// set key
	public void setKey(int key) {
		this.key = key;
	}

	// set age
	public void setAge(int value) {
		this.age = value;
	}
}

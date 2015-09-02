//employee information class
public class EmployeeInformation implements Comparable {
	int empId;
	String name;
	String address;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeInformation other = (EmployeeInformation) obj;
		if (empId != other.empId)
			return false;
		return true;
	}

	// parameterized constructor to set informations
	EmployeeInformation(int empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	// get id
	public Integer getEmpId() {
		return empId;
	}

	// set id
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	// get name
	public String getName() {
		return name;
	}

	// set name
	public void setName(String name) {
		this.name = name;
	}

	// get address
	public String getAddress() {
		return address;
	}

	// set address
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int compareTo(Object obj) {
		return getEmpId().compareTo(((EmployeeInformation) obj).getEmpId());
	}
}

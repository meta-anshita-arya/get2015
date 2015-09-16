package ass1;

public class Member {
	private int memberId;
	private String memberName;
	private String addressLineFirst;
	private String addressLineSecond;
	private char category;
	private char personType;

	/**
	 * @param memberId
	 * @param memberName
	 * @param addressLineFirst
	 * @param addressLineSecond
	 * @param category
	 * @param personType
	 */
	public Member(int memberId, String memberName, String addressLineFirst,
			String addressLineSecond, char category, char personType) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.addressLineFirst = addressLineFirst;
		this.addressLineSecond = addressLineSecond;
		this.category = category;
		this.personType = personType;
	}

	// get memberId
	public int getMemberId() {
		return memberId;
	}

	// set memberId
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	// get memberName
	public String getMemberName() {
		return memberName;
	}

	// set memberName
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	// get addressLineFirst
	public String getAddressLineFirst() {
		return addressLineFirst;
	}

	// set addressLineFirst
	public void setAddressLineFirst(String addressLineFirst) {
		this.addressLineFirst = addressLineFirst;
	}

	// get addressLineSecond
	public String getAddressLineSecond() {
		return addressLineSecond;
	}

	// set addressLineSecond
	public void setAddressLineSecond(String addressLineSecond) {
		this.addressLineSecond = addressLineSecond;
	}

	// get category
	public char getCategory() {
		return category;
	}

	// set category
	public void setCategory(char category) {
		this.category = category;
	}

	// get personType
	public char getPersonType() {
		return personType;
	}

	// set personType
	public void setPersonType(char personType) {
		this.personType = personType;
	}

}

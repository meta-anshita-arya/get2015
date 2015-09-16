package ass1;

public class Book {
	private int accessionNo;
	private int titleIdOfBook;
	private String purchaseDate;
	private double price;
	private int status;

	// to set details of book
	public Book(int accessionNo, int titleIdOfBook, String purchaseDate,
			double price, int status) {
		super();
		this.accessionNo = accessionNo;
		this.titleIdOfBook = titleIdOfBook;
		this.purchaseDate = purchaseDate;
		this.price = price;
		this.status = status;
	}

	// get AccessionNo
	public int getAccessionNo() {
		return accessionNo;
	}

	// set AccessionNo
	public void setAccessionNo(int accessionNo) {
		this.accessionNo = accessionNo;
	}

	// get titleIdOfBook
	public int getTitleIdOfBook() {
		return titleIdOfBook;
	}

	// set titleIdOfBook
	public void setTitleIdOfBook(int titleIdOfBook) {
		this.titleIdOfBook = titleIdOfBook;
	}

	// get purchaseDate
	public String getPurchaseDate() {
		return purchaseDate;
	}

	// set purchaseDate
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	// get price
	public double getPrice() {
		return price;
	}

	// set price
	public void setPrice(double price) {
		this.price = price;
	}

	// get status
	public int getStatus() {
		return status;
	}

	// set status
	public void setStatus(int status) {
		this.status = status;
	}

}

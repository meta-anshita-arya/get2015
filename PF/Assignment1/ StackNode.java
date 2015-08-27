

public class StackNode {

	protected String data;
	protected StackNode link;

	public StackNode(String item) {
		this.data = item;
		link = null;
	}

	// return data
	public String getData() {
		return data;
	}

	// set data
	public void setData(String data) {
		this.data = data;
	}

	// return link
	public StackNode getLink() {
		return link;
	}

	// set link
	public void setLink(StackNode link) {
		this.link = link;
	}

}

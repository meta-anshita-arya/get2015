package ass1;

public class Title {
	private int titleId;
	private String titleName;
	private int subjectIdOfTitle;
	private int publisherIdOfTitle;

	// set detail of title table
	public Title(int titleId, String titleName, int subjectIdOfTitle,
			int publisherIdOfTitle) {
		this.titleId = titleId;
		this.titleName = titleName;
		this.subjectIdOfTitle = subjectIdOfTitle;
		this.publisherIdOfTitle = publisherIdOfTitle;
	}

	// get titleId
	public int getTitleId() {
		return titleId;
	}

	// set titleId
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	// get titleName
	public String getTitleName() {
		return titleName;
	}

	// set titleName
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	// get subjectIdOfTitle
	public int getSubjectIdOfTitle() {
		return subjectIdOfTitle;
	}

	// set subjectIdOfTitle
	public void setSubjectIdOfTitle(int subjectIdOfTitle) {
		this.subjectIdOfTitle = subjectIdOfTitle;
	}

	// get publisherIdOfTitle
	public int getPublisherIdOfTitle() {
		return publisherIdOfTitle;
	}

	// set publisherIdOfTitle
	public void setPublisherIdOfTitle(int publisherIdOfTitle) {
		this.publisherIdOfTitle = publisherIdOfTitle;
	}

}

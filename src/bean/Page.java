package bean;

public class Page {
	private int pageSize;
	private int pageNumber;

	public Page() {
		super();
	}

	public Page(int pageSize, int pageNumber) {
		super();
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

}

/**
 * 
 */
package bean;

/**
 * @author chengfan
 *
 */
public class PageObject {
	
	/**
	 * page num
	 */
	private Integer page ;
	/**
	 * page size
	 */
	private Integer pageSize;
	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}
	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public PageObject() {
		this.page = 1;
		this.pageSize = 10;
	}

	public PageObject(String page, String pageSize) {
		if (page == null || "".equals(page))
			page = "1";
		if (pageSize == null || "".equals(pageSize))
			pageSize = "10";
		this.pageSize = Integer.parseInt(pageSize);//页面大小
		this.page = (Integer.parseInt(page)-1) * Integer.parseInt(pageSize);//偏移量=（当前页面-1）*页面大小
	}
	

}

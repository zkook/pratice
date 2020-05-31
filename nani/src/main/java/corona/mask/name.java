package corona.mask;


import java.util.List;

/**
 * <pre>
 * corona.mask 
 * name.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : zkook
 * @version : v1.0
 */
public class name {
	private Integer count;
	private Integer page;
	private List<location> storeInfos;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		count = count;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		page = page;
	}
	public List<location> getStoreInfos() {
		return storeInfos;
	}
	public void setStoreInfos(List<location> storeInfos) {
		this.storeInfos = storeInfos;
	}
}

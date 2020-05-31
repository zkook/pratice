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
public class Name {
	private Integer count;
	private Integer page;
	private List<Location> storeInfos;
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
	public List<Location> getStoreInfos() {
		return storeInfos;
	}
	public void setStoreInfos(List<Location> storeInfos) {
		this.storeInfos = storeInfos;
	}
}

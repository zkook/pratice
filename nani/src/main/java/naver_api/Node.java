package naver_api; 


/**
 * <pre>
 * Linkedlist 
 * Node.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 7. 19.
 * @author : zkook
 * @version : v1.0
 */
public class Node {
	public int data;
	public Node next;

	public Node(int data) {
		this.data = data;
	}

	public void print() {
		System.out.print("{" + data + "}");
	}
}
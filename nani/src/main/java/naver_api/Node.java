package naver_api; 

/**
 * <pre>
 * kr.co.swh.lecture.datastructure
 * Node.java
 *
 * 설명 : 링크드리스트의 노드
 * </pre>
 * 
 * @since : 2017. 6. 29.
 * @author : tobby48
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
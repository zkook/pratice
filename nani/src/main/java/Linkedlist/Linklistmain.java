package Linkedlist;

/**
 * <pre>
 * naver_api 
 * Linklistmain.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 7. 19.
 * @author : zkook
 * @version : v1.0
 */
public class Linklistmain {
	public static void main(String[] args) {
		Linkedlist linkedList = new Linkedlist();
		linkedList.addLast(1);
		linkedList.addLast(2);
		linkedList.addLast(3);
		linkedList.addLast(4);
		linkedList.addLast(5);
		linkedList.add(2, 8);
		linkedList.delete(4);
		linkedList.addFirst(0);
		while(!linkedList.isEmpty()) {
			Node delLink = linkedList.deleteFirst();
			delLink.print();
			System.out.println();
		}
	}
}
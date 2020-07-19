package stack;

/**
 * <pre>
 * stack 
 * Q.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 6. 28.
 * @author : zkook
 * @version : v1.0
 */
public class Q {
	private final int MAX_SIZE = 50;//범위
	private int rear = -1;//시작
	private int front = 0;//끝
	private int Que[];//배열생성
	
	public Q(int size){
		Que = new int[size];//
	}
	public boolean full(){
		return (rear==(MAX_SIZE-1));//최대일때 리턴
	}
	public boolean empty(){
		return (rear==-1);//아무것도 없을때 리턴
		
	}
	public void push(int value){
		if(rear >= MAX_SIZE){//top이 멕스사이즈보다 클때 full리턴
			full();
			return;
		}
		Que[++rear] = value;//배열
		
	}
	public int pop(){
		if(rear == -1) return -1;//rear이 -1일때 리턴 -1
		return Que[rear--];//
	}
	
}

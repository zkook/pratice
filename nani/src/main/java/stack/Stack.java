package stack; 

/**
 * <pre>
 * stack 
 * Stack.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 6. 21.
 * @author : zkook
 * @version : v1.0
 */
public class Stack {
	private final int MAX_SIZE = 50;//범위
	private int top = -1;//순서지정
	private int stack[];//배열생성
	
	public Stack(int size){
		stack = new int[size];//
	}
	public boolean full(){
		return (top==(MAX_SIZE-1));//최대일때 리턴
	}
	public boolean empty(){
		return (top==-1);//아무것도 없을때 리턴
	}
	public void push(int value){
		if(top >= MAX_SIZE){//top이 멕스사이즈보다 클때 full리턴
			full();
			return;
		}
		stack[++top] = value;//배열
	}
	public int pop(){
		if(top == -1) return -1;//Top이 -1일때 리턴 -1
		return stack[top--];//
	}
}

/**
 * Author         :   _Suheng
 * Email          :   gesuheng@gmail.com
 * Last modified  :   2015-06-02 11:32
 * Filename       :   DoubleNode.java
 */
public class DoubleNode<T>{
	//data flied
	public T data;
	public DoubleNode<T> prev;
	public DoubleNode<T> next;

	//Constractor
	public DoubleNode(T data,DoubleNode<T> prev,DoubleNode<T> next){
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	public static void main(String[] args){
		System.out.println("Helo");	
	}
}

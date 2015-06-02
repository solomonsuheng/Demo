/**
 * Author         :   _Suheng
 * Email          :   gesuheng@gmail.com
 * Last modified  :   2015-06-02 10:48
 * Filename       :   Problem_2.java
 */

public class Problem_2{
	public static void main(String[] args){
		Integer[] num = {1,2,3,4,5,6,7,8};
		//single list
		Node<Integer> headNode = init(num);

		//Double list
		DoubleNode<Integer> doubleHeadNode = initDouble(num);
		printDoubleNode(doubleHeadNode);
		changeTheDoubleElement(doubleHeadNode,3);
		printDoubleNode(doubleHeadNode);

		printNode(headNode);
		changeTheElement(headNode,7);
		printNode(headNode);
	}

	//change the node
	public static void changeTheDoubleElement(DoubleNode<Integer> headNode,int idx){
		DoubleNode<Integer> temp = headNode;
		if(idx==0){
			return;
		}

		for(int i=0;i<idx;i++){
			temp = temp.next;
		}
		
		//swap
		DoubleNode tt = temp.prev;
		tt.next = temp.next;
		tt.prev.next = temp;
		temp.next = tt;
		tt.prev = temp;
	}
	
	//print double node
	public static void printDoubleNode(DoubleNode<Integer> headNode){
	
		if(headNode.data==0){
			return;
		}
		DoubleNode temp = headNode.next;
		while(temp!=null){
			System.out.print(temp.data+"<->");
			temp = temp.next;
		}
		System.out.println("null");


		DoubleNode t = headNode.next;
		while(t.next!=null){
			t = t.next;
		}

	}


	//init the double list 
	public static <T> DoubleNode initDouble(T[] num){
		DoubleNode<Integer> headNode = new DoubleNode<Integer>(0,null,null);//header
		DoubleNode temp = headNode;

		for(int i=0;i<num.length;i++){
			DoubleNode<Integer> newNode = new DoubleNode<Integer>((Integer)num[i],temp,null);
			headNode.data++;
			temp.next = newNode;
			temp = temp.next;
		}

		return headNode;
	}

	//Change the element 
	public static void changeTheElement(Node headNode,int idx){
		if(idx<0||idx>(Integer)headNode.data){
			return ;
		}
		Node temp = headNode;
		for(int i=1;i<idx;i++){
			temp = temp.next;	
		}	

		if(temp==null||temp.next==null||temp.next.next==null){
			//this is the last element of the list
			return;
		}	
		//swap between two element
		Node tempNext = temp.next;
		temp.next = temp.next.next;
		tempNext.next = temp.next.next;
		temp.next.next = tempNext;
	}

	//print the node list
	public static void printNode(Node<Integer> headNode){
		Node<Integer> temp = headNode.next;
		System.out.print("The list has " + headNode.data + " elements: ");
		
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.println("null");
	}		

	//init the node and return the list node with header
	public static <T> Node init(T[] num){
		if(num.length==0){
			//there is no element to add to the list
			return null;
		}
	

		Node<Integer> headNode = new Node<Integer>(0,null);
		Node tempPointer = headNode;
		for(int i=0;i<num.length;i++){
			Node<Integer> newNode = new Node<Integer>((Integer)num[i],null);
			headNode.data++;
			tempPointer.next = newNode;
			tempPointer = tempPointer.next;

		}
		return headNode;
	}
}

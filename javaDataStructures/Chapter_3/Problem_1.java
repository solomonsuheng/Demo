/**
 * Author         :   _Suheng
 * Email          :   gesuheng@gmail.com
 * Last modified  :   2015-06-02 10:03
 * Filename       :   Problem_1.java
 */
public class Problem_1{
	public static void main(String[] args){
		Integer[] num1 = {1,2,3,4,5,6,7,8,9};
		Integer[] num2 = {3,4,5,7,8};

		Node<Integer> list1 = init(num1);
		printNode(list1);
		Node<Integer> list2 = init(num2);
		printNode(list2);

		printLots(list1,list2);
		printNode(list1);
	}

	//print the element of L of fthe list2 point out	
	public static void printLots(Node<Integer> list1,Node<Integer> list2){
		if(list1.data==0||list2.data==0){
			return;
		}
		Node<Integer> tempL = list1;
		Node<Integer> tempP = list2;
		tempP = tempP.next;
		int nn = 0;
		while(tempP!=null){
			int point = tempP.data-nn;

			if(remove(tempL,point)){
				nn++;
				System.out.println("Delete ok");
			}
			tempP = tempP.next;
		}
		
	}

	//remove from the list
	public static boolean remove(Node headNode,int idx){
		if((Integer)headNode.data==0){
			return false;
		}
		boolean flag = false;
		Node temp = headNode;
		for(int i=1;i<idx;i++){
			temp = temp.next;
		}	
		temp.next = temp.next.next;
		flag = true;
		return flag;
	}
	//print the Node
	public static void printNode(Node headNode){
		if((Integer)(headNode.data)==0){
			//there is no element to print
			return;
		}
		//there at least one element
		Node temp = headNode.next;
		System.out.print("List has "+(Integer)headNode.data+" elements: ");
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp = temp.next;
		}	
		System.out.println("null");
	}
	
	//init the node by give array
	public static <T> Node  init(T[] num){
		Node<Integer> headNode = new Node<Integer>(0,null);
		
		Node tempNode = headNode;
		for(int i=0;i<num.length;i++){
			Node<Integer> newNode = new Node<Integer>((Integer)num[i],null);
			headNode.data++;
			tempNode.next = newNode;
			tempNode = tempNode.next;
		}
		return headNode;
	} 
}

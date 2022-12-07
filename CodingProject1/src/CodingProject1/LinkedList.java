package CodingProject1;

/**
 * Represents the Linked List Object.
 * 
 * 
 * @author thenry04
 * @version Fall 2019
 */
public class LinkedList {

	Node head = null, rear = null;
	int count = 0;
	
	/**
     * Inner Class for the Nodes of the LinkedList Object.
     */
	public class Node {
		 char elem;
		 Node next = null;
		 public Node(char theElem) {
			 this.elem = theElem;
		 }
	 }
	 
	/**
     * Takes in theElem and adds a new node to the rear of the LL with the theElem as its value.
     * 
     * @param TheElem
     */
     public void addRear(char theElem) {
    	 Node temp = new Node(theElem);
    	 
    	 if(head == null) {
    		 head = rear = temp;
    	 } else {
    		 rear.next = temp;
    		 rear = temp;
    	 }
    	 count++;
     }
	 
     /**
      * Takes in theElem and adds a new node to the front of the LL with the theElem as its value.
      * 
      * @param TheElem
      */
	 public void addFront(char theElem) {
		 Node temp = new Node(theElem);
		 
		 if(head == null) {
			 head =  temp;
		 } else {
			temp.next = head;
			head = temp;
		 }
		 
		 count++;
	 }
	 
	 /**
      * Returns the size of the LL.
      * 
      * @return Size of LL
      */
	 public int size() {
		 return count;
	 }
	 
	 @Override
	 /**
      * Returns a string representation of the LL.
      * 
      * @return LL as String
      */
	 public String toString() {
		 final StringBuilder sb = new StringBuilder();
		 String arrow = " -> ";
		 Node curr = head;
		 
		 while(curr != null) {
			 sb.append(curr.elem);
			 if(curr.next != null) {
			     sb.append(arrow);
			 }
			 curr = curr.next;
		 }
		 
		 return sb.toString(); 
	 }
	 
}

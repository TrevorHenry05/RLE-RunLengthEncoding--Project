package CodingProject1;

import java.util.Arrays;
import java.util.NoSuchElementException;

import CodingProject1.LinkedList.Node;

/**
 * Represent the Run Length Encoding methods for the driver Program.
 * 
 * @author thenry04
 * @version Fall 2019
 */
public class RLE { 

	/**
     * Takes in a string and creates a LL representation and encodes it, then returns string representation of the Linked list
     * + Encoded String + Compression Ratio.
     * 
     * @param theString
     * @return String representation of linked list + Encoded String + Compression Ratio.
     */    
	public String encode(String theString) {
		
		final StringBuilder sb1 = new StringBuilder();
		final StringBuilder sb2 =  new StringBuilder();		
        LinkedList temp = new LinkedList();
		
		for(int i = 0; i < theString.length(); i++) {
			temp.addRear(theString.charAt(i));
		}
		
		int count = 0, encodeLength;
		char currElem;
		Node curr = temp.head;	

		if(curr == null) {
			throw new NoSuchElementException("linked List is empty");
		} else {
			currElem = curr.elem;
			count++;
		}
				
		while (curr.next != null) {
			char x = curr.next.elem;
			
			if(x == currElem) {
			    count++;
			    curr = curr.next;
		    } else {
			    sb1.append(count);
			    sb1.append(currElem);
			    curr = curr.next;
                currElem = curr.elem;
			    count = 1;
		    }
		}

		sb1.append(count);
	    sb1.append(currElem);
		
	    encodeLength = sb1.length();
		
		sb2.append('[');
		sb2.append(temp.toString());
		sb2.append(':');
		sb2.append(temp.count);
		sb2.append("] [");
		sb2.append(sb1.toString());
		sb2.append(':');
		sb2.append(encodeLength);
		sb2.append("] [");
		sb2.append(((double) temp.count / (double) encodeLength));
		sb2.append(']');		
		
        return sb2.toString();
	}
	
	/**
     * Takes in a Encoded string representation of a LL and converts to a Linked List.
     * 
     * @param theString
     * @return String representation of the Original Encoded string and the Decoded LL.
     */  
	public String decode(String theString) {
		LinkedList temp = new LinkedList();
		final StringBuilder sb = new StringBuilder();
		int num = 0;
		char c;
		
		
		for(int i = 0; i < theString.length(); i++) {
            if(Character.isDigit(theString.charAt(i))) {
            	while(Character.isDigit(theString.charAt(i))) {
            		num = num * 10 + theString.charAt(i) - '0';
            		i++;
            	}
            	c = theString.charAt(i);
            	
            	while(num > 0) {
				    temp.addRear(c);
				    num--;
			    }
            	
            } 

		}
		
		sb.append('[');
		sb.append(theString);
		sb.append("] [");
		sb.append(temp.toString());
		sb.append(']');
		
        return sb.toString();
	}
	
	/**
     * Takes in two Encoded Linked List and test for equality of the Linked List.
     * 
     * @param theList1
     * @param theList2
     * @return String representation of the two Encoded LL + Equality Result.
     */  
	public boolean equal(String theList1, String theList2) {
		final StringBuilder sb1 = new StringBuilder();
		final StringBuilder sb2 = new StringBuilder();
		boolean result = false;
        int num = 0;
		String str1, str2;
		
		
		for(int i = 0; i < theList1.length(); i++) {
            if(Character.isDigit(theList1.charAt(i))) {
            	while(Character.isDigit(theList1.charAt(i))) {
            		num = num * 10 + theList1.charAt(i) - '0';
            		i++;
            	}
            	char c = theList1.charAt(i);
            	
            	while(num > 0) {
				    sb1.append(c);
				    num--;
			    }
            	
            } 

		}
		
		num = 0;
		
		for(int i = 0; i < theList2.length(); i++) {
            if(Character.isDigit(theList2.charAt(i))) {
            	while(Character.isDigit(theList2.charAt(i))) {
            		num = num * 10 + theList2.charAt(i) - '0';
            		i++;
            	}
            	char c = theList2.charAt(i);
            	
            	while(num > 0) {
				    sb2.append(c);
				    num--;
			    }
            	
            } 

		}

		char[] arr1 = sb1.toString().toCharArray();
        char[] arr2 = sb2.toString().toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        str1 = new String(arr1);
        str2 = new String(arr2);
        
        
        if(str1.equals(str2)) {
        	result = true;
        }
	
		
		return result;
	}
	
	
	
}

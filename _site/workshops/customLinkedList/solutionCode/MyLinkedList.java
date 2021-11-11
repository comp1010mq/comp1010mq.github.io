public class MyLinkedList {
	private Node head;


	public boolean isEmpty() {
		return head==null;
	}
	
	public void addToFront(int item) {
		Node nodeToAdd = new Node(item, null);
		if(head == null)
			head = nodeToAdd;
		else {
			nodeToAdd.setNext(head); //link nodeToAdd to head
			head = nodeToAdd; //update head to point to newly added node
		}
	}

	public void addToBack(int item) {
		Node nodeToAdd = new Node(item, null);
		if(head == null) 
			head = nodeToAdd;
		else {
			Node cur = head;
			while(cur.getNext() != null) {
				cur = cur.getNext();
			}
			//now cur refers to the last node in the list
			cur.setNext(nodeToAdd);
		}
	}

	public int size() {
		Node cur = head;
		int counter = 0;
		while(cur != null) {
			//another non-null node
			counter++;
			cur = cur.getNext();
		}
		return counter;
	}

	public boolean isValidIndex(int idx) {
		return idx >= 0 && idx < size();
	}

	//add item at index supplied
	public void add(int item, int idx) {
		if(idx < 0 || idx > size())
			return;
		Node nodeToAdd = new Node(item, null);

		if(head == null) {
			head = nodeToAdd;
			return;
		}

		if(idx == 0) { //add to front
			addToFront(item);
			return;
		}

		Node cur = head;
		for(int i=1; i < idx; i++) {
			cur = cur.getNext();
		}
		nodeToAdd.setNext(cur.getNext());
		cur.setNext(nodeToAdd);
	}

	//remove item from index supplied
	public void remove(int idx) {
		if(idx < 0 || idx >= size())
			return;
		if(idx == 0) {
			head = head.getNext();
			return;
		}
		Node cur = head;
		for(int i=1; i < idx; i++) {
			cur = cur.getNext();
		}
		//cur refers to node before the node to be removed
		cur.setNext(cur.getNext().getNext());
	}

	//get item at index supplied
	public Integer get(int idx) {
		if(idx < 0 || idx >= size())
			return null;
		Node cur = head;
		for(int i=0; i < idx; i++) {
			cur = cur.getNext();
		}
		return cur.getData();
	}

	public String toString() {
		if(head == null)
			return "[]";
		String result = "[";
		Node cur = head;
		while(cur!=null) {
			result = result + cur.getData() + ", ";
			cur = cur.getNext();
		}
		result = result.substring(0, result.length()-2); //to remove the last ", "
		return result + "]";
	}

	/**
	 * @return the number of items more than the passed value
	 */
	public int countItemsMoreThan(int minValue) {
		int count = 0;
		Node cur = head;
		while(cur != null) {
			if(cur.getData() > minValue) {
				count++;
			}
			cur = cur.getNext();
		}
		return count;
	}

	/**
	 * @return the median index. 
	 * Return k if there are 2*k or 2*k+1 items.
	 * think of methods you already have that will help you 
	*/
	public int getMedianIndex() {
		return size()/2; //YUPP!
	}

	//remove the first occurrence of passed item from the list
	public void removeFirstOccurrence(int item) {
		Node last = head;
		Node cur = head;
		while(cur != null && cur.getData() != item) {
			last = cur;
			cur = cur.getNext();
		}
		if(cur != null) { //got one :)
			last.setNext(cur.getNext());
		}
	}

	//remove all occurrences of passed item from the list
	public void removeAllOccurrences(int item) {
		while(head!= null && head.getData() == item) {
			head = head.getNext();
		}
		
		Node last = head;
		Node cur = head;
		
		while(cur != null) {
			while(cur != null && cur.getData() != item) {
				last = cur;
				cur = cur.getNext();
			}
			if(cur != null) { //got one :)
				last.setNext(cur.getNext());
			}
			cur = cur.getNext();
		}
	}

	/**
	 * For this method, assume that each item in the list
	 * is a single digit item (that is either 0 or 1 or ... 9).
	 * @return true if the list contains all digits, false otherwise
	 */
	public boolean containsAllDigits() {
		boolean[] check = new boolean[10];
		int remainingCount = 10;

		Node cur = head;
		while(cur != null && remainingCount > 0) {
			if(check[cur.getData()] == false) {
				remainingCount--;
				check[cur.getData()] = true;
			}
		}
		return remainingCount == 0;
	}

	/**
	 * For this method, assume that each item in the calling 
	 * object and the parameter object
	 * is a single digit item (that is either 0 or 1 or ... 9).
	 * thus the list itself represent a single arbirary-length
	 * integer.
	 * you may assume that both calling object and passed
	 * object represent positive integers (integers > 0)
	 * @return a list that represents an integer that is the sum
	 * of the integer held by calling object and that held by
	 * parameter object.
	 * For example, 
	 * this.head  -> 9 -> 5 -> 0 -> 3 -> null (9503) 
	 * other.head -> 6 -> 9 -> 9 -> null (699)
	 * return list such that
	 * list.head -> 1 -> 0 -> 2 -> 0 -> 2 -> null (9503+699 = 10202)
	 */
	public MyLinkedList add(MyLinkedList other) {
		MyLinkedList result = new MyLinkedList();
		int idx1 = this.size()-1;
		int idx2 = other.size()-1;
		int carry = 0;
		while(idx1 >= 0 && idx2 >= 0) {
			int sumDigits = get(idx1) + other.get(idx2) + carry;
			result.addToFront(sumDigits%10);
			carry = sumDigits/10;
			idx1--;
			idx2--;
		}
		while(idx1 >= 0) {
			int sumDigitCarry = get(idx1) + carry;
			result.addToFront(sumDigitCarry%10);
			carry = sumDigitCarry/10;
			idx1--;
		}
		while(idx2 >= 0) {
			int sumDigitCarry = other.get(idx2) + carry;
			result.addToFront(sumDigitCarry%10);
			carry = sumDigitCarry/10;
			idx2--;
		}
		if(carry != 0) {
			result.addToFront(carry);
		}
		return result;
	}
}

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

	//add item at the back of the list
	public void add(int item) {
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
		return 0; //to be completed
	}

	/**
	 * @return the median index. 
	 * Return k if there are 2*k or 2*k+1 items.
	 * think of methods you already have that will help you 
	*/
	public int getMedianIndex() {
		return 0; //to be completed
	}

	//remove the first occurrence of passed item from the list
	public void removeFirstOccurrence(int item) {
		//to be completed
	}

	//remove all occurrences of passed item from the list
	public void removeAllOccurrences(int item) {
		//to be completed
	}

	/**
	 * For this method, assume that each item in the list
	 * is a single digit item (that is either 0 or 1 or ... 9).
	 * @return true if the list contains all digits, false otherwise
	 */
	public boolean containsAllDigits() {
		return false; //to be completed
	}

	/**
	 * For this method, assume that each item in the calling 
	 * object and the parameter object
	 * is a single digit item (that is either 0 or 1 or ... 9).
	 * thus the list itself represent a single arbirary-length
	 * integer.
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
		return null; //to be completed
	}
}

public class Node {
	private int data;
	private Node next;
	
	public int getData() {
		return data;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node() {
		setData(0);
		setNext(null);
	}

	public Node(int data) {
		setData(data);
		setNext(null);
	}
	
	public Node(int data, Node node) {
		setData(data);
		setNext(node);
	}
}

class Node {
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
	
	public Node(int data, Node node) {
		setData(data);
		setNext(node);
	}
}

public class NodeStorage {
	public static void main(String[] args) {
		Node p = new Node(20, null);
		Node g = new Node(50, null);
		Node a = new Node(70, p);
		Node y = new Node(30, null);
		g.setNext(y);
		p.setNext(g);
		y.setData(10);
		p.getNext().getNext().setData(90);
	}
}

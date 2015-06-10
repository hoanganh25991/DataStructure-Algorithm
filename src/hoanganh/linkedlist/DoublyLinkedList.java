package hoanganh.linkedlist;

public class DoublyLinkedList {
	private Link first;
	private int numElems;

	public DoublyLinkedList() {

		first = null;
		numElems = 0;
	}

	public void insert(int newValue) {
		Link newLink = new Link(newValue);
		newLink.setPrevious(first);
		if (numElems != 0) {
			first.setNext(newLink);
		}
		first = newLink;
		numElems++;
	}

	public void disPlay() {
		Link current = first;
		do {
			System.out.printf("a[%d] = %d", --numElems, current.getValue());
			current = current.getPrevious();
			System.out.println();
		} while (current != null);
	}
}

class Link {
	private int value;
	private Link previous;
	private Link next;

	Link(int value) {
		this.value = value;
	}

	public Link getPrevious() {
		return previous;
	}

	public void setPrevious(Link previous) {
		this.previous = previous;
	}

	public Link getNext() {
		return next;
	}

	public void setNext(Link next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}

}

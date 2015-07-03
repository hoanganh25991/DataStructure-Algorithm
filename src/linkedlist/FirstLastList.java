package linkedlist;

public class FirstLastList {
	public Link mFirst;
	public Link mLast;
	public int numElems;

	public FirstLastList() {
		mFirst = null;
		mLast = null;
		numElems = 0;
	}

	public void insertFirst(int v) {
		Link newLink = new Link(v);
		newLink.next = mFirst;
		mFirst = newLink;
		if (numElems == 0) {
			mLast = newLink;
		}
		numElems++;
	}

	public void insertLast(int v) {
		Link newLink = new Link(v);
		
		if (numElems == 0) {
			newLink.next = mFirst;
			mFirst = newLink;			
		} else {
			mLast.next = newLink;
			newLink.next = null;			
		}
		mLast = newLink;
		numElems++;
	}

	public void disPlay() {
		Link current = mFirst;
		int index = numElems;
		while (current != null) {
			System.out.printf("a[%d] = %d", --index, current.value);
			System.out.println();
			current = current.next;
		}
	}
}

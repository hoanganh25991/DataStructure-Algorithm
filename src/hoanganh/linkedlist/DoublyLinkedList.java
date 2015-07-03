package hoanganh.linkedlist;

public class DoublyLinkedList {
	public LinkNextPrevious mFirst;
	public LinkNextPrevious mLast;
	public int numElems;

	public DoublyLinkedList() {
		numElems = 0;
		mFirst = null;
		mLast = null;
	}

	public void insertFirst(int v) {
		LinkNextPrevious newLink = new LinkNextPrevious(v);

		if (numElems == 0) {
			newLink.previous = mFirst;
			newLink.next = null;
			mFirst = newLink;
			mLast = newLink;
		} else {
			mFirst.next = newLink;
			newLink.previous = mFirst;
			newLink.next = null;
			mFirst = newLink;
		}
		numElems++;
	}

	public void insertLast(int v) {
		LinkNextPrevious newLink = new LinkNextPrevious(v);

		if (numElems == 0) {
			newLink.previous = mFirst;
			newLink.next = null;
			mFirst = newLink;
		} else {
			newLink.previous = null;
			newLink.next = mLast;
			mLast.previous = newLink;
		}
		mLast = newLink;
		numElems++;
	}

	public void find(int v) {
		LinkNextPrevious current = mFirst;
		int index = numElems;
		while (current != null) {
			--index;
			if (current.value == v) {
				System.out.printf("a[%d] = %d", index, current.value);
				System.out.println();
				break;
			}
			current = current.previous;
		}
		if (current == null) {
			System.out.println("could not find  " + v);
		}
	}

	public void disPlay() {
		LinkNextPrevious current = mFirst;
		int index = numElems; // numElems is variable to count, should not
								// modify it
		while (current != null) {
			System.out.printf("a[%d] = %d", --index, current.value);
			System.out.println();
			current = current.previous;
		}
	}

}

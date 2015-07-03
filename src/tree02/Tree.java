package tree02;

public class Tree {
	Node root;
	String onelineString;

	public Tree() {
		root = null;
	}

	public boolean insert(int value) {
		Node newNode = new Node(value);
		Node current = root;
		Node parent = null;
		if (root == null) {
			// case 1: root chua co
			root = newNode;
			return true; // NullPointerException when run code at [1], escape when DONE case 1;
		} else {
			// case 2: root da co
			do {
				parent = current;
				if (Node.compare(current, newNode) > 0) {
					current = current.leftChild;
				} else if (Node.compare(current, newNode) < 0) {
					current = current.rightChild;
				} else {
					System.out.println(newNode + " already exists");
					return false;
				}
			} while (current != null);
		}
		// [1]
		if (Node.compare(parent, newNode) > 0) {
			parent.leftChild = newNode;
		} else {
			parent.rightChild = newNode;
		}
		return true;
	}

	public boolean insert(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			insert(numbers[i]);
		}
		return true;
	}

	public boolean find(int value) {
		Node current = root;
		while (current != null) {
			if (current.iData == value) {
				return true;
			} else if (current.iData > value) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
		}
		return false;
	}

	public void traverseInorder(Node startNode) {
		if (startNode != null) {
			traverseInorder(startNode.leftChild);
			onelineString += startNode + " ";
			traverseInorder(startNode.rightChild);
		} else {

		}
	}

	public void traversePostorder(Node startNode) {
		if (startNode != null) {
			traverseInorder(startNode.rightChild);		
			traverseInorder(startNode.leftChild);
			
			onelineString += startNode + " ";
		} else {

		}
	}

	public void displayOnelineInorder() {
		onelineString = "";
		traverseInorder(root);
		System.out.println(onelineString);
	}

	public void displayOnelinePostorder() {
		onelineString = "";
		traversePostorder(root);
		System.out.println(onelineString);
	}
}

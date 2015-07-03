package hoanganh.tree;

public class Tree {
	private Node root;
	private int numNode;
	private int layer;

	Tree() {
		numNode = 0;
		layer = 0;
	}

	Node getRoot() {
		return root;
	}

	Node find(int key) {
		Node current = root;
		while (current.value != key) {
			if (key < current.value) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
			if (current == null) {
				return null;
			}
		}
		return current;
	}

	void insert(int v) {
		Node newNode = new Node(v);
		numNode++;
		if (root == null) {
			root = newNode;
			layer++;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current; // remember node, b/c finally, current =
									// current.left/right -> null
				if (v < current.value) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						if (parent.rightChild == null) {
							layer++;
						}
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						if (parent.leftChild == null) {
							layer++;
						}
						return;
					}
				}
			}
		}
	}

	boolean delete(int id) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;

		while (current.value != id) {
			parent = current;
			if (id < current.value) {
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null) {
				return false;
			}
		}
		//
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		} else if (current.rightChild == null) {
			if (current == root) {
				root = current.leftChild;
			} else if (isLeftChild) {
				parent.leftChild = current.leftChild;
			} else {
				parent.rightChild = current.rightChild;
			}
		} else if (current.leftChild == null) {
			if (current == root) {
				root = current.rightChild;
			} else if (isLeftChild) {
				parent.leftChild = current.leftChild;
			} else {
				parent.rightChild = current.rightChild;
			}
		} else {
			Node successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.rightChild = successor;
				successor.leftChild = current.leftChild;
			} else {

			}
		}
		numNode--;
		return true;
	}

	Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild; // go to left child
		}
		if (successor != delNode.rightChild) {// if successor not right child,
												// make connections
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}

	void travel(Node localRoot) {
		if (localRoot != null) {
			travel(localRoot.leftChild);
			System.out.print(localRoot.value + " ");
			travel(localRoot.rightChild);
			// System.out.print(localRoot.value + " ");
			if (localRoot == maximum()) {
				System.out.println();
			}
		}
	}

	Node minimum() {
		Node current = root;
		Node last = null;
		while (current != null) {
			last = current; // remeber node
			current = current.leftChild;
		}
		return last;
	}

	Node maximum() {
		Node current = root;
		Node last = null;
		while (current != null) {
			last = current;
			current = current.rightChild;
		}
		return last;
	}

	void displayTree() {
		int size = (int) Math.pow(2, layer);
		System.out.println("num of layer: " + layer);
		Stack globalStack = new Stack(size);
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		while (!isRowEmpty) {
			Stack localStack = new Stack(size);
			isRowEmpty = true;
			for (int j = 0; j < nBlanks; j++)
				System.out.print(" ");
			while (!globalStack.isEmpty()) {
				Node temp = globalStack.pop();
				if (temp != null) {
					System.out.print(temp.value);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if (temp.leftChild != null || temp.rightChild != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks * 2 - 2; j++)
					System.out.print(" ");
			} // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		} // end while isRowEmpty is false

	}

}

class Node {
	int value;
	Node leftChild;
	Node rightChild;

	Node(int v) {
		value = v;
	}
}

class Stack {
	private int maxSize;
	public int top;
	private Node[] value;

	public Stack(int size) {
		// TODO Auto-generated constructor stub
		maxSize = size;
		value = new Node[maxSize];
		top = -1;
	}

	public void push(Node ch) {
		value[++top] = ch;
	}

	public Node pop() {
		return value[top--];
	}

	public Node peek() {
		return value[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == maxSize;
	}

}

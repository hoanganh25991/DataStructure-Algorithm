package tree03;

public class Tree03 {
	Node03 root;
	int size;
	int layer;

	public Tree03() {
		root = null;
		size = 0;
		layer = 0;
	}

	public boolean insert(double value) {
		Node03 newNode = new Node03(value);
		if (root == null) {
			root = newNode;
			return true;
		}
		Node03 current = root;
		Node03 parent = null;
		while (current != null) {
			parent = current;
			if (current.equal(newNode)) {
				System.out.println(value + " already exists");
				return false;
			} else if (current.mData > value) {
				current = current.left;
			} else if (current.mData < value) {
				current = current.right;
			}
		}

		if (parent.mData < value) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		}
		return true;
	}

	public Node03 find(double value) {
		Node03 newNode = new Node03(value);
		if (root == null) {
			return null;
		}
		Node03 current = root;
		while (current != null) {
			if (current.equal(newNode)) {
				return current;
			}
			if (current.mData > value) {
				current = current.left;
			}
			if (current.mData < value) {
				current = current.right;
			}
		}
		return null;
	}

	public void display() {
		travel(root);
	}

	public void travel(Node03 start) {
		if (start == null) {
			return;
		} else {
			travel(start.left);
			System.out.println(start);
			travel(start.right);
		}
	}

	public void insert(double[] a) {
		for (int i = 0; i < a.length; i++) {
			insert(a[i]);
		}

	}

	public boolean deleteCase1(double value) {
		// case 1: it is a leaf
		Node03 deleteparent = findparent(value);
		System.out.println("delete parent " + deleteparent);
		if (value < deleteparent.mData) {
			deleteparent.left = null;
		} else {
			deleteparent.right = null;
		}
		return true;
	}

	public boolean delete(double value) {
		Node03 deleteNode = find(value);
		if (deleteNode != null) {
			// case 1: deleteNode has no children
			if (deleteNode == nearValue(deleteNode)) {
				Node03 deleteNodeParent = findparent(value);
				System.out.println("delete node parent:  " + deleteNodeParent);
				if (value < deleteNodeParent.mData) {
					deleteNodeParent.left = null;
				} else {
					deleteNodeParent.right = null;
				}
			} else {
				// con thieu gan node la xong
				double value1 = nearValue(deleteNode).mData;
				Node03 deleteNodeParent = findparent(deleteNode.mData);
				if (deleteNode == deleteNodeParent.left) {
					deleteNodeParent.left = nearValue(deleteNode);
				} else {
					deleteNodeParent.right = nearValue(deleteNode);
				}
				delete(value1);
			}
			return true;
		} else {
			return false;
		}
	}

	public Node03 findparent(double value) {
		if (root == null) {
			return null;
		} else if (root.mData == value) {
			System.out.println("delete root");
			return root;
		} else {
			Node03 parent = root;
			Node03 current = parent;
			while (current.mData != value && current != null) {
				if (current.mData > value) {
					parent = current;
					current = current.left;

				}
				if (current.mData < value) {
					parent = current;
					current = current.right;
				}
			}
			return parent;

		}
	}

	public Node03 nearValue(Node03 startNode) {
		// start find on left
		if (startNode.left != null) {
			return findOnRight(startNode.left);
		} else if (startNode.right != null) {
			// start find on right
			return findOnLeft(startNode.right);
		} else {
			// this is a leaf
			return startNode;
		}
	}

	public Node03 findOnRight(Node03 current) {
		Node03 parent = null;
		while (current != null) {
			parent = current;
			current = current.right;
		}
		return parent;
	}

	public Node03 findOnLeft(Node03 current) {
		Node03 parent = null;
		while (current != null) {
			parent = current;
			current = current.left;
		}
		return parent;
	}
}

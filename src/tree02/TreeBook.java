// tree.java
// demonstrates binary tree
// to run this program: C>java TreeApp
package tree02;

// for Stack class
////////////////////////////////////////////////////////////////

class NodeBook {
	public int iData; // data item (key)
	public double dData; // data item
	public NodeBook leftChild; // this node’s left child
	public NodeBook rightChild; // this node’s right child

	public void displayNode() // display ourself
	{
		System.out.print("{");
		System.out.print(iData);
		System.out.print(",");
		System.out.print(dData);
		System.out.print("}");
	}
} // end class Node
// //////////////////////////////////////////////////////////////

class TreeBook {
	private NodeBook root; // first node of tree

	// -------------------------------------------------------------

	public TreeBook() // constructor
	{
		root = null;
	} // no nodes in tree yet
		// -------------------------------------------------------------

	public NodeBook find(int key) // find node with given key
	{ // (assumes non-empty tree)
		NodeBook current = root; // start at root
		while (current.iData != key) // while no match,
		{
			if (key < current.iData) // go left?
				current = current.leftChild;
			else
				// or go right?
				current = current.rightChild;
			if (current == null) // if no child,
				return null; // didn’t find it
		}
		return current; // found it
	} // end find()
		// -------------------------------------------------------------

	public void insert(int id, double dd) {
		NodeBook newNode = new NodeBook(); // make new node
		newNode.iData = id; // insert data
		newNode.dData = dd;
		if (root == null) // no node in root
			root = newNode;
		else // root occupied
		{
			NodeBook current = root; // start at root
			NodeBook parent;
			while (true) // (exits internally)
			{
				parent = current;
				if (id < current.iData) // go left?
				{
					current = current.leftChild;
					if (current == null) // if end of the line,
					{ // insert on left
						parent.leftChild = newNode;
						return;
					}
				} // end if go left
				else // or go right?
				{
					current = current.rightChild;
					if (current == null) // if end of the line
					{ // insert on right
						parent.rightChild = newNode;
						return;
					}
				} // end else go right
			} // end while
		} // end else not root
	} // end insert()
		// -------------------------------------------------------------

	public boolean delete(int key) // delete node with given key
	{ // (assumes non-empty list)
		NodeBook current = root;
		NodeBook parent = root;
		boolean isLeftChild = true;
		while (current.iData != key) // search for node
		{
			parent = current;
			if (key < current.iData) // go left?
			{
				isLeftChild = true;
				current = current.leftChild;
			} else // or go right?
			{
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null) // end of the line,
				return false; // didn’t find it
		} // end while
			// found node to delete
			// if no children, simply delete it
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root) // if root,
				root = null; // tree is empty
			else if (isLeftChild)
				parent.leftChild = null; // disconnect
			else
				// from parent
				parent.rightChild = null;
		}
		// if no right child, replace with left subtree
		else if (current.rightChild == null)
			if (current == root)
				root = current.leftChild;
			else if (isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		// if no left child, replace with right subtree
		else if (current.leftChild == null)
			if (current == root)
				root = current.rightChild;
			else if (isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
		return false;
		// two children, so replace with inorder successor
		// {
		// // get successor of node to delete (current)
		// // Node successor = getSuccessor(current);
		// // connect parent of current to successor instead
		// if (current == root)
		// root = successor;
		// else if (isLeftChild)
		// parent.leftChild = successor;
		// else
		// parent.rightChild = successor;
		// // connect successor to current’s left child
		// successor.leftChild = current.leftChild;
		// } // end else two children
		// // (successor cannot have a left child)
		// // {
		// // String s = getString();
		// // return Integer.parseInt(s);
		// // }
		// -------------------------------------------------------------
	} // end class TreeApp
		// //////////////////////////////////////////////////////////////
}

package tree04;

import java.util.ArrayList;

public class mytree {
	mynode root;
	int num;
	int layer;
	mynode parent;

	public mytree() {
		root = null;
		num = 0;
		layer = 0;
		parent = null;
	}

	public boolean insert(int value) {
		mynode current = root;
		mynode parent = null;
		if (root == null) {
			root = new mynode(value);
			return true;
		}
		while (current != null) {
			parent = current;
			if (current.mdata == value) {
				System.out.println(value + " already exists");
				return false;
			} else if (current.mdata > value) {
				current = current.left;

			} else {
				current = current.right;
			}
		}
		if (parent.mdata > value) {
			parent.left = new mynode(value);
		} else {
			parent.right = new mynode(value);
		}
		num++;// increase number of elements
		return true;
	}

	public mynode find(int value) {
		mynode current = root;
		if (root.mdata == value) {
			parent = null;
			return root;
		}
		while (current != null) {
			if (current.mdata == value) {
				// parent = current; // save current right before it changes
				return current;
			} else if (current.mdata > value) {
				parent = current; // save current right before it goes deep
				current = current.left;
			} else {
				parent = current; // save current right before it goes deep
				current = current.right;
			}
		}
		return null;
	}

	public boolean delete(int value) {
		mynode deletenode = find(value);
		mynode parentdelete = parent;
		ArrayList<mynode> stacknode = new ArrayList<mynode>();
		ArrayList<Integer> stackvalue = new ArrayList<Integer>();
		if (deletenode == null) {
			return false;
		} else {
			// case 1: has no child
			if (deletenode.left == null && deletenode.right == null) {
				System.out.println("case 1");
				if (parentdelete == null) {
					// root case
					root = null;
				} else {
					if (parentdelete.mdata > deletenode.mdata) {
						// delete node by set parent link to it 'null'
						parentdelete.left = null;
					} else {
						parentdelete.right = null;
					}
				}
			} else if (deletenode.left != null || deletenode.right != null) {
				// case 2: has one child
				mynode nearnode = nearnode(deletenode);
				if (parentdelete == null) {
					stacknode.add(root);
					stackvalue.add(nearnode.mdata);
					delete(nearnode.mdata);
				} else {
					if (parentdelete.mdata > deletenode.mdata) {
						// delete node by set parent link to it 'null'
						// change parentdelete.left to nearnode
						parentdelete.left = nearnode;
					} else {
						parentdelete.right = nearnode;
					}
				}
			} else {
				// case 3: has two children
				mynode nearnode = nearnode(deletenode);
				stacknode.add(deletenode);
				stackvalue.add(nearnode.mdata);
				delete(nearnode.mdata);
			}
			// after chaineling delete, replace value
			for (int i = stacknode.size() - 1; i > -1; i--) {
				stacknode.get(i).mdata = stackvalue.get(i);
			}
			num--; // decrease number of elements
			return true;
		}

	}

	public mynode nearnode(mynode startnode) {
		if (startnode.left != null) {
			mynode current = startnode.left;
			mynode parent = null;
			while (current != null) {
				parent = current;
				current = current.right;
			}
			return parent;
		} else if (startnode.right != null) {
			mynode current = startnode.right;
			mynode parent = null;
			while (current != null) {
				parent = current;
				current = current.left;
			}
			return parent;
		} else {
			return startnode;// case startnode has no child
		}
	}

	private void travel(mynode start) {
		if (start == null) {
			return;
		} else {
			travel(start.left);
			System.out.print(start + " ");
			travel(start.right);
		}
	}

	public void display() {
		travel(root);
		System.out.println();
	}
}

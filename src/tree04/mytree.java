package tree04;

import java.util.ArrayList;

public class mytree {
	mynode root;
	int num;
	int layer;

	public mytree() {
		root = null;
		num = 0;
		layer = 0;
	}

	public boolean insert(int value) {
		int currentlayer = 0;
		mynode current = root;
		mynode parent = null;
		if (root == null) {
			root = new mynode(value);
			num++;
			currentlayer++;
			if (currentlayer > layer) {
				layer = currentlayer;
			}
			return true;
		}
		while (current != null) {
			parent = current;
			if (current.mdata == value) {
				return false;
			} else if (current.mdata > value) {
				current = current.left;

			} else {
				current = current.right;
			}
			currentlayer++;
		}
		if (parent.mdata > value) {
			parent.left = new mynode(value);
			if (parent.right == null) {
				currentlayer++;
			}
		} else {
			parent.right = new mynode(value);
			if (parent.left == null) {
				currentlayer++;
			}
		}
		num++;// increase number of elements
		if (currentlayer > layer) {
			System.out.println("insert " + value + "; current layer "
					+ currentlayer);
			layer = currentlayer;
			System.out.println("layer: " + layer);
		} else {
			System.out.println("insert " + value + ";layer: " + layer);
		}
		return true;
	}

	public mynode find(int value) {
		mynode current = root;
		while (current != null) {
			if (current.mdata == value) {
				// [WRONG] parent = current
				return current;
			} else if (current.mdata > value) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return null;
	}

	public boolean delete(int value) {
		final parentsave p = findparentsave(value);
		final mynode deletenode = p.deletenode;
		final mynode parentdelete = p.parentdelete;// using private class,
													// findSaveParent() to
		// return object has both 'delete node'
		// and 'its parent'
		final ArrayList<mynode> stacknode = new ArrayList<mynode>();
		final ArrayList<Integer> stackvalue = new ArrayList<Integer>();
		if (deletenode == null) {
			return false;
		} else {
			if (deletenode.left == null && deletenode.right == null) {
				// case 1: has no child
				System.out.println("// case 1: has no child");
				if (parentdelete == null) {
					// root case
					System.out.println("root case");
					root = null;
					num--; // decrease number of elements
				} else {
					if (parentdelete.mdata > deletenode.mdata) {
						// delete node by set parent link to it 'null'
						parentdelete.left = null;
					} else {
						parentdelete.right = null;
					}
					num--; // decrease number of elements
				}
			} else if (deletenode.left == null || deletenode.right == null) {
				// case 2: has one child
				System.out.println("// case 2: has one child");
				final mynode nearnode = nearnode(deletenode);
				if (parentdelete == null) {
					System.out.println("root case");
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
					num--; // decrease number of elements
				}
			} else {
				// case 3: has two children
				System.out.println("// case 3: has two children");
				final mynode nearnode = nearnode(deletenode);
				stacknode.add(deletenode);
				stackvalue.add(nearnode.mdata);
				delete(nearnode.mdata);
			}
			// after chaineling delete, replace value
			for (int i = stacknode.size() - 1; i > -1; i--) {
				stacknode.get(i).mdata = stackvalue.get(i);
			}
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
			if (start == root) {
				System.out.print("[" + start.mdata + "-root]" + " ");
			} else {
				System.out.print(start + " ");
			}
			travel(start.right);
		}
	}

	public void display() {
		travel(root);
		System.out.println();
		System.out.println("number of elements: " + num);
		System.out.println("number of layers: " + layer);
	}

	private parentsave findparentsave(int value) {
		final parentsave p = new parentsave();
		mynode current = root;
		while (current != null) {
			if (current.mdata == value) {
				// [WRONG] parent = current
				p.deletenode = current;
				return p;
			} else if (current.mdata > value) {
				p.parentdelete = current; // save current right before it goes
				// deep

				current = current.left;
			} else {
				p.parentdelete = current; // save current right before it goes
				// deep
				current = current.right;
			}
		}
		return p;
	}

	private class parentsave {
		mynode deletenode;
		mynode parentdelete;

		public parentsave() {

		}
	}
}

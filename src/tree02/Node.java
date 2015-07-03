package tree02;

public class Node {
	int iData;
	Node leftChild;
	Node rightChild;

	public Node(int value) {
		iData = value;
	}

	@Override
	public String toString() {
		return "(" + iData + ")";
	}

	public static int compare(Node o1, Node o2) {
		if (o1.iData > o2.iData) {
			return 1;
		}
		if (o1.iData < o2.iData) {
			return -1;
		}
		return 0;
	}

}

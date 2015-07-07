package tree03;

public class Node03 {
	double mData;
	Node03 left;
	Node03 right;

	public Node03(double value) {
		mData = value;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + mData + "]";
	}

	public boolean equal(Node03 node2) {
		if (mData == node2.mData) {
			return true;
		} else {
			return false;
		}
	}

}

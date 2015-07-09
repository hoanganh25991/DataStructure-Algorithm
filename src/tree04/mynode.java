package tree04;

public class mynode {
	int mdata;
	mynode left;
	mynode right;

	public mynode(int value) {
		mdata = value;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + mdata + "]";
	}

}

package tree02;

import utils.MainUtils;

public class TestTree {
	public static void main(String[] args) {
		Tree tree = new Tree();
		int[] input = MainUtils.getRandomArrayNumber(10);
		tree.insert(input);
		tree.displayOnelineInorder();
		tree.displayOnelinePostorder();
	}
}

package tree;

import java.io.IOException;

import utils.MainUtils;

public class TestTree {
	public static void main(String[] args) throws IOException {
		int[] nums = MainUtils.getRandomArrayNumber(10);
		MainUtils.printArray(nums);
		Tree tree = new Tree();
		for (int i = 0; i < nums.length; i++) {
			tree.insert(nums[i]);
		}
		tree.displayTree();
		System.out.println("travel inorder");
		tree.travel(tree.getRoot());

	}
}

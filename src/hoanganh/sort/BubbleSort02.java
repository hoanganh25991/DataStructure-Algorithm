package hoanganh.sort;

import java.io.IOException;

import hoanganh.utils.MainUtils;

public class BubbleSort02 {
	private static int[] nums;
	public static void main(String[] args) throws IOException {
		while (true) {
			int[] numsa = MainUtils.getArrayNumber();
			nums = numsa;
			for (int out = nums.length - 1; out > 0; out--) {
				for (int in = 0; in < out; in++) {
					if (nums[in] > nums[in + 1]) {
						swap(in, in+1);
					}
				}
			}
			MainUtils.printArray(nums);
		}

	}

	public static void swap(int a, int b) {
		int temp = nums[b];
		nums[b] = nums[a];
		nums[a] = temp;
		
	}
}

package sort;

import java.io.IOException;

import utils.MainUtils;

public class BubbleSort {
	public static void main(String[] args) throws IOException {
		while (true) {
			int[] nums = MainUtils.getArrayNumber();
			int n = nums.length;
			for (int i = n - 1; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					if (nums[j] > nums[j + 1]) {
						int temp = nums[j];
						nums[j] = nums[j + 1];
						nums[j + 1] = temp;
					}
				}
			}
			MainUtils.printArray(nums);
		}
	}

}

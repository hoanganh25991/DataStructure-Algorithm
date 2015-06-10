package hoanganh.sort;

import java.io.IOException;

import hoanganh.utils.MainUtils;

public class SelectionSort {
	public static void main(String[] args) throws IOException {
		while (true) {
			int[] nums = MainUtils.getArrayNumber();
			int n = nums.length;
			for (int i = 0; i < n; i++) {
				int index = 0;
				for (int j = 0; j < n; j++) {
					if (nums[i] > nums[j]) {
						index++;
					}
				}
				int temp = nums[index];
				nums[index] = nums[i];
				nums[i] = temp;

			}
			MainUtils.printArray(nums);
		}
	}
}

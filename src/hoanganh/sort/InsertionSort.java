package hoanganh.sort;

import java.io.IOException;

import hoanganh.utils.MainUtils;

public class InsertionSort {
	public static void main(String[] args) throws IOException {
		while (true) {
			int[] nums = MainUtils.getArrayNumber();
			// small test

			for (int out = 1; out < nums.length; out++) {
				System.out.println("out =" + out);
				int temp = nums[out];
				int in = 0;
				// while (in < out && nums[in++] < temp) {
				//
				// }
				while (in < out && nums[in] < temp) {
					in++;
				}
				// the difference between while loops is in in first du khong
				// xay ra nhung van dc +, in trong second du khong xay ra, khong
				// duoc cong, no chi vi tri hien tai xay ra, trong khi in trong
				// first da + them 1
				// shift
				System.out.println("in =" + in);
				for (int i = out; i > in; i--) {
					nums[i] = nums[i - 1];
					System.out.printf("num[%d] = %d", i, nums[i]);
					System.out.println();
				}
				nums[in] = temp;
				MainUtils.printArray(nums);
			}
		}
	}
}

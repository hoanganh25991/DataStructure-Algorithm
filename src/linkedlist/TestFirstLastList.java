package linkedlist;

import java.io.IOException;

import utils.MainUtils;

public class TestFirstLastList {
	public static void main(String[] args) throws IOException {
		while (true) {
			int[] nums = MainUtils.getArrayNumber();
			FirstLastList list = new FirstLastList();
			for (int i = 0; i < nums.length; i++) {
				list.insertFirst(nums[i]);
			}

			list.disPlay();
			
			int[] nums02 = MainUtils.getArrayNumber();
			for (int i = 0; i < nums02.length; i++) {
				list.insertLast(nums02[i]);
			}
			list.disPlay();
			System.out.println(list.numElems);
		}
	}
}

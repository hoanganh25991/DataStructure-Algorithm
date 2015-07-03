package hoanganh.linkedlist;

import hoanganh.utils.MainUtils;

import java.io.IOException;

public class TestDoubltLinkedList {
	public static void main(String[] args) throws IOException {
		while (true) {
			int[] nums = MainUtils.getArrayNumber();
			DoublyLinkedList list = new DoublyLinkedList();
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
			
			int findNum = MainUtils.getNumber("enter number to find");
			list.find(findNum);
		}
	}
}

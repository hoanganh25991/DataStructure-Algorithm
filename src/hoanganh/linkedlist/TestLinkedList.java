package hoanganh.linkedlist;

import java.io.IOException;

import hoanganh.utils.MainUtils;

public class TestLinkedList {
	public static void main(String[] args) throws IOException {
		while(true){
			int[] insertedNums = MainUtils.getArrayNumber();
			DoublyLinkedList linkedList = new DoublyLinkedList();
			for(int i= 0; i < insertedNums.length; i++){
				linkedList.insert(insertedNums[i]);
			}
			linkedList.disPlay();
		}
	}

}

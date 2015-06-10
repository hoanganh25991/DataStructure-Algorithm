package hoanganh.recursion;

import java.io.IOException;
import java.util.Queue;

import hoanganh.utils.MainUtils;

public class MergeSort {
	private static int[] numbersArray;
	private static int size;

	public static void main(String[] args) throws IOException {
		while (true) {
			numbersArray = MainUtils.getArrayNumber();
			size = numbersArray.length;
			mergeSort(0, size - 1);
			MainUtils.printArray(numbersArray);
		}
	}

	public static void mergeSort(int left, int right) {
		int mid = (left + right) / 2;
		if (right - left == 1) {
			if (numbersArray[left] < numbersArray[right]) {
				;
				MainUtils.printArray(numbersArray);
			} else {
				int temp = numbersArray[left];
				numbersArray[left] = numbersArray[right];
				numbersArray[right] = temp;
				MainUtils.printArray(numbersArray);

			}
		} else {
			// -- recursion for left --
			printMergeSort(left, mid);
			mergeSort(left, mid);
			// -- recursion for right --
			printMergeSort(mid + 1, right);
			mergeSort(mid + 1, right);
			// --then merge each half --
			printMerge(left, mid, right);
			merge(left, mid, right);
		}

	}

	private static void merge(int left, int mid, int right) {
		StackX stack = new StackX(mid + 1);
		int startRight = mid + 1;
		int numberIndex = left;
		for (int i = mid; i > left - 1; i--) {
			stack.push(numbersArray[i]);
			System.out.println(numbersArray[i]);
		}
		while (!stack.isEmpty()) {
			while (!stack.isEmpty() && stack.peek() < numbersArray[startRight]) {
				printWhileS(stack.peek(), startRight);
				numbersArray[numberIndex++] = stack.pop();
				MainUtils.printArray(numbersArray);
			}
			numbersArray[numberIndex++] = numbersArray[startRight];
			MainUtils.printArray(numbersArray);
			while (!stack.isEmpty() && stack.peek() > numbersArray[++startRight]) {
				printWhileL(stack.peek(), startRight);
				numbersArray[numberIndex++] = numbersArray[startRight];
				MainUtils.printArray(numbersArray);
				if (startRight == right) {
					numbersArray[startRight] = stack.pop();
				}
			}
		}
		MainUtils.printArray(numbersArray);
	}

	private static void printMergeSort(int left, int right) {
		System.out.printf("mergeSort(%d,%d)", left, right);
		System.out.println();
	}

	private static void printMerge(int left, int mid, int right) {
		System.out.printf("merge(%d,%d,%d)", left, mid, right);
		System.out.println();
	}

	private static void printWhileS(int stackPeek, int startRight) {
		System.out.printf("stack.peek(%d) < numbers[%d](%d)", stackPeek, startRight, numbersArray[startRight]);
		System.out.println();
	}

	private static void printWhileL(int stackPeek, int startRight) {
		System.out.printf("stack.peek(%d) > numbers[%d](%d)", stackPeek, startRight, numbersArray[startRight]);
		System.out.println();
	}

}

class StackX {
	private int[] numbers;
	private int top;
	private int maxSize;

	StackX(int size) {
		maxSize = size;
		numbers = new int[maxSize];
		top = -1;
	}

	void push(int value) {
		numbers[++top] = value;
	}

	int pop() {
		return numbers[top--];
	}

	int peek() {
		return numbers[top];
	}

	boolean isEmpty() {
		return top == -1;
	}
}

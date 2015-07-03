package hoanganh.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainUtils {
	public static String getInput(String request) throws IOException {
		System.out.println("///////////////////////////////////////");
		System.out.println(request);
		System.out.flush();
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		String input = br.readLine();
		return input;
	}

	public static void warning(String warning) {
		System.out.println(warning);
	}

	public static int getNumber(String request) throws IOException {
		System.out.println(request);
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		String input = br.readLine();
		int num = Integer.parseInt(input);
		return num;
	}

	public static int[] getArrayNumber() throws IOException {
		System.out.println("enter a line of number, ex: 1 2 3 4");
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		String input = br.readLine();
		char[] arrChar = input.toCharArray();
		ArrayList<Integer> arrNum = new ArrayList<Integer>();
		int startNum = 0;
		for (int i = 0; i < input.length(); i++) {
			if (arrChar[i] == ' ') {
				String numString = "";
				for (int j = startNum; j < i; j++) {
					numString += arrChar[j];
				}
				arrNum.add(Integer.parseInt(numString));
				startNum = i + 1;
			}
		}
		// -- deal with last number --
		String lastNum = "";
		for (int i = startNum; i < input.length(); i++) {
			lastNum += arrChar[i];
		}
		arrNum.add(Integer.parseInt(lastNum));
		// -- convert ArrayList to int[], make it easy for User --
		int[] listNum = new int[arrNum.size()];
		for (int i = 0; i < arrNum.size(); i++) {
			listNum[i] = arrNum.get(i);
		}
		return listNum;
	}

	public static boolean isContinue() throws IOException {
		System.out.println("Continue test or not? y/n");
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		String input = br.readLine();
		return input.equals("y");
	}

	public static void printOut(int[] arrIn, int i) {
		System.out.println("a[" + i + "]" + "= " + arrIn[i]);
	}

	public static void printCondition(int[] arrIn, int i, int j, char ch) {
		System.out.println("a[" + i + "](" + arrIn[i] + ")" + ch + "a[" + j + "](" + arrIn[j] + ")");
	}

	public static int[] getRandomArrayNumber(int howManyNum) {
		ArrayList<Integer> arrayNum = new ArrayList<Integer>();
		while (arrayNum.size() < howManyNum) {
			int newNum = (int) (Math.random() * howManyNum * 10);
			boolean isDiff = true;
			for (Integer num : arrayNum) {
				if (num.equals(newNum)) {
					isDiff = false;
					break;
				}
			}
			if (isDiff) {
				arrayNum.add(newNum);
			}

		}
		int[] a = new int[howManyNum];
		for (int i = 0; i < arrayNum.size(); i++) {
			a[i] = arrayNum.get(i);
		}
		return a;
	}

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}

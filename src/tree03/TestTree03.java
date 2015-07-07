package tree03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import utils.MainUtils;

public class TestTree03 {
	private static Tree03 tree;

	public static void main(String[] args) throws IOException {
		tree = new Tree03();
		tree.insert(5.5);
		tree.insert(5.5);
		tree.insert(6.0);
		tree.insert(6.5);
		tree.insert(8.9);
		tree.insert(25.5);
		tree.insert(20.5);
		tree.insert(26.0);
		tree.insert(61.5);
		tree.insert(28.9);
		tree.insert(4.0);
		tree.insert(4.5);
		tree.insert(3.0);
		tree.insert(7.0);
		tree.insert(6.8);
		tree.insert(3.9);
		tree.insert(2.5);
		tree.display();
		// tree.display();
		// tree.delete(3.0);
		// tree.delete(4.5);
		double[] a = { 2.5, 3.7, 3.5, 3.8, 3.4, 3.6 };
		tree.insert(a);
		double c = Double.valueOf(MainUtils.getInput("find nearValue of ?"));
		System.out.print("find nearValue of " + c + ": "
				+ tree.nearValue(tree.find(c)));
		;
		System.out.println();
		double d = Double.valueOf(MainUtils.getInput("delete value ?"));
		if (tree.delete(d)) {
			System.out.println("delete succeess");
			tree.display();
		} else {
			System.out.println("cannnot find to delete");
		}

	}

	public static void insert() throws IOException {
		System.out.println("enter a double to store");
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		String input = br.readLine();
		double newNode = Double.valueOf(input);
		tree = new Tree03();
		tree.insert(newNode);
	}
}

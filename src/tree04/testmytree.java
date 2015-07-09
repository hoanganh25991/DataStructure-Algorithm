package tree04;

import java.io.IOException;

import utils.MainUtils;

public class testmytree {
	public static void main(String[] args) throws IOException {
		mytree t = new mytree();
		int[] values = MainUtils.getRandomArrayNumber(5);
		MainUtils.printArray(values);
		//insert into tree
		for (int i = 0; i < values.length; i++) {
			t.insert(values[i]);
		}
		t.display();
		String answer = null;
		do {
			answer = MainUtils.getInput("delete node ? (value/n)");
			try {
				int value = Integer.valueOf(answer);
				if(t.delete(value)){
					System.out.println("delete success");
					t.display();
				}else{
					System.out.println("fail to delete");
				}
			} catch (Exception e) {
				System.out.println("error input");
			}
		} while (!answer.equalsIgnoreCase("n"));
	}

}

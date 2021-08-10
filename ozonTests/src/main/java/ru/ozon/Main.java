package ru.ozon;

public class Main {

	public static void main(String[] args) {

		String source = "Hello ANNA-2 ieuoiu ieuoiuw ieu owiu9";

		String[] words = source.split(" ");
		int i2 = words.length;
		char[][] lettter1 = new char[i2][50];

		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
			for (int j = 0; j < words[i].toCharArray().length; j++) {
				char[] tap = words[i].toCharArray();
				lettter1[i][j] = tap[j];
				System.out.println(lettter1[i][j]);

			}
		}
		
		
	    int nums[] = {3,2,4};
	    int target = 6;

	}

}

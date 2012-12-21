package chapter1;

public class Question5 {
	public static void main(String[] args) {
		char[] test = go("wo shi yi shan zhu".toCharArray());
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i]);
		}
	}

	public static char[] go(char[] str) {
		int counter = 0;
		int length = 0;
		if (str.length < 1 || str == null)
			return str;
		for (length = 0; length < str.length; length++) {
			if (str[length] == ' ') {
				counter++;
			}
		}
		length = length + counter * 2;
		char[] result = new char[length];
		for (int i = str.length - 1; i >= 0; i--) {
			System.out.println(result[result.length - 1]);
			System.out.println(str[i] + "" + i);
			if (str[i] != ' ')
				result[--length] = str[i];
			else {
				result[--length] = '0';
				result[--length] = '2';
				result[--length] = '%';
			}

		}
		return result;
	}
}

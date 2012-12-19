package chapter1;

public class Question4 {
	public static void main(String[] args) {
		System.out.println(judge("aaa", "aaa"));
		System.out.println(judge("William Shakespeare".replaceAll(" ", "")
				.toLowerCase(), "I am a weakish speller".replaceAll(" ", "")
				.toLowerCase()));
	}

	public static boolean judge(String str1, String str2) {
		if (str1 == null || str2 == null)
			return false;
		int[] core = new int[256];

		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) == ' ')
				continue;
			core[str1.charAt(i)]++;
		}

		for (int i = 0; i < str1.length(); i++) {
			if (str2.charAt(i) == ' ')
				continue;
			core[str2.charAt(i)]--;
		}

		for (int i = 0; i < 256; i++) {
			if (core[i] != 0)
				return false;
		}
		return true;
	}
}

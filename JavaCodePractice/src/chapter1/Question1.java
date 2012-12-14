package chapter1;

import java.util.HashSet;

public class Question1 {
	public static String str = "hgqa98qh;48yp;";

	public static void main(String[] args) {
		System.out.println("output from method1");
		String results_1 = (method1() == true) ? "true" : "false";
		System.out.println(results_1);
		System.out.println("-----------------------------");
		method2();
		String results_2 = (method2() == true) ? "true" : "false";
		System.out.println(results_2);
		System.out.println("-----------------------------");
		method3();
		String results_3 = (method3() == true) ? "true" : "false";
		System.out.println(results_3);
	}

	public static boolean method1() {
		HashSet<Character> set = new HashSet<Character>();
		char[] array = str.toCharArray();
		for (char a : array) {
			if (set.contains((Character) a))
				return false;
			else
				set.add(a);
		}
		return true;
	}

	public static boolean method2() {
		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			for (int j = i + 1; j < str.length(); j++) {
				char b = str.charAt(j);
				if (a == b)
					return false;
			}
		}
		return true;
	}
	public static boolean method3(){
		// Assume that the default charset is ascii
		boolean[] charset = new boolean[256];
		for(int i = 0; i < str.length(); i++){
			int index = str.charAt(i);
			if(charset[index]) return false;
		}
		return true;
	}
}

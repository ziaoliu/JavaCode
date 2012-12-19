package chapter1;

public class Question3 {
	public static void main(String[] args) {
		String theString = "kfxxxxxxjhwliuerhgf";
		System.out.println(remove1(theString));
	}

	public static String remove1(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(sb.toString().indexOf(ch) == -1){
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}

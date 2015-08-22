package test;

public class SimplifyPath {
	public class Solution {
		public String simplifyPath(String path) {
			if (path == null || path.length() == 0)
				return path;
			String[] array = path.split("/");
			for (int i = 0; i < array.length; i++) {
				if (array[i].equals(".")) {
					array[i] = "";
				} else if (array[i].equals("..")) {
					array[i] = "";
					for (int j = i - 1; j >= 0; j--) {
						if (array[j].equals(""))
							continue;
						array[j] = "";
						break;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			for (String dir : array) {
				if (!dir.equals(""))
					sb.append("/").append(dir);
			}
			if (sb.length() == 0)
				sb.append("/");
			return sb.toString();
		}
	}
}

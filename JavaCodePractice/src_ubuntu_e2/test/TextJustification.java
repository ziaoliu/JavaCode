package test;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public static void main(String[] args) {
		TextJustification test = new TextJustification();
		Solution s = test.new Solution();
		String[] words = { "" };
		System.out.println(s.fullJustify(words, 2));
	}

	public class Solution {
		public List<String> fullJustify(String[] words, int maxWidth) {
			List<String> result = new ArrayList<String>();
			if (words == null || words.length == 0)
				return result;
			if (maxWidth == 0) {
				result.add("");
				return result;
			}
			// step 1: find words at each row
			List<String> row = new ArrayList<String>();
			int len = 0;
			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				if (maxWidth < word.length())
					return result;
				int rowLen = len + word.length() + row.size();
				if (rowLen > maxWidth) {
					// lists.add(new ArrayList<String>(row));
					// step 2. build row string
					buildRow(len, maxWidth, row, result);
					len = 0;
					row = new ArrayList<String>();
					i--;
				} else {
					len = len + word.length();
					row.add(word);
					if (i + 1 == words.length) {
						// no justification for last row
						buildLastRow(len, maxWidth, row, result);
					}
				}
			}

			return result;
		}

		private void buildRow(int len, int maxWidth, List<String> row,
				List<String> result) {
			int spaces = maxWidth - len;
			int per = row.size() == 1 ? spaces : spaces / (row.size() - 1);
			int extra = 0;
			if (row.size() != 1 && spaces > row.size() - 1)
				extra = spaces % (row.size() - 1);

			// row.size() == 1 ? 0 : spaces % row.size();
			if (row.size() == 1) {
				String tmp = row.get(0) + padSpaces(spaces);
				result.add(tmp);
				return;
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < row.size() - 1; i++) {
				sb.append(row.get(i)).append(padSpaces(per));
				if (extra > 0) {
					sb.append(" ");
					extra--;
				}
			}
			sb.append(row.get(row.size() - 1));
			result.add(sb.toString());
			return;
		}

		private void buildLastRow(int len, int maxWidth, List<String> row,
				List<String> result) {
			int spaces = maxWidth - len;
			if (row.size() > 1)
				spaces = spaces - row.size();

			if (row.size() == 1) {
				String tmp = row.get(0) + padSpaces(spaces);
				result.add(tmp);
				return;
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < row.size(); i++) {
				String tmp = row.get(i).length() == 0 ? " " : row.get(i);
				sb.append(tmp).append(' ');
			}
			sb.append(padSpaces(spaces));
			result.add(sb.toString());
			return;
		}

		private String padSpaces(int per) {
			if (per == 0)
				return "";
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < per; i++)
				sb.append(' ');
			return sb.toString();
		}
	}
}

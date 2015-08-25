package test;

public class WordSearch {
	public class Solution {
		public boolean exist(char[][] board, String word) {
			if (board == null || board.length == 0 || board[0].length == 0)
				return false;
			if (word == null || word.length() == 0)
				return false;
			boolean[][] visited = new boolean[board.length][board[0].length];
			for (int i = 0; i < board.length; i++)
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == word.charAt(0))
						if (dfs(0, i, j, board, visited, word))
							return true;
				}
			return false;
		}

		private boolean dfs(int index, int i, int j, char[][] board,
				boolean[][] visited, String word) {
			int m = board.length;
			int n = board[0].length;
			if (index == word.length()) // when match word length
				return true;
			if (i < 0 || j < 0 || i > m - 1 || j > n - 1
					|| index > word.length() || visited[i][j]
					|| board[i][j] != word.charAt(index))
				return false;

			visited[i][j] = true;
			index++;

			if (dfs(index, i - 1, j, board, visited, word))
				return true;
			if (dfs(index, i + 1, j, board, visited, word))
				return true;
			if (dfs(index, i, j - 1, board, visited, word))
				return true;
			if (dfs(index, i, j + 1, board, visited, word))
				return true;

			visited[i][j] = false;

			return false;
		}
	}
}

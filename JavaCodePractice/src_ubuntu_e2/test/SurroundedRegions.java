package test;

import java.util.LinkedList;

public class SurroundedRegions {
	public class Solution {
		public void solve(char[][] board) {
			if (board == null || board.length == 0 || board[0].length == 0)
				return;
			// top and bottom rows
			for (int i = 0; i < board[0].length; i++) {
				bfs(board, 0, i);
				bfs(board, board.length - 1, i);
			}
			// left and right cols
			for (int i = 0; i < board.length; i++) {
				bfs(board, i, 0);
				bfs(board, i, board[0].length - 1);
			}

			// X, O, .
			for (int i = 0; i < board.length; i++)
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == 'O')
						board[i][j] = 'X';
					if (board[i][j] == '.')
						board[i][j] = 'O';
				}
		}

		private void bfs(char[][] board, int row, int col) {
			if (board[row][col] != 'O')
				return;
			board[row][col] = '.';
			LinkedList<Integer> queue = new LinkedList<Integer>();
			queue.add(row * board[0].length + col);
			while (queue.size() > 0) {
				int code = queue.remove(0);
				int i = code / board[0].length;
				int j = code % board[0].length;

				// go up: i - 1
				if (i > 0 && board[i - 1][j] == 'O') {
					board[i - 1][j] = '.';
					queue.add((i - 1) * board[0].length + j);
				}
				// go down: i + 1
				if (i < board.length - 1 && board[i + 1][j] == 'O') {
					board[i + 1][j] = '.';
					queue.add((i + 1) * board[0].length + j);
				}
				// go left: j - 1
				if (j > 0 && board[i][j - 1] == 'O') {
					board[i][j - 1] = '.';
					queue.add(i * board[0].length + j - 1);
				}
				// go right: j + 1 //j range
				if (j < board[0].length - 1 && board[i][j + 1] == 'O') {
					board[i][j + 1] = '.';
					queue.add(i * board[0].length + j + 1);
				}
			}
		}// end of bfs
	}
}

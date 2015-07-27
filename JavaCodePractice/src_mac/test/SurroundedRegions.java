package test;

import java.util.LinkedList;

public class SurroundedRegions {
	public void surround(char[][] board) {
		if (board == null || board.length < 1 || board[0].length < 1)
			return;

		// first and last rows
		for (int i = 0; i < board[0].length; i++) {
			fill(board, 0, i);
			fill(board, board.length - 1, i);
		}

		// first and last cols
		for (int i = 0; i < board.length; i++) {
			fill(board, i, 0);
			fill(board, i, board[0].length - 1);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'X')
					continue;
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				if (board[i][j] == '#')
					board[i][j] = 'O';
			}
		}

	}

	// bfs from each edge
	public void fill(char[][] board, int i, int j) {
		if (board[i][j] != 'O')
			return;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		board[i][j] = '#';
		queue.add(i * board[0].length + j);
		while (!queue.isEmpty()) {
			int code = queue.poll();
			int row = code / board[0].length;
			int col = code % board[0].length;

			// up
			while (row >= 1 && board[row - 1][col] == 'O') {
				board[row - 1][col] = '#';
				queue.add((row - 1) * board[0].length + col);
			}
			// down
			while (row < board.length - 1 && board[row + 1][col] == 'O') {
				board[row + 1][col] = '#';
				queue.add((row + 1) * board[0].length + col);
			}
			// left
			while (col >= 1 && board[row][col - 1] == 'O') {
				board[row][col - 1] = '#';
				queue.add(row * board[0].length + col - 1);
			}
			// right
			while (col < board[0].length - 1 && board[row][col + 1] == 'O') {
				board[row][col + 1] = '#';
				queue.add(row * board[0].length + col + 1);
			}
		}
	}//end of fill
}

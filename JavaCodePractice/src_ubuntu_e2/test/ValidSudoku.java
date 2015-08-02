package test;

public class ValidSudoku {
	public class Solution {
		public boolean isValidSudoku(char[][] board) {
			if (board == null)
				return false;
			if (board.length != 9 || board[0].length != 9)
				return false;

			// each row
			for (int i = 0; i < 9; i++) {
				boolean[] check = new boolean[9];
				for (int j = 0; j < 9; j++) {
					char c = board[i][j];
					if (c == '.')
						continue;
					int index = c - '1';
					if (!check[index])
						check[index] = true;
					else
						return false;
				}
			}

			// each column
			for (int i = 0; i < 9; i++) {
				boolean[] check = new boolean[9];
				for (int j = 0; j < 9; j++) {
					char c = board[j][i];
					if (c == '.')
						continue;
					int index = c - '1';
					if (!check[index])
						check[index] = true;
					else
						return false;
				}
			}

			// each box
			for (int box = 0; box < 9; box++) {
				boolean[] check = new boolean[9];
				int row = box / 3;
				for (int i = row * 3; i < row * 3 + 3; i++) {
					int col = box % 3;
					for (int j = col * 3; j < col * 3 + 3; j++) {
						char c = board[i][j];
						if (c == '.')
							continue;
						int index = c - '1';
						if (!check[index])
							check[index] = true;
						else
							return false;
					}
				}

				check = new boolean[9];
			}
			return true;
		}// end of the method
	}
}

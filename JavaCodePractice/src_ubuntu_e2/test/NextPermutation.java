package test;

public class NextPermutation {
	public class Solution {
		public void nextPermutation(int[] num) {
			if (num == null || num.length == 0)
				return;

			int i = num.length - 1;
			int j = num.length - 1;

			for (; i > 0; i--) {
				if (num[i - 1] < num[i])
					break;
			}

			if (i != 0) {
				i--;
				for (; j >= 0; j--) { // <<<<<<<< bug: j <= 0??WTF
					if (num[i] < num[j])
						break;
				}

				int temp = num[j];
				num[j] = num[i];
				num[i] = temp;

				i++;
			}

			for (j = num.length - 1; j >= i; j--, i++) {
				int temp = num[j];
				num[j] = num[i];
				num[i] = temp;
			}

		}// end of method
	}
}

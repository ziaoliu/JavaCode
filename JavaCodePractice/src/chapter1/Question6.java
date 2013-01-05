package chapter1;
// rotate the n*n matrix
public class Question6 {
	private static int[][] mat = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };

	public static void main(String[] args) {
		for (int i = 0; i < mat[0].length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		rotate();
		for (int i = 0; i < mat[0].length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void rotate() {
		System.out.println("Start rotating...");
		int N = mat.length;
		// going through layers
		for (int layer = 0; layer < N / 2; layer++) {
			int first = layer;
			int last = N - 1 - layer;
			for (int element = layer; element < last; element++) {

			}

		}

	}
}

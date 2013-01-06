package chapter1;

// rotate the n*n matrix
public class Question6 {
	private static int[][] mat = { { 0, 1, 0, 0 }, { 0, 1, 0, 0 },
			{ 0, 1, 0, 0 }, { 0, 1, 0, 0 } };

	public static void main(String[] args) {
		if (mat.length != mat[0].length) {
			System.out.println("Must be symmetric matrix");
			System.exit(0);
		}
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
			for (int position = first; position < last; position++) {
				int offset = position - first;
				// copy top position (top row)
				int top = mat[layer][first + offset];

				// copy bottom --> top (left col)
				mat[layer][first + offset] = mat[last - offset][layer];

				// copy left --> right (bottom row)
				mat[last - offset][layer] = mat[last][last - offset];

				// copy top --> bottom (right col)
				mat[last][last - offset] = mat[first + offset][last];

				// copy top --> right (top row)
				mat[first + offset][last] = top;
			}
		}
	}
}

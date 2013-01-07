package chapter1;

import java.util.ArrayList;

//Write an algorithm such that 
//if an element in an MxN matrix is 0, its entire row and column is set to 0.

public class Question7 {
	private static int[][] matrix = { { 1, 0, 1, 0 }, { 1, 1, 1, 1 },
		{ 1, 1, 1, 1 }, { 1, 1, 1, 0 } };

	public static void main(String[] args) {
		// System.out.println(matrix[0].length);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		transform();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void transform() {
		System.out.println("Starting transformation...");
		ArrayList<Integer> rows = new ArrayList<Integer>(matrix.length);
		ArrayList<Integer> colms = new ArrayList<Integer>(matrix[0].length);
		for (int row = 0; row < matrix.length; row++) {
			for (int colm = 0; colm < matrix[0].length; colm++) {
				if(matrix[row][colm] == 0){
					if(!rows.contains(row)){
						rows.add(row);
					}
					if(!colms.contains(colm)){
						colms.add(colm);
					}
				}
			}
		}
		for(Integer i : rows){
			System.out.println(i);
			for(int f = 0; f < matrix[0].length; f++){
				matrix[i][f] = 0;
			}
		}
		for(Integer j : colms){
			System.out.println(j);
			for(int l = 0; l < matrix[0].length; l++){
				matrix[l][j] = 0;
			}
		}
		System.out.println("Done tranforming..");
	}
}













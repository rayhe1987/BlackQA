package com.netease.hjl.rule;

public class GameRule {

	public static final int NUM = 25;

	public static boolean matrix[][] = new boolean[NUM][NUM];

	static {
		for (int i = 0; i < NUM; i++) {
			for (int j = 0; j < NUM; j++) {
				matrix[i][j] = false;
			}
		}
	}

	static void getNextStatus() {
		// 先记录老的状态
		boolean matrix_old[][] = new boolean[NUM][NUM];
		for (int i = 0; i < NUM; i++) {
			for (int j = 0; j < NUM; j++) {
				matrix_old[i][j] = matrix[i][j];
			}
		}
		for (int i = 0; i < NUM; i++) {
			for (int j = 0; j < NUM; j++) {
				int livingCount = 0;
				// North
				if (j - 1 >= 0) {
					if (matrix_old[i][j - 1]) {
						livingCount++;
					}
				}
				// South
				if (j + 1 <= NUM - 1) {
					if (matrix_old[i][j + 1]) {
						livingCount++;
					}
				}
				// West
				if (i - 1 >= 0) {
					if (matrix_old[i - 1][j]) {
						livingCount++;
					}
				}
				// East
				if (i + 1 <= NUM - 1) {
					if (matrix_old[i + 1][j]) {
						livingCount++;
					}
				}
				// Northwest
				if ((j - 1 >= 0)&&(i - 1 >= 0)) {
					if (matrix_old[i - 1][j - 1]) {
						livingCount++;
					}
				}
				// Northeast
				if ((j - 1 >= 0)&&(i + 1 <= NUM - 1)) {
					if (matrix_old[i + 1][j - 1]) {
						livingCount++;
					}
				}
				// Southwest
				if ((j + 1 <= NUM - 1)&&(i - 1 >= 0)) {
					if (matrix_old[i - 1][j + 1]) {
						livingCount++;
					}
				}
				// Southeast
				if ((j + 1 <= NUM - 1)&&(i + 1 <= NUM - 1)) {
					if (matrix_old[i + 1][j + 1]) {
						livingCount++;
					}
				}
				//对于原来是活的细胞,当有2或3个存活的邻近细胞时，才能继续存活
				if (matrix[i][j]) {
					if (livingCount==2||livingCount==3) {
						matrix[i][j] = true;
					}else {
						matrix[i][j] = false;
					}
				}
				//对于原来是死的细胞,当恰有3个存活的邻近细胞时，则诞生活细胞
				else {
					if (livingCount==3) {
						matrix[i][j] = true;
					}else {
						matrix[i][j] = false;
					}
				}
			}
		}
	}

}

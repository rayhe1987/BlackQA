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
		// �ȼ�¼�ϵ�״̬
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
				//����ԭ���ǻ��ϸ��,����2��3�������ڽ�ϸ��ʱ�����ܼ������
				if (matrix[i][j]) {
					if (livingCount==2||livingCount==3) {
						matrix[i][j] = true;
					}else {
						matrix[i][j] = false;
					}
				}
				//����ԭ��������ϸ��,��ǡ��3�������ڽ�ϸ��ʱ��������ϸ��
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

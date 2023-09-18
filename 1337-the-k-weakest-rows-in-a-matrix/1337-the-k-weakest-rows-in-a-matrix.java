class Solution {
public int[] kWeakestRows(int[][] mat, int k) {
int[] res = new int[k];
int[][] IndexRes = new int[mat.length][2];

	int count = 0;
	for (int i = 0; i < mat.length; i++) {

		for (int j = 0; j < mat[i].length; j++) {
			if (mat[i][j] == 0) {
				IndexRes[i][0] = i;
				IndexRes[i][1] = count;
				count = 0;
				break;
			} else {
				if (j == mat[i].length - 1) {
					count++;
					IndexRes[i][0] = i;
					IndexRes[i][1] = count;
					count = 0;
				} else {
					count++;
				}

			}

		}

	}

	IndexRes = arreySort(IndexRes);

	if (1 <= k && k <= mat.length) {
		for (int i = 0; i < k; i++) {
			res[i] = IndexRes[i][0];

		}
	}

	return res;
    
}
public static int[][] arreySort(int[][] array) {
		for(int i = array.length-1;i>0;i--) {
			for(int j = 0;j<i;j++) {
			if(array[j][1]>array[j+1][1]) {
				int j0 = array[j][0];
				int j1 = array[j][1];
				
				array[j][0] = array[j+1][0];
				array[j][1] = array[j+1][1];
				
				array[j+1][0] = j0;
				array[j+1][1] = j1;
			}
			}
		}
		
		return array;
		
	}
}
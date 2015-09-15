/*#################################### Set Matrix Zeroes #############################
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in
place.
####################################################################################*/

// #####################################################################
// 思路分析：
// 这道题如果不用多余空间的话, 我们需要用第一行和第一列来存储每一个元素
// 的状态. 最后根据第一行和第一列的情况来置零. 
//
// 易错点:
// 
// 难点:
//
// 复杂度分析:
// 时间: O(mn)
// 空间: O(1)
// #####################################################################
public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row0 = false, col0 = false;
        int i, j, row_num = matrix.length, col_num = matrix[0].length;

        for (i = 0; i < row_num; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
                break;
            }
        }

        for (i = 0; i < col_num; i++) {
            if (matrix[0][i] == 0) {
                row0 = true;
                break;
            }
        }

        if (col_num > 1 && row_num > 1) {
            for (i = 1; i < row_num; i++) {
                for (j = 1; j < col_num; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = -1;
                        matrix[i][0] = -1;
                    }
                }
            }

            for (i = 1; i < row_num; i++) {
                if (matrix[i][0] == -1 || matrix[i][0] == 0) {
                    for (j = 0; j < col_num; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }

            for (i = 1; i < col_num; i++) {
                if (matrix[0][i] == -1 || matrix[0][i] == 0) {
                    for (j = 0; j < row_num; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
        }

        if (row0) {
            for (i = 0; i < col_num; i++) {
                matrix[0][i] = 0;
            }
        }

        if (col0) {
            for (i = 0; i < row_num; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

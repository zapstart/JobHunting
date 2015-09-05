/*#################################### Valid Sudoku  ############################
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the
character '.'.
###############################################################################*/

// #####################################################################
// 思路分析：
// 既可以用二维数组, 也可以用 set. 
// 该题我用 set 方法
//
// 易错点:
// 如何将原 board 中数字表现在 set 中.
// 1) 对于 row, 我们只需要直接将每一条 row 放到 rows set 中 
// 2) 对于 col, 我们只需要直接将每一条 col 放到 columns set 中 
// 3) 对于中间的小 cube 稍微麻烦点, 一共有 9 个 小 cube
//    j 
//  i 0 1 2 | 3 4 5 | 6 7 8  
//    0 1 2 | 3 4 5 | 6 7 8  
//    0 1 2 | 3 4 5 | 6 7 8   
//
//    由于 j 循环在 i 循环内部, 我们用 j 来表示 offset 
//    这里的 i 和 j 已经不是 row 和 col 了. i 是 从左到右, 从上到下 cube
//    排序的 index\
//    思考时候注意 i 代表的 cube 以及其起始位置
//
//    每一行都是 3 * (i / 3) + j / 3  
//    每一列都是 3 * (i % 3) + j % 3 
// 
// 难点:
// 无
//
// 复杂度分析:
// 时间: O(n^2)
// 空间: O(n^2)
// #####################################################################
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }
}

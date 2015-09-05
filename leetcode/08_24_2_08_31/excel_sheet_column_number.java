/*#################################### Excel Sheet Column Number  ############################
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
############################################################################################*/

// #####################################################################
// 思路分析：
// 一道很简单题目, 类似于26进制数字转换为10进制 
//
// 易错点:
// 无
//
// 难点:
// 无
//
// 复杂度分析:
// 时间: O(n)
// 空间: O(1)
// #####################################################################
public class Solution {
    public int titleToNumber(String s) {
        int result = 0, size = s.length();

        for (int i = 0; i < size; i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}

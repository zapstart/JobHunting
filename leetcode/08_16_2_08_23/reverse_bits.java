/*#################################### Reverse Bits ##################################
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it? 
#######################################################################################*/

// #####################################################################
// 思路分析：
// 通过移位来达到目的
// 解题思想和 reverse integer 类似
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
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // 基本方法，通过移位来达到目的
        int i, temp = 0;

        for (i = 0; i < 32; i++) {
            // 这里要先移位再和 n & 1 并运算,　否则
            // 每位数多移动了一位
            // 比如 i == 0 时候，如果并后为 0001,
            // 移位后为 0010, 这样相当于在 0 时候已经
            // 移动了一位
            temp = (temp << 1) | (n & 1);

            // 这里要用无符号数移位
            n = n >>> 1;
        }

        return temp;
    }
}

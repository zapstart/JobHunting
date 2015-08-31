/*  #################################### Reverse Integer ####################################
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.
Have you thought about this?

Here are some good questions to ask before coding. Bonus points for you if you have
already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer,
then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer
overflows.

Update (2014-11-10):
Test cases had been added to test the overflow behavior.
###########################################################################################*/

// #####################################################################
// 思路分析：
// 对数字每次 mod 10, 所得数字就是 reverse 后数字的最低位.
// 每次循环 reverse 后的数字都会先乘以 10 然后在加上新得到的最低位.
// 判断溢出使用 java Integer.MAX_VALUE 和 Integer.MIN_VALUE
//
// 易错点:
// 1) 要对 reverse 数字先 *10 然后加上新得到的最低位.
// 2) reverse 数字 j 要用 long. 该数字要用于判断溢出.
//
// 难点:
// 无
//
// 复杂度分析:
// 时间: O(logn)
// 空间: O(1)
// #####################################################################

public class Solution {
    public int reverse(int x) {
        long j = 0;

        while (x != 0) {
            j = (10 * j + (x % 10));
            x /= 10;

            if (j > Integer.MAX_VALUE || j < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) j;
    }
}

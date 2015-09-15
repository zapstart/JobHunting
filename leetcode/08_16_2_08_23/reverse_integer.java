/*#################################### Reverse Integer ##################################
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.
Have you thought about this?

Here are some good questions to ask before coding. Bonus points for you if you have 
already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 
32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed 
integer overflows.
#######################################################################################*/

// #####################################################################
// 思路分析：
// 通过不断 mod 数字达到获取 reverse number 的目的.
// 可能会溢出, 所以要用 long 来存储得到数字, 然后再判断是否溢出.
//
// 易错点:
// 溢出问题需要考虑 
//
// 难点:
// 无
//
// 复杂度分析:
// 时间: O(lgn)
// 空间: O(1)
// #####################################################################
public class Solution {
    public int reverse(int x) {
        // int 是有符号数
        // 用一个比 int 位数更多的数来接受运算结果
        // 这样可以避免发生 overflow
        long j = 0;

        while (x != 0) {
            j = j * 10;
            j = (j + (x % 10));
            x /= 10;

            // 有符号数最大与最小
            if (j > 0x7FFFFFFF || j < 0x80000000) {
                return 0;
            }
        }

        return (int) j;
    }
}

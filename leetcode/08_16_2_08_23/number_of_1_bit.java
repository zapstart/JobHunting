/*#################################### Number of 1 Bits ############################################
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known
as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so
the function should return 3.
####################################################################################################*/

// #############################################################################################
// 思路分析：
// 最直接想到的就是通过移位看到底有多少个 1.a
// 这个链接给出了很多种解法可以参考
// http://www.cnblogs.com/graphics/archive/2010/06/21/1752421.html
//
// 易错点:
// 1) 有符号数不能用 n > 0 判断
// 2) 要用无符号数移位
//
// 难点:
// 无
//
// 复杂度分析:
// 时间: O(logn)
// 空间: O(1)
// #############################################################################################
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int j = 0;

        // 这里不能用 n > 0 因为int是有符号数,31bit为以时候n是负数,因此
        // 要用 n != 0 来做判断
        while (n != 0) {
            j += (n & 1);
            n = n >>> 1;
        }
        return j;
    }
}

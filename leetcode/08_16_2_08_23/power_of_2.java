/*  #################################### Power of Two ###################
Given an integer, write a function to determine if it is a power of two. 
#######################################################################*/

// #####################################################################
// 思路分析：
// 通过位运算可以很好解决这个问题, 每一个 power of two 的数字都是 MSB 是
// １而其他位数是０, 比该数字小１的数字恰好 MSB 为０，其他位为１. 因此用
// n & (n - 1) 来和０对比，如果是０，n 则是 power of two; 否则 n 不是
// 
// 易错点:
// == has higher priority than & in java 
//
// 难点:
// 无
//
// 复杂度分析:
// 时间: O(1) 
// 空间: O(1)
// #####################################################################

public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        else {
            // == has higher priority than & in java
            if ((n & (n - 1)) == 0) {
                return true;
            }
            else {
                return false;
            }
        }
    }
}

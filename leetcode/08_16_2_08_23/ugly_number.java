/*  #################################### Ugly Number ###########################################
Write a program to check whether a given number is an ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
Note that 1 is typically treated as an ugly number.
###############################################################################################*/

// #############################################################################################
// 思路分析：
// 如果这个数字对2, 3, 5求余为零，除以2, 3, 5. 如果该数字最后为１，则是 ugly number，否则不是
//
// 易错点:
// 无 
//
// 难点: 
// 无
//
// 复杂度分析: 
// 时间: O(logn)
// 空间: O(1)
// #############################################################################################
public class Solution {
    public boolean isUgly(int num) {
        int[] factor = new int[] {2, 3, 5};

        if (num <= 0) {
            return false;
        }
        else {
            for (int i = 0; i < 3; i++) {
                while (num % factor[i] == 0) {
                    num /= factor[i];
                }
            }

            // num == 1 这种情况包含在这里
            return (num == 1);
        }
    }
}

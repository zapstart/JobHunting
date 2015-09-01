/*#################################### Add Digits ###################################################
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:
Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
###################################################################################################*/

// #############################################################################################
// 思路分析：
// 这是一道求［数根］的题目，方法２使用这一方法
// 假设数根为d(n):
//        | 0 if n == 0
// d(n) = | 9 if n != 0 && n mod 9 == 0
//        | n mod 9
//
// 方法１使用基本循环思路，首先求出每一位，然后逐一相加.如果相加结果大于９则再对这个数字使用相同
// 方法处理直到该数字小于等于９
//
// 易错点:
// 无
//
// 难点:
// 要懂得什么是数根才能用第二种方法
//
// 复杂度分析:
// 时间: O(1) - 方法２
// 空间: O(1)
// #############################################################################################

public class Solution {
    // 方法1: 按照循环方法求解
    public int addDigits(int num) {
        int temp;

        while (num > 9) {
            temp = 0;
            while (num > 0) {
                temp += num % 10;
                num /= 10;
            }
            num = temp;
        }

        return num;
    }

    // 方法2: 该问题是求数根,以下为求数根算法
    public class Solution {
        public int addDigits(int num) {
            return 1 + ((num - 1) % 9);
        }
    }
}

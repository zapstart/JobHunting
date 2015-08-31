/*  #################################### Palindrome Number ####################################
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.
Some hints:

Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra
space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer",
you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
###########################################################################################*/

// #####################################################################
// 思路分析：
// 对于这道题和 Reverse Integer 这类和 Integer 打交道的题目, 我们需要注
// 意 1) 是否溢出 2) 是否负数 3) 是否为0
// 这道题和 Reverse Integer 思路类似, 都需要考虑溢出. 负数是没有
// 不是 palindrome number. 
//
// 易错点:
// 考虑不全面, 没注意溢出, 0, 负数等情况. 
// 
// 难点:
// 无
//
// 复杂度分析:
// 时间: O(logn)
// 空间: O(1)
// #####################################################################

// 方法1: 
// 该方法不会溢出, 这个方法和 Reverse Integer 相似. 其只用遍历一半的
// 数字位数.该方法需要单独考虑 input_num % 10 == 0 && input_num != 0 
// 的情况.
// 
// 
// 例子1: 121
// 当位数为奇数时候, 当 i 和 x 交换到 i > x 时候, 除了中间一位数字, 两边
// 数字应该相同, 因此如果 i / 10 == x, 则结果一定是真, 否则为假.
// i = 1,  x = 12
// i = 12, x = 1 (x < i) i / 10 == x 因此返回是
// 
// 例子2: 1221 
// 当位数为偶数时候, 如果是 palindrome number 则交换后 i 和 x 一定会相等 
// i = 1, x = 122
// i = 12, x = 12 (x == i) i == x 因此返回是 
public class Solution {
    public boolean isPalindrome(int x) {
        int i = 0;

        if (x == 0) {
            return true;
        }

        if (x % 10 == 0) {
            return false;
        }

        while (x > i) {
            i = i * 10 + (x % 10);
            x /= 10;
        }

        return (x == i || i / 10 == x);
    }
}

// 方法2: 
// 这是和判断 palindrome string 用的一样的方法
// 通过分别判断数字两头数字的值是否相同来判断该数字是不是 palindrome number
public class Solution {
    public boolean isPalindrome(int x) {
        //negative numbers are not palindrome
        if (x < 0)
            return false;

        // initialize how many zeros
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        while (x != 0) {
            int left = x / div;
            int right = x % 10;

            if (left != right)
                return false;
            
            // 去掉数字的头和尾 
            // 1234 去掉头尾后是 (1234 % 1000) / 10 = 23
            x = (x % div) / 10;
            div /= 100;
        }
        
        return true;
    }
}

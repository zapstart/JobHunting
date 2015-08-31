/*#################################### Single Number #############################
Given an array of integers, every element appears twice except for one. Find that
single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it
without using extra memory?
################################################################################*/

// #####################################################################
// 思路分析：
// A xor A = 0; A xor B xor A = (A xor A) xor B = B
// 这道题和 Missing Number 思路一样
//
// 易错点:
//
// 难点:
//
// 复杂度分析:
// 时间: O(n)
// 空间: O(1)
// #####################################################################
public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }
}

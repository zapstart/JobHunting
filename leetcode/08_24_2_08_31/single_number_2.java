/*#################################### Single Number 2 #############################
Given an array of integers, every element appears three times except for one. Find
that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it
without using extra memory?
##################################################################################*/

// ############################################################################################
// 思路分析：
// 要用 linear runtime 来解这道题目我们必须保证只用一层循环(或者两层循环
// , 但是有一层是固定的循环次数) 
//
// 方法一是一种很巧妙的使用 bit operation 的方法, 以下链接有具体分析:
// https://leetcode.com/discuss/9763/accepted-proper-explaination-does-anyone-have-better-idea
// 简单说来, 该方法就是当一位上的 1 数量是 1 和 3 是等效的, 我们通过不
// 断异或来接收新的 1 以及消除 重复的 1. 最后剩下的就是我们要求的那个
// 数字
//
// 方法二是直接方法, 该方法直接计算所有数字的每位为 1 的个数, 如果个数
// mod 3 为零, 则说明该位数字出现了 3x 次, 因此一定不在我们要求的那个
// 数字中. 通过移位我们可以构造出这个所求的数字.
//  　
// 易错点:
//
// 难点:
//
// 复杂度分析:
// 时间: O(n)
// 空间: O(1)
// ############################################################################################
public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0, remove_bits, size = nums.length;

        for (int i = 0; i < size; i++) {
            
            // ones & nums[i] 是将之前的 ones 与新的数字与运算求
            // 出同时为 1 的位数, 然后加入到 twos 中 
            twos |= (ones & nums[i]); 

            // ones 根据新的数字更新自己
            ones ^= nums[i];
            remove_bits = ones & twos;
            ones &= (~remove_bits);
            twos &= (~remove_bits);
        }
        return ones;
    }
}

public int singleNumber(int[] A) {
    int ones = 0, twos = 0;
    for(int i = 0; i < A.length; i++){
        ones = (ones ^ A[i]) & ~twos;
        twos = (twos ^ A[i]) & ~ones;
    }
    return ones;
}

public class Solution {
    public int singleNumber(int[] nums) {
        int size = nums.length, result = 0;
        
        int[] bit_num = new int[32]; 
        
        for (int j = 0; j < 32; j++) {
            for (int i = 0; i < size; i++) {
                if (((nums[i] >> j) & 0x1) == 0x1) {
                    bit_num[j] += 1; 
                }
            }   
            result |= ((bit_num[j] % 3) << j);  
        } 
        return result;
    }
}

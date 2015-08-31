/*#################################### Missing Number  #############################
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one
that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using
only constant extra space complexity?
################################################################################*/

// #####################################################################
// 思路分析：
// 最直接想法就是把 0 - n 这 n + 1 个数加起来, 然后减去数组中数字和. 
// 不过这种方法可能会溢出.
//
// 另外一种方法就很巧妙, A xor A = 0, A xor B xor A = (A xor A) xor B
// 由于只有一个数字 missing, 因此将所有数字和 0 - n 异或后一定等于 
// missing 的那个数字
//
//
// 易错点:
// 1) 第一种方法中 result 初始化应该为 size (n), 这样才是从 0 xor ... n 
// 2) 第二种方法中 size = n, (1 + size) * size / 2 是 项数 1 + size 乘以
// 首项加尾项 (0 + size) 再除以 2 
//
// 难点:
// 无 
//
// 复杂度分析:
// 时间: O(n)
// 空间: O(1)
// #####################################################################
public class Solution {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        int result = size;

        for (int i = 0; i < size; i++) {
            result ^= nums[i];
            result ^= i;
        }
        return result;
    }
}

public class Solution {
      public int missingNumber(int[] nums) {
        int size = nums.length, temp = 0;

        for (int i = 0; i < size; i++) {
            temp += nums[i];
        }

        return ((1 + size) * size / 2 - temp);
    }
}

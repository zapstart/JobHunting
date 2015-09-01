/*#################################### Remove Duplicates from Sorted Array `` ############################################# 
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter
what you leave beyond the new length.
#########################################################################################################################*/

// #############################################################################################
// 思路分析：
// 基本思路就是用两个指针, 如果遇到相同的, 遍历数组的指针依然 +1 而用于放置不相同数字的指针保持
// 不动.
//
// 易错点:
// 无
//
// 难点:
// 无
//
// 复杂度分析:
// 时间: O(n)
// 空间: O(1)
// #############################################################################################
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i, j = 1, array_size = nums.length;

        // 选择一个指针来放置不重复的数字
        if (array_size < 2) {
            return array_size;
        }
        else {
            for (i =  0; i < array_size - 1; i++) {
                if (nums[i] != nums[i + 1]) {
                    nums[j++] = nums[i + 1];
                }
            }
        }

        return j;
    }
}

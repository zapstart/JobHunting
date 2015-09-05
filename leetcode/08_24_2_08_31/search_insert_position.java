/*#################################### Search Insert Position  ###########################
Given a sorted array and a target value, return the index if the target is found. If not,
return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
########################################################################################*/

// #####################################################################
// 思路分析：
// 最简单直观的方法就是通过遍历数组, 如果哪一位大于等于 target 那么我们
// 就需要返回这个数字的 index 
// 方法二也是很直观, 直接用 binary search 就可以搞定了
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
// #####################################################################

// 方法1 
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int size = nums.length;

        if (size == 0) {
            return 0;
        }

        for (int i = 0; i < size; i++) {
            if (nums[i] >= target) return i;
        }

        return size;
    }
}

// 方法2 
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int size = nums.length;
        int lo = 0, hi = size - 1, mid;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) hi = mid - 1;
            else if (nums[mid] < target) lo = mid + 1;
            else return mid;
        }
        return lo;
    }
}

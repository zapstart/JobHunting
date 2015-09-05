/*#################################### Find Minimum in Rotated Sorted Array   #############
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
#########################################################################################*/

// #####################################################################
// 思路分析：
// 通过比较中间数字和最后数字来确定最小值的位置
// 如果 mid 小于 end, 这说明 mid - end 是有序的, min 在前半部分
// 反则 min 在后半部分  
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
public class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi, size = nums.length, mid = 0;
        hi = size - 1;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] < nums[hi]) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }

        return nums[hi];
    }
}

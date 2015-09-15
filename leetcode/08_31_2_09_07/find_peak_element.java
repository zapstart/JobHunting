/*#################################### Find Peak Element #############################
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the
peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should
return the index number 2.
####################################################################################*/

// #####################################################################
// 思路分析：
// 这道题是寻找极大值, 所用方法是 binary search
// 
// 方法一通过给出不同判断条件来筛选出我们要求的值. 
// 基本思路 3 点: 1) 如果中间数字大于其两边的, 则这个数字是我们要的
//                2) 如果其大于其后数字, 则在这个数字之前(包括这个数)一定
//                有极大值
//                3) 如果其小于后面数字, 则在其后数字中一定有极大值
// 在实现该方法时候, 除了这 3 种情况, 还有好些 case 需要考虑, 因此比较繁琐
//
// 方法二通过两个相邻指针来简化操作
// 只需要考虑方法一中的后两种情况即可.
// 在遍历数组时候不考虑 lo == hi 情况, 因为我们需要两个指针, 当 lo == hi 
// 时候, 数组已经遍历完成. 因此我们不需要 lo <= hi 而只是 lo < hi
//
// 易错点:
// 遍历结束条件是 <= 还是 <
//
// 难点:
//
// 复杂度分析:
// 时间: O(lgn)
// 空间: O(1)
// #####################################################################
public class Solution {
    // method 1
    public int findPeakElement(int[] nums) {
        int size = nums.length;
        int lo = 0, hi = size - 1, mid;

        if (size == 1) return 0;

        if (size == 2) {
            if (nums[0] > nums[1]) return 0;
            else if (nums[0] < nums[1]) return 1;
        }

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            if (mid == 0 && nums[mid] > nums[mid + 1]) return 0;
            else if (mid == 0 && nums[mid] < nums[mid + 1]) lo = mid + 1;
            else if (mid == size - 1 && nums[mid] > nums[mid - 1]) return size - 1;
            else if (mid == size - 1 && nums[mid] < nums[mid - 1]) hi = mid - 1;
            else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            else if (nums[mid] > nums[mid - 1] && nums[mid + 1] > nums[mid]) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    // method 2
    public int findPeakElement(int[] nums) {
        int size = nums.length;
        int lo = 0, hi = size - 1, mid;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            int mid_1 = mid;
            int mid_2 = mid_1 + 1;

            if (nums[mid_1] < nums[mid_2]) lo = mid_2;
            else hi = mid_1;
        }

        return lo;
    }    
}

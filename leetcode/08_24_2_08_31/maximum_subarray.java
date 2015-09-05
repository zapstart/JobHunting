/*#################################### Maximum Subarray  #################################
Find the contiguous subarray within an array (containing at least one number) which has the
largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
########################################################################################*/

// #####################################################################
// 思路分析：
// 这是一道经典算法题目. 参考以下 wiki 主页:
// https://en.wikipedia.org/wiki/Maximum_subarray_problema
// 该算法通过比较 (pre_max + nums[i]) 和　nums[i] 来判断新的 pre_max;
// 再用 pre_max 和 max_so_far 比较来确定到目前为止最大的 subarray 的值
// 举个例子: 
// -3 7 -5 10 -2 
// 1) 首先比较 -3 和 7, -3 + 7 < 7, temp = 7, max = 7
// 2) 7 + -5 > -5, temp = 2, max = 7
// 3) 2 + 10 > 10, temp = 12, max = 12
// 4) 12 + -2 > -2, temp = 10, max = 12 
//  
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
// #####################################################################
public class Solution {
    public int maxSubArray(int[] nums) {
        int size = nums.length;
        int temp = 0, max = 0;

        if (size == 0) return 0;
        if (size == 1) return nums[0];

        max = temp = nums[0];

        for (int i = 1; i < size; i++) {
            temp = (temp + nums[i] >= nums[i]) ? temp + nums[i] : nums[i];
            max = (max >= temp) ? max : temp;
        }

        return max;
    }
}

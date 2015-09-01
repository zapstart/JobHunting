/*#################################### Remove Element  ##################################
Given an array and a value, remove all instances of that value in place and return the
new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new
length.
#######################################################################################*/

// #####################################################################
// 思路分析：
// 这道题思路很清晰, 我们不用新建 array, 只需要有一个指针从头开始, 将与
// val 不同的数字放入数列并且最后返回其 index number 即可 
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
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        int lo = 0;

        for (int i = 0; i < size; i++) {
            if (nums[i] != val) {
                nums[lo++] = nums[i];
            }
        }
        return lo;
    }
}

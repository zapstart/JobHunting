/*#################################### Sort Colors  #############################
Given an array with n objects colored red, white or blue, sort them so that
objects of the same color are adjacent, with the colors in the order red, white
and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white,
and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array
with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
################################################################################*/

// #####################################################################
// 思路分析：
// 简单来说就是将 2 放到最后, 将 0 放到最前面, 中间的就是 1. 
//
// 易错点:
// one pass 中不用 if 用 while 这样对于 2 来说如果交换到 2 仍然可以继续
// 将其放置到最后.
// 比如 2 0 0 2, 第一次交换后仍然是 2 0 0 2, 然后再用 i 与 j 交换得到 0 0 2 2 
//      i     j                     i   j                             i j 
// 难点:
// 如何只用 one-pass algorithm 
//
// 复杂度分析:
// 时间: O(n)
// 空间: O(1)
// #####################################################################

// one pass 
public class Solution {
    public void sortColors(int[] nums) {
        int size = nums.length;
        int lo = 0, hi = size - 1;
        int temp;
        
        for (int i = 0; i < size; i++) {
            // 从左往右扫, 如果有 nums[i] 为 2 则我们将这个数字放置到后面
            // i < hi 保证只交换还没有交换的数字, 大于 hi 的位数我们
            // 已经交换了, 而 hi 这位数我们不需要再交换了
            while (nums[i] == 2 && i < hi) {
                temp = nums[i];
                nums[i] = nums[hi];
                nums[hi--] = temp;
            }
            
            // 从左往右扫, 如果有 nums[i] 为 0 则我们将这个数字放置到前面
            // i > lo 同样保证不会把 0 交换到已经排好序列的数字中
            while (nums[i] == 0 && i > lo) {
                temp = nums[i];
                nums[i] = nums[lo];
                nums[lo++] = temp;
            }
        }
    }
}

// two pass 
// 这种方法超级简单直观
void sortColors(int A[], int n) {
    int num0 = 0, num1 = 0, num2 = 0;

    for(int i = 0; i < n; i++) {
        if (A[i] == 0) ++num0;
        else if (A[i] == 1) ++num1;
        else if (A[i] == 2) ++num2;
    }

    for(int i = 0; i < num0; ++i) A[i] = 0;
    for(int i = 0; i < num1; ++i) A[num0+i] = 1;
    for(int i = 0; i < num2; ++i) A[num0+num1+i] = 2;
}

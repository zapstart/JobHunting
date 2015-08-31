/*  #################################### Product of Array Except Self ####################################
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the
product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space
for the purpose of space complexity analysis.)
########################################################################################################*/

// #####################################################################
// 思路分析：
// 这道题目最先想到的方法肯定是把所有数字乘起来然后根据 0 来除以该位数. 
// 这就是第二种简单解法. 
// 但是这道题不能用除法, 因此有一种巧妙的方法可以解决.
// 
// 如果能将B[4] 与 C[4] 相乘, 则其积就是我们要的结果
// A[4] = [a0, a1, a2, a3] 
// B[4] = [1, a0, a0 * a1, a0 * a1 * a2] 
// C[4] = [a1 * a2 * a3, a2 * a3, a3, 1]
// 
// 下面link给出了详细的解答:
// http://stackoverflow.com/questions/2680548/given-an-array-of-numbers-return-array-of-products-of-all-other-numbers-no-div 
//
// 易错点:
// 
// 难点:
// 如何想到这种方法值得思考 
//
// 复杂度分析:
// 时间: O()
// 空间: O()
// #####################################################################
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length, tmp = 1;
        int[] result = new int[size];
        result[0] = 1;

        for (int i = 1; i < size; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }
}

// 该方法使用除法, 不满足要求
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int temp = 1, zero = 0;

        for (int num : nums) {
            if (num == 0) {
                zero++;
            }
            else {
                temp *= num;
            }
        }

        for (int i = 0; i < size; i++) {
            if (zero == 1 && nums[i] == 0) nums[i] = temp;
            else if (zero == 1 && nums[i] != 0) nums[i] = 0;
            else if (zero > 1) nums[i] = 0;
            else nums[i] = temp / nums[i];
        }
        return nums;
    }
}

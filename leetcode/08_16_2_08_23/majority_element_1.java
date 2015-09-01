/*#################################### Majority Element ##############################################
Given an array of size n, find the majority element. The majority element is the element that a
ppears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
####################################################################################################*/

// #############################################################################################
// 思路分析：
// 这道题主要 2 种做法, 第一种是排序, 然后排序后中间那个数字就是 majority element
// 第二种是多数投票算法, 该算法可以找出 majority element 如果有的话.
//
// 6 Suggested Solutions in C++ with Explanations
// https://leetcode.com/discuss/42929/6-suggested-solutions-in-c-with-explanations
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
    public int majorityElement(int[] nums) {

        // 方法1: Boyer-Moore Majority Vote Algorithm
        // 多数投票算法
        // 该算法用于确定是否有数超过 floor(n / 2)
        //
        // 第一步: 首先遍历 array 来找最有可能的"出现最多的数", 当然, 这个数不一定是
        // majority 数
        // 第二步: 再次遍历 array 来确定这个数字出现的次数是不是真的大于 floor(n / 2)
        // ps: 由于这道题中的 array 一定存在 majority 数, 我们用第一步就够了
        //
        // 该算法思想就是遇到不同的数字就抵消一个 vote 数之前增加的个数, 下面的例子能比较
        // 好的说明这是什么意思
        //
        // example:
        // ABCBDBEBFB
        // 该算法第一步求出F是最可能的数,
        // 第二步验证不对
        //
        // ABCBDBEBFBB
        // 该算法第一步求出B是最可能的数,
        // 第二步验证确实是
        //
        // 时间复杂度: O(n)
        int count = 0, size = nums.length, vote = nums[0];

        for (int i = 0; i < size; i++) {
            if (count == 0) {
                vote = nums[i];
                count++;
            }
            else {
                if (nums[i] != vote) {
                    count--;
                }
                else {
                    count++;
                }
            }
        }

        return vote;
    }


    public int majorityElement(int[] nums) {

        // 方法2: 先排序, 然后直接返回
        // 时间复杂度: O(nlogn)
        int array_size = nums.length;

        Arrays.sort(nums);
        return nums[array_size / 2];
    }
}

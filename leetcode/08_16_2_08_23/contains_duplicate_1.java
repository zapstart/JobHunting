/*#################################### Contains Duplicate ############################################
Given an array of integers, find if the array contains any duplicates. Your function should return
true if any value appears at least twice in the array, and it should return false if every element is
distinct.
####################################################################################################*/

// #############################################################################################
// 思路分析：
// 第一种思路就是排序后遍历数组, 如果有 duplicated 则返回 true
// 第二种方法就是用 set 来解决这个问题, 如果该元素已经在 set 中了, 则再添加
// 该元素会返回 false, 在这种情况下, 我们就可以知道有 duplicate 数了.  
//
// 易错点:
// 无
//
// 难点:
// 无 
//
// 复杂度分析:
// 时间: O(n) 
// 空间: O(n) 
// #############################################################################################
public class Solution {
    // 方法1:
    // 时间复杂度 O(nlogn)
    public boolean containsDuplicate(int[] nums) {
        int array_size = nums.length;

        if (array_size == 0 || array_size == 1) {
            return false;
        }
        else {
            Arrays.sort(nums);
            for (int i = 0; i < array_size - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    return true;
                }
            }
            return false;
        }
    }

    // 方法2:
    // 时间复杂度 O(n)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums) {
            if(!set.add(i)) {
                return true;
            }
        }
        return false;
    }
}

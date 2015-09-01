/*#################################### Rotate Array  ##################################
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
[5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to
solve this problem.
#####################################################################################*/

// #####################################################################
// 思路分析：
// 最先的思路很简单, 创建一个长度为 k % array_size 的数组, 然后将最后 k 
// 个数移出来, 再移动剩下的, 最后将这几个移出的数字放在远数组前面. 这就
// 是方法 1
//
// 方法二是用基本的移位思想, 如果要右移 k 步, 则只需要
// 1) 翻转整个数列
// 2) 翻转 [0 : k - 1]
// 3) 翻转 [k : n - 1]
//
// 易错点:
// 无 
//
// 难点:
// 无
//
// 复杂度分析:
// 时间: O(n)
// 空间: O(1) - 方法 2
// #####################################################################
public class Solution {
    public void rotate(int[] nums, int k) {
        int array_size = nums.length;
        int j = 0;

        k = k % array_size;
        int[] new_num = new int[k];

        for (int i = array_size - k; i < array_size; i++){
            new_num[j++] = nums[i];
        }

        for (int i = array_size - 1; i > k - 1; i--){
            nums[i] = nums[i - k];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = new_num[i];
        }

    }
}

public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1){
            return;
        }
        //step each time to move
        int step = k % nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,step - 1);
        reverse(nums,step,nums.length - 1);
    }

    //reverse int array from n to m
    public void reverse(int[] nums, int n, int m){
        while(n < m){
            nums[n] ^= nums[m];
            nums[m] ^= nums[n];
            nums[n] ^= nums[m];
            n++;
            m--;
        }
    }
}

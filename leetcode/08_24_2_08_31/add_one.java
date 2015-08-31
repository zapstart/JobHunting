/*#################################### Valid Parentheses  #############################
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
#####################################################################################*/

// #####################################################################
// 思路分析：
// 用传统模拟方法比较慢, 这种方法遇到 9 且需要进位时候置该位为 0, 否则
// 将该位 +1 并返回值.
// 如果最高位要进位, 则新建一个 array 然后置最高为为 1.
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
// #####################################################################
public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return new int[0];
        }

        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }else{
                digits[i] = 0;
            }
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
}

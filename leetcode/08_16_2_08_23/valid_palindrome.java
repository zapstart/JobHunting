/*#################################### Remove Duplicates from Sorted Array `` ################################
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
############################################################################################################*/

// #############################################################################################
// 思路分析：
// 设置两个指针, 分别向中间移动直到相遇, 如果出现字母不一样, 则返回 false, 否则返回 true 
// 要用到两个库函数: Character.isLetterOrDigit() 以及 Character.toLowerCase() 
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
    public boolean isPalindrome(String s) {
        int string_size, i, j;

        string_size = s.length();
        i = 0;
        j = string_size - 1;

        if (string_size == 0 || string_size == 1) {
            return true;
        }

        while (i < j) {
            while (i < j && (!Character.isLetterOrDigit(s.charAt(i)))) {
                i++;
            }
            while (i < j && (!Character.isLetterOrDigit(s.charAt(j)))) {
                j--;
            }

            if (i < j) {
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
                else {
                    i++;
                    j--;
                }
            }
        }
        return true;
    }
}

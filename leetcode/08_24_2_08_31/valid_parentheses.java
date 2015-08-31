/*#################################### Valid Parentheses  #############################
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine
if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]"
and "([)]" are not.
#####################################################################################*/

// #####################################################################
// 思路分析：
// 经典的栈匹配操作，左符号入栈，右符号出栈,最后检查栈是否为空
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
    public boolean isValid(String s) {
        Stack<Character> parentheses = new Stack<Character>();
        int size = s.length();
        int i = 0;

        while (i < size) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                    parentheses.push(s.charAt(i));
            }

            if (s.charAt(i) == ')') {
                if (parentheses.empty() || (!parentheses.empty() && parentheses.pop() != '(')) {
                    return false;
                }
            }

            if (s.charAt(i) == '}') {
                if (parentheses.empty() || (!parentheses.empty() && parentheses.pop() != '{')) {
                    return false;
                }
            }

            if (s.charAt(i) == ']') {
                if (parentheses.empty() || (!parentheses.empty() && parentheses.pop() != '[')) {
                    return false;
                }
            }

            i++;
        }

        return parentheses.empty();
    }
}

/*#################################### Longest Common Prefix  #########################
Write a function to find the longest common prefix string amongst an array of strings.
#####################################################################################*/

// #####################################################################
// 思路分析：
// 用第一个数组的 item 作为参考, 从第二个 item 开始依次比较每个字符.
// 如果第一个 item 取到位数大于第 j 个 item 的长度或者字符不一样, 则
// 返回之前最长的 common prefix.
//
// 易错点:
// substring(a, b) 返回[a, b - 1]
// substring(0, 0) 返回""
//
// 难点:
// 无
//
// 复杂度分析:
// 时间: O(n^2)
// 空间: O(1)
// #####################################################################
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, strs[0].length());
    }
}

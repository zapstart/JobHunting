/*  #################################### Valid Anagram ###########################
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
################################################################################*/

// ###############################################################################
// 思路分析：
// 要判断两个 string 是否含有相同的字母，我们只需要两个长度为26的 array 作为 map 
// 来存储遇到的所有小写字母. 如果这两个 array 完全相同，则我们认为这个 anagram 
// 是 valid
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
// ###############################################################################
public class Solution {
    // use hashtable is more efficient
    public boolean isAnagram(String s, String t) {
        int[] map_1 = new int[26];
        int[] map_2 = new int[26];
        int s_size = s.length();
        int t_size = t.length();

        if (s_size != t_size) {
            return false;
        }
        else {
            for (int i = 0; i < s_size; i++) {
                map_1[s.charAt(i) - 'a'] += 1;
            }

            for (int i = 0; i < t_size; i++) {
                map_2[t.charAt(i) - 'a'] += 1;
            }

            for (int i = 0; i < 26; i++) {
                if (map_1[i] != map_2[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}

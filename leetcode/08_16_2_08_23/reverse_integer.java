public class Solution {
    public int reverse(int x) {
        // int 是有符号数
        // 用一个比 int 位数更多的数来接受运算结果
        // 这样可以避免发生 overflow
        long j = 0;

        while (x != 0) {
            j = j * 10;
            j = (j + (x % 10));
            x /= 10;

            // 有符号数最大与最小
            if (j > 0x7FFFFFFF || j < 0x80000000) {
                return 0;
            }
        }

        return (int) j;
    }
}

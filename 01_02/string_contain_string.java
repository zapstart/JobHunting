// 这两种方法不适合处理同时有大小写的情况
class string_contain_string {
    
    public string_contain_string() {
    } 
    // ############################################### 
    // Method 1 : we first sort string_A and string_B
    //            and determine A contains B
    // Time  : O(NlgN + MlgM + M + N) 
    // Space : O(1)   
    // ############################################### 
    public boolean contain_1(char[] string_1, char[] string_2) { 
        int size_1, size_2;    
        int index_1 = 0, index_2 = 0; 
        size_1 = string_1.length; 
        size_2 = string_2.length; 
        
        // quick_sort(string_1); 
        // quick_sort(string_2); 
        // string_1 and string_2 are already sorted
        
        if (size_1 > 0 && size_2 > 0) { 
            for (index_2 = 0; index_2 < size_2; ) {
                while (index_1 < size_1 && string_1[index_1] < string_2[index_2]) {
                    index_1++; 
                }
                if (string_1[index_1] > string_2[index_2]) {
                    return false; 
                } 
                // index_1 should not add 1 since string_2 may have same characters 
                index_2++; 
            }
            return true; 
        }
        else {
            return false; 
        }
    }
    
    // ############################################### 
    // Method 2 : 
    // Time  : O(m + n) 
    // Space : O(1)   
    // ############################################### 
    public boolean contain_2(char[] string_1, char[] string_2) { 
        int size_1, size_2;
        int index_1 = 0, index_2 = 0;
        int hash = 0;

        if (string_1.length > 0 && string_2.length > 0) {
            for (index_1 = 0; index_1 < string_1.length; index_1++) {
                hash |= (1 << (string_1[index_1] - 'a'));
            } 

            for (index_2 = 0; index_2 < string_2.length; index_2++) {
                if ((hash & (1 << (string_2[index_2] - 'a'))) == 0) {
                    return false; 
                } 
            } 

            return true;
        }
        else {
            return false; 
        }
    } 
        
    public static void main(String[] args) {
        char[] string_1 = {'a', 'b', 'c', 'e', 'e', 'e', 'f'};       
        char[] string_2 = {'a', 'e', 'e', 'f'};       
        char[] string_3 = {'a', 'b', 'c', 'e', 'e', 'e', 'f'};       
        char[] string_4 = {'a', 'b', 'c', 'e', 'e', 'e', 'f'};       
        char[] string_5 = {}; 
        char[] string_6 = {'a', 'b', 'c', 'e', 'e', 'e', 'f'};       
        
        string_contain_string test = new string_contain_string(); 
        System.out.println(test.contain_1(string_1, string_2));
        System.out.println(test.contain_1(string_3, string_4));
        System.out.println(test.contain_1(string_5, string_6));
        
        System.out.println(test.contain_2(string_1, string_2));
        System.out.println(test.contain_2(string_3, string_4));
        System.out.println(test.contain_2(string_5, string_6));
    }
}

class longest_palindrome {
    private int length;
    private int index;

    public longest_palindrome() {
        this.length = 0;
        this.index = -1;
    } 
   
    // ############################################ 
    // choose every point as middle point to find 
    // the longest palindrome. 
    // there are two cases: odd and even 
    // 
    // Time : O(n ^ 2) 
    // ############################################ 
    public void method_1(char[] string, int size) {
        int max_odd = 0; 
        int max_even = 0; 
        int temp = 0;
        int index_odd = 0;
        int index_even = 0;

        if (size == 0) {
            System.out.println("Invalid input string!!!");  
        }
        else {
            // odd case   
            for (int i = 0; i < size; i++) {
                temp = 0;
                for (int j = 1; (i - j >= 0) && (i + j < size); j++) {
                    if (string[i - j] == string[i + j]) {
                        temp++; 
                    } 
                }
                
                if (temp >= max_odd) {
                    max_odd = temp;
                    index_odd = i;
                }
            }
            //even case 
            for (int i = 0; i < size; i++) {
                temp = 0;
                for (int j = 0; (i - j >= 0) && (i + 1 + j < size); j++) {
                    if (string[i - j] == string[i + 1 + j]) {
                        temp++; 
                    } 
                }

                if (temp >= max_even) {
                    max_even = temp; 
                    index_even = i;
                }
            }
        this.length = (max_odd * 2 + 1) >= (max_even * 2) ? max_odd * 2 + 1 : max_even * 2;   
        this.index = (max_odd * 2 + 1) >= (max_even * 2) ? index_odd : index_even;   
        System.out.println("Max length = " + this.length);
        System.out.println("index = " + this.index);
        }
    } 
    
    // ############################################ 
    // choose every point as middle point to find 
    // the longest palindrome. 
    // there are two cases: odd and even 
    // 
    // Time : O(n ^ 2) 
    // ############################################ 
    public void method_2(char[] string, int size) {
    }

    // ############################################ 
    // Test cases here 
    // ############################################ 
    public static void main(String[] args) {
        char[] string_1 = {'a', 'b', 'c', 'b', 'a', 'd'}; 
        char[] string_2 = {'a', 'b', 'c', 'd', 'a', 'd'}; 
        char[] string_3 = {}; 
        char[] string_4 = {'a', 'b', 'a', 'a', 'b', 'a'}; 
        
        longest_palindrome test = new longest_palindrome();
        test.method_1(string_1, string_1.length);
        System.out.println();
        test.method_1(string_2, string_2.length);
        System.out.println();
        test.method_1(string_3, string_3.length);
        System.out.println();
        test.method_1(string_4, string_4.length);
    }
}

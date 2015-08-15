class is_palindrome{
    public is_palindrome() {
    } 
     
    public boolean from_mid(String string, int n) {
        int left, right;
        int del;
        
        if (string == null || n < 1) {
            return false; 
        } 
        else {
            del = (n / 2 - 1) >= 0 ? n / 2 - 1 : 0;
            left  = del;
            right = n - 1 - del;       
            while(left >=0 && right <= n - 1) {
                if (string.charAt(left) != string.charAt(right)) {
                    return false; 
                }
                left--;
                right++; 
            }
            return true; 
        }
    } 
    
    public static void main(String[] args) {
        String test_1 = "whattahw"; 
        String test_2 = ""; 
        String test_3 = "abcdedcba"; 
        String test_4 = "ebcdedcbe"; 
        
        is_palindrome test = new is_palindrome(); 
        System.out.println(test.from_mid(test_1, test_1.length()));
        System.out.println(test.from_mid(test_2, test_2.length()));
        System.out.println(test.from_mid(test_3, test_3.length()));
        System.out.println(test.from_mid(test_4, test_4.length()));
    }
}

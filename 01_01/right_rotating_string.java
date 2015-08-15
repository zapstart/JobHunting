class right_rotating_string {
    private int array_length; 
    private char[] rotate_string = new char[array_length];
    
    public right_rotating_string(int length, char[] test_string) {
        this.array_length = length;
        this.rotate_string = test_string;  
    } 
    
    // ################# Method 1 #################   
    // Time  : O(m * n)
    // Space : M(1) 
    // ################# Method 1 #################   
    public char[] right_rotating_1_item(char[] rotate_string) {
        char first_item;
        first_item = rotate_string[0];
        
        for (int i = 0; i < this.array_length- 1; i++) {
            rotate_string[i] = rotate_string[i + 1];
        }
        rotate_string[this.array_length - 1] = first_item;
        return rotate_string; 
    }

    public char[] right_rotating_all_items_1(int rotate_num) {
        for (int i = 0; i < rotate_num; i++) {
            this.rotate_string = right_rotating_1_item(this.rotate_string);     
        } 
        return this.rotate_string;
    }  
    
    // ################# Method 2 #################   
    // Time  : O(n)
    // Space : M(1) 
    // ################# Method 1 #################   
    public void reverse_string(int start, int end) {
        char temp;  
        while (start < end) {
            temp = this.rotate_string[start]; 
            this.rotate_string[start++] = this.rotate_string[end];
            this.rotate_string[end--] = temp; 
        }
    } 
    
    public char[] right_rotating_all_items_2(int rotate_num) {
        reverse_string(0, rotate_num - 1); 
        reverse_string(rotate_num, this.array_length - 1); 
        reverse_string(0, this.array_length - 1); 
        return this.rotate_string;
    } 


    // ################# TEST #################   
    // Test cases  
    // ################# TEST #################   
    public static void main(String[] args) {
        char[] test_string = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        right_rotating_string test = new right_rotating_string(7, test_string); 
        //System.out.println(test.right_rotating_all_items_1(2)); 
        System.out.println(test.right_rotating_all_items_2(3)); 
    }
}

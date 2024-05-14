class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return isPallindrome(s,left,right-1)||isPallindrome(s,left+1,right);
            }
            left++;
            right--;
        }

        return true;
    }

    public boolean isPallindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
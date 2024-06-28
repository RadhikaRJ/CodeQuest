class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        int start = 0;
        while(start<n){
           
           if(n-start<k){
            s= reverseString(start,n-1,s);
            break;
           }
           else{
            s= reverseString(start, start+k-1,s);
            
            start=start+(2*k);
           }
            

            

        }

        return s;
    }

    public String reverseString(int start, int end, String s){
        char[] sCharArray = s.toCharArray();

        while(start<end){
            char temp = sCharArray[start];
            sCharArray[start] = sCharArray[end];
            sCharArray[end] = temp;
            start++;
            end--;
        }

        return new String(sCharArray);
    }
}
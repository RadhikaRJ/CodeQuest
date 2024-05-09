class Solution {
    public int lengthOfLongestSubstring(String s) {
        //start = 0, end = 0 set[abc] l=e-s = 3
        //0 1 2 3 4 5 6 7
        //t m m z u x t
        //s       e --> contains...move s forward till charAt(s)!=charAt(e), s++
        //   
        //  s e 
        //.   s
        //[ m]
        int start = 0, end = 0;
        int maxLength = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();

        while(end<n){
            if(set.contains(s.charAt(end))){
                while(start<end && s.charAt(start)!=s.charAt(end)){
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
            else{
                set.add(s.charAt(end));
                maxLength = Math.max(maxLength, end-start+1);
            }
            end++;
        }

        return maxLength;

    }
}
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int s_len = s.length();
        int t_len = t.length();

        if(s_len > t_len) return isOneEditDistance(t,s);

        if(t_len-s_len>1) return false;

        for(int i=0;i<s_len;i++){
            if(s.charAt(i)!=t.charAt(i)){
                if(s_len == t_len){
                    return s.substring(i+1).equals(t.substring(i+1));
                }
                else{
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }

        return s_len+1 == t_len;
    }
}
class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int len = word.length();
        while(i<len){
            if(word.charAt(i) == ch)
            break;
            i++;
        }
        if(i==len) return word;
        sb.append(word.substring(0,i+1));
        sb.reverse();
        sb.append(word.substring(i+1));
        return sb.toString();
    }
}
class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] frequency = new int[26];
        for(char c : sentence.toCharArray()){
            frequency[c-'a']++;
        }

        for(int freq:frequency){
            if(freq==0){
                return false;
            }
        }

        return true;
    }
}
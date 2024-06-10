class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int n = word.length();
          int i=0, j=1;
          //a  a  a  a  a  a
          //97 97 97 97 97 97
          //                     j
          //
          int operations = 0;
          while(j<n){
           
            if(Math.abs(word.charAt(j)-word.charAt(j-1))<=1){
                j++;
               operations++;


            }
            j++;

          }

          return operations;
    }
}
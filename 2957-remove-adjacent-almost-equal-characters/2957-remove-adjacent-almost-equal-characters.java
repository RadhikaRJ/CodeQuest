class Solution {
    public int removeAlmostEqualCharacters(String word) {
        //aa
        //ab
        //int firstChar= (a-'0') 
        //int secondChar= (b-'0')
        //diff <=1 -> identiofy if they are equal or almost equal
        //replaceCharValue = Math.max(1st char,2nd char) +2;
        //


        
        //[b, a, b, a, d ]
        //[98,97,98,97, 100]
        //[0, 1, 1, 1, 1,1 ,3,1,3,6,1]
        // 0, 1,,,2,,3,,4,5,6,7,8,9,10,11
        // i.                 j
        //                          i
        //                            j

      //  5/2 = 2
     //   6/2 = 3
       //
      
        //bdbdf ==min operations

        int n = word.length();

        int[] charDiff = new int[n];
        char[] wordCharArray = word.toCharArray();
        charDiff[0] =0;
        for(int i=1;i<n;i++){
            charDiff[i] = Math.abs(wordCharArray[i]-wordCharArray[i-1]);
        }


        int maxSubArrayLength = 0;
        int operations = 0;


        int i=0, j=1;
        while(j<n){
           
            while(j<n && Math.abs(wordCharArray[j]-wordCharArray[j-1])<=1 ){
                j++;
            }

            operations += (j-i)/2;
            i=j;
            j++;

        }

        operations +=(j-i)/2;
        return operations;





        
    }
}
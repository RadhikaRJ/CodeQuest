class Solution {
    public boolean makePalindrome(String s) {
        int len = s.length();
        String leftHalf = "", rightHalf="";
        int noMatchCounter = 0;

        if(len%2==0){
            leftHalf = s.substring(0,(len/2));
            System.out.println("leftHalf: "+leftHalf);

            rightHalf = s.substring((len/2));
            System.out.println("rightHalf: " + rightHalf);
        }
        else{
            leftHalf = s.substring(0,(len/2));
            System.out.println("leftHalf: "+leftHalf);
            rightHalf = s.substring((len/2)+1);
            System.out.println("rightHalf: " + rightHalf);
        }

       

        int left=0;
        int right = rightHalf.length()-1;
        while(left<leftHalf.length()){
            if(leftHalf.charAt(left)!=rightHalf.charAt(right)){
                noMatchCounter++;
            }
            left++;
            right--;
        }


        return (noMatchCounter <=2);

    }
}
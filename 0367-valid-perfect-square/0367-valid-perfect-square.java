class Solution {
    public boolean isPerfectSquare(int num) {
       //Use Binary Search
       if(num<2){
        return true;
       }

       long left = 2, right =num/2, x, calculatedSquare;
       while(left<=right){
            x= left+(right-left)/2;
            calculatedSquare = x*x;
            if(calculatedSquare == num){
                return true;
            }
            if(calculatedSquare>num){
                right = x-1;
            }
            else{
                left = x+1;
            }
       }

       return false;
    }
}

/**
Bruteforce TLE approach:
 boolean isPerfect = true;
        int i=1;
        while(isPerfect){
            if(i*i==num){
                return isPerfect;
            }
            else if(i*i>num){
                return false;
            }
            else{
                i++;
            }
        }

        return isPerfect;

 */
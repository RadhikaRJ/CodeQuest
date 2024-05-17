class Solution {
    public int singleNumber(int[] nums) {
        
        //O(n) space complexity approach
        //use hash map to store all digit,frequency
        //linear time complexity as 1 iteration to store number & update fequency
        //1 iteration to return digit with freq=1

        //a^a=0
        //a^a^a=a

        int bitSum = 0;
        int lonerNum = 0;

        for (int shift = 0; shift < 32; shift++) {
            bitSum = 0;
            for (int num : nums) {
                bitSum += (num >> shift) & 1;
            }
            int lonerbit = bitSum % 3;
            lonerNum = lonerNum | (lonerbit << shift);

        }
        return lonerNum;
        
    }
}
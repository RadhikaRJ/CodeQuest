class Solution {
    public int calculate(String s) {
        //without stack optimized approach

        if(s==null || s.isEmpty()) return 0;

        int len = s.length();
        int result = 0, currentNumber = 0, lastNumber = 0;
        char operation = '+';

        for(int i=0;i<len;i++){
            char currentChar = s.charAt(i);
            if(Character.isDigit(currentChar)){
                currentNumber = (currentNumber*10)+(currentChar-'0');
              
            }
            if(!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar)||i==len-1){
                if(operation == '+' || operation == '-'){
                    result+=lastNumber;
                    lastNumber= (operation=='+')?currentNumber:-currentNumber;
                }
                else if(operation == '*'){
                    lastNumber = lastNumber*currentNumber;
                }
                else if(operation == '/'){
                    lastNumber = lastNumber/currentNumber;
                }
                operation = currentChar;
                currentNumber =0;

            }
        }

        result+=lastNumber;
        return result;
    }
}
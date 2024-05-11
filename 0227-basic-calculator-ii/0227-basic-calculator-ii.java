class Solution {
    public int calculate(String s) {

        if(s == null || s.isEmpty()) return 0;

        int len = s.length();

        char operation = '+';
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;

        for(int i=0;i<len;i++){
            char currentChar = s.charAt(i);
            if(Character.isDigit(currentChar)){
                currentNumber = (currentNumber*10)+(currentChar-'0'); //forming the number. Multiplication by 10 incase the number is greater than 9
            }
            if(!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar)|| i==len-1){
              
                if(operation == '+'||operation == '-'){
                    stack.push((operation=='+')?currentNumber:-currentNumber);
                }
                else if(operation == '*'){
                    stack.push(stack.pop()*currentNumber);
                }
                else if(operation == '/'){
                    stack.push(stack.pop()/currentNumber);
                }

                operation = currentChar;
                currentNumber = 0;
            }
        }

        int result = 0;
        while(!stack.isEmpty()){
            result+=stack.pop();
        }

        return result;

    }
}
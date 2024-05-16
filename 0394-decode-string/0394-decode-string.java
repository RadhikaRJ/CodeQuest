class Solution {
    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder currString = new StringBuilder();

        int currentNumber = 0;
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
               currentNumber= (currentNumber*10)+ (c-'0');
            }
            else if(c == '['){
                numberStack.push(currentNumber);
                stringStack.push(currString);

                currString = new StringBuilder();
                currentNumber = 0;
            }
            else if(c==']'){
                StringBuilder decodedString = stringStack.pop();
                for(int count = numberStack.pop();count>0;count--){
                    decodedString.append(currString);
                }
                currString = decodedString;
            }
            else{
                currString.append(c);
            }
        }

        return currString.toString();
    }
}
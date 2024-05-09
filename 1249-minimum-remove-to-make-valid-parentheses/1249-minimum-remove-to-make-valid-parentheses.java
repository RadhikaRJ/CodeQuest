class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb =  new StringBuilder();
        Stack<Character> stack = new Stack<Character>();

        int openCount = 0, closeCount = 0;

        for(char c: s.toCharArray()){
            if(c == '('){
                openCount++; 
                stack.push(c); 
            }
            else if(c == ')'){
                closeCount++;
                if(closeCount<=openCount){
                    stack.push(c);
                }
                else{
                    closeCount--;
                    continue;
                }
            }
            else{
                stack.push(c); //ab(c)d
            }
        }

        while(!stack.isEmpty()){
            char c = stack.pop();
            if(c=='(' && openCount > closeCount){
                openCount--;
            }
            else{
                sb.append(c);
            }
           
        }

        return sb.reverse().toString();





    }
}
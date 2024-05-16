class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> operations = new HashSet(Set.of("+","-","*","/"));
        for(String token:tokens){
            if(!operations.contains(token)){
                stack.push(token);
            }
            else{
                int firstNumber = Integer.parseInt(stack.pop());
                int secondNumber = Integer.parseInt(stack.pop());
                switch(token){
                    case "+" :
                    stack.push(String.valueOf(firstNumber+secondNumber));
                    break;

                    case "-":
                    stack.push(String.valueOf(secondNumber-firstNumber));
                    break;

                    case "/":
                    stack.push(String.valueOf(secondNumber/firstNumber));
                    break;

                    case "*":
                    stack.push(String.valueOf(secondNumber*firstNumber));
                    break;
                }

            }
        }

        return Integer.parseInt(stack.pop());
    }
}
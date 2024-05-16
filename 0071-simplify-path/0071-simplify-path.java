class Solution {
    public String simplifyPath(String path) {

        String[] tokens = path.split("/");
        System.out.println(Arrays.toString(tokens));
        StringBuilder sb = new StringBuilder();
        sb.append("/");

        Stack<String> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals(".")||tokens[i].equals(" ")){
                continue;
            }
            else if(tokens[i].equals("..") && !stack.isEmpty()){
                stack.pop();

            }
            else {

                if(!tokens[i].isEmpty() && !tokens[i].equals("..")){
                     stack.push(tokens[i]);
                }
               
            }
        }

        Stack<String> reverseOrder = new Stack<>();
        while(!stack.isEmpty()){
            reverseOrder.push(stack.pop());
        }

        int stackSize = reverseOrder.size();
        for(int i=0;i<stackSize;i++){
            sb.append(reverseOrder.pop());
            if(i<stackSize-1){
                sb.append("/");
            }
            
        }

        return sb.toString();

    }
}
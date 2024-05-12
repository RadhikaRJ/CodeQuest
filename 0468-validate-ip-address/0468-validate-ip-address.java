class Solution {
    public String validIPAddress(String queryIP) {
        if(queryIP==null||queryIP.isEmpty()||queryIP.length()==0){
            return "Neither";
        }
        Set<Character> num_set = new HashSet<>(Set.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
      
        boolean isValidIPv4 = verifyForIPv4(queryIP, num_set);
        boolean isValidIPv6 = isValidIPv4?false: verifyForIPv6(queryIP, num_set);

        if(isValidIPv4){
            return "IPv4";
        }
        else if(isValidIPv6){
            return "IPv6";
        }
        else return "Neither";

    }

    public boolean verifyForIPv4(String queryIP,Set<Character> num_set){
        if(queryIP.charAt(queryIP.length()-1)=='.')return false;
        String[] xset = queryIP.split("\\.");
        
        if(xset.length!=4){
            return false;
        }

        for(String x:xset){
             if(x.length()==0)return false;
            boolean isInitial = true;
            if(x.length()>3){
                return false;
            }

            int number=0;
            for(int i=0;i<x.length();i++){
                if(x.charAt(0)=='0' && x.length()>1){
                    return false;
                }
                else{
                    if(!num_set.contains(x.charAt(i))) return false;
                    number = (number*10)+(x.charAt(i)-'0');
                    
                }
                if(number>255){
                    return false;
                }
            }

        }
        return true;

    }

    public boolean verifyForIPv6(String queryIP, Set<Character> num_set){
        Set<Character> hex_set = new HashSet<>(Set.of('a','b','c','d','e','f','A','B','C','D','E','F'));
        if(queryIP.charAt(queryIP.length()-1)==':')return false;
        String[] xset = queryIP.split(":");
        if(xset.length!=8){
            return false;
        }
        for(String x:xset){
            if(x.length()>4){
                return false;
            }
           
            for(char c:x.toCharArray()){
                if(!num_set.contains(c) && !hex_set.contains(c)){
                    return false;
                }
            }
        }

        return true;
    }
}
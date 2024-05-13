class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if(s==null||s.length()==0|| s.length()<10){
            return result;
        }
//A A A A A C C C C C AAAAA C CCCC CAAAAAGGGT TT
//0,1,2,3,4,5,6,7,8,9,10,11,12
//A A A A A A A A A A A
//
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<=s.length()-10;i++){
            String dna = s.substring(i,i+10);
            map.put(dna,map.getOrDefault(dna,0)+1);
        }

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()>1){
                result.add(entry.getKey());
            }
        }

        return result;

    }
}
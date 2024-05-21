class Solution {
    public String customSortString(String order, String s) {

        // HashMap
        Map<Character, Integer> map = new HashMap<>();
        // adcbaccabd
        // a:0
        // b:0
        // c:0
        // d:2
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                int freq = map.get(c);
                freq++;
                map.put(c, freq);
            } else {
                map.put(c, 1);
            }
        }

        System.out.println(map);

        StringBuilder permutedS = new StringBuilder();
        for (char c : order.toCharArray()) {// order = cba
            if(map.containsKey(c))
            {
                 int freq = map.get(c); // c
                 while (freq > 0) {
                    permutedS.append(c);// cccbbaaa
                    freq--;
                }
                map.remove(c);
            }
           
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char k = entry.getKey();
            int freq = map.get(k);
            while (freq > 0) {
                permutedS.append(k);
                freq--;
            }

        }

        return permutedS.toString();

        // return "";
    }
    /**
     * order = cba
     * s = adcbaccabd
     * ->
     * 
     * sort - > aaabbcccdd
     * map c:0
     * a:0
     * b:0
     * d:2
     * 
     * cccbbaaadd
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * current->before
     * orderString:
     * a->b
     * b->c
     * 
     * encounter alphabet not in order: continue
     * 
     * 
     */
}
class Solution {
    public String reorganizeString(String s) {

        int[] charFrequency = new int[26];
        for (char c : s.toCharArray()) {
            charFrequency[c - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->Integer.compare(b[1],a[1]));

        for(int i=0;i<26;i++){
            if(charFrequency[i]>0){
                pq.offer(new int[]{i+'a',charFrequency[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] first = pq.poll();
            if(sb.length()==0 || first[0]!=sb.charAt(sb.length()-1)){
                sb.append((char)first[0]);
                if(--first[1]>0){
                    pq.offer(first);
                }
               
            }
            else{
                if(pq.isEmpty()){
                    return "";
                }

                int[] second = pq.poll();
                sb.append((char)second[0]);
                if(--second[1] > 0){
                    pq.offer(second);
                }

                pq.offer(first);
            }
        }

        return sb.toString();

    }
}
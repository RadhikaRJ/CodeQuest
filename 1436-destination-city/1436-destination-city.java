class Solution {
    public String destCity(List<List<String>> paths) {
       
       Map<String,String> map = new HashMap<>();
       String finalDestination = "";
        for(List<String> path:paths){
            String source = path.get(0);
            String destination = path.get(1);
            map.put(source, destination);
        }

        for(List<String> path:paths){
            String destination = path.get(1);
            while(map.containsKey(destination)){
                destination = map.get(destination);
            }
            finalDestination = destination;
            break;

        }

       return finalDestination;

    }
}
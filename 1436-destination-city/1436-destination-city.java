class Solution {
    public String destCity(List<List<String>> paths) {
       
    //    Map<String,String> map = new HashMap<>();
    //    String finalDestination = "";
    //     for(List<String> path:paths){
    //         String source = path.get(0);
    //         String destination = path.get(1);
    //         map.put(source, destination);
    //     }

    //     for(List<String> path:paths){
    //         String destination = path.get(1);
    //         while(map.containsKey(destination)){
    //             destination = map.get(destination);
    //         }
    //         finalDestination = destination;
    //         break;

    //     }

    //    return finalDestination;

    Set<String> hasOutGoing = new HashSet<>();
    for(int i=0;i<paths.size();i++){
        hasOutGoing.add(paths.get(i).get(0)); //add the sources to the set
    }

    for(int i=0;i<paths.size();i++){
        String dest = paths.get(i).get(1);
        if(!hasOutGoing.contains(dest)){
            return dest;
        }
    }

    return "";

    }
}
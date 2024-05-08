class Logger {

    Map<String,Integer> map;
    int timer;
    public Logger() {
        this.map = new HashMap<>();
        this.timer = 0;
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        timer++;
        if(map.containsKey(message)){
            int time = map.get(message);
            if(time+10 > timestamp){
                return false;
            }
            else{
                map.put(message,timestamp);
                return true;
            }
        }
        else{
            map.put(message,timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
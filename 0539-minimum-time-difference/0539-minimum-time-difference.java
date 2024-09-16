class Solution {
    public int findMinDifference(List<String> timePoints) {
        
          boolean bucket[] = new boolean[24*60];
        
        for(String time:timePoints){
            
            String[] splitted = time.split(":");
            int hh = Integer.parseInt(splitted[0]);
            int mm = Integer.parseInt(splitted[1]);
            if(bucket[hh*60+mm]){
                return 0;
            }
            else{
                bucket[hh*60+mm]=true;    
            }
        }
          
            int min=Integer.MAX_VALUE;
            int prev=-1;
            int first=-1;
        for(int i=0;i<bucket.length;i++){
            if(bucket[i]){
                if(first==-1){
                    prev=i;
                    first=i;
                    
                }else{
                    
                     min = Math.min(min,Math.min(i-prev,1440-i+first));
                    prev=i;
                    
                }    
            }
        }
     
       return min; 
        
        
    }
}
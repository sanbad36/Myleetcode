class Solution {
    
    
    static int solve(ArrayList<Integer> arr){
    int n = arr.size();
    if(n==1) return arr.get(0);
    int prev = arr.get(0);
    int prev2 = 0;
    
    for(int i=1; i<n; i++){
        int pick = arr.get(i);
        if(i>1)
            pick += prev2;
        int nonPick = 0 + prev;
        
        int cur_i = Math.max(pick, nonPick);
        prev2 = prev;
        prev= cur_i;
        
    }
    return prev;
}
    
    
    public int rob(int[] arr) {
    int n = arr.length;
    if(n==1)  return arr[0];
    if(n==0)  return 0;
    
    ArrayList<Integer> arr1=new ArrayList<>();
    ArrayList<Integer> arr2=new ArrayList<>();
    
    for(int i=0; i<n; i++){
        
        if(i!=0) arr1.add(arr[i]);
        if(i!=n-1) arr2.add(arr[i]);
    }
    
    int ans1 = solve(arr1);
    int ans2 = solve(arr2);
    
    return Math.max(ans1,ans2);
        
    }
}
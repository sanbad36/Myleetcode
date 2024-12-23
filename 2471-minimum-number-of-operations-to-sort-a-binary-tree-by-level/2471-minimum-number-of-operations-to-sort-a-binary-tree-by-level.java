class Solution {
    public int minimumOperations(TreeNode root) {
        
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

    while(!q.isEmpty()){
            int n = q.size();
            List<Integer> child = new ArrayList<>();
            for(int i=0; i<n; i++){
                TreeNode temp = q.poll();
                child.add(temp.val);
                if(temp.left != null)
                    q.offer(temp.left);
                
                if(temp.right != null)
                    q.offer(temp.right);     
            }
    res += helper(child.stream().mapToInt(i -> i).toArray());
        }
    return res;
    }

    public static int helper(int arr[]){
    int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++)
            map.put(arr[i], i);
        
        Arrays.sort(arr);
        boolean vis[] = new boolean[arr.length];

        Arrays.fill(vis, false);

        for(int i = 0; i<arr.length; i++){
            if(vis[i] || map.get(arr[i]) == i)
                continue;
            
            int j = i;
            int tempAns = 0;
            while(!vis[j]){
                vis[j] = true;
                j = map.get(arr[j]);
                tempAns++;
            }

            if(tempAns > 0)
                ans += (tempAns - 1);
        }
    return ans;
    }
}
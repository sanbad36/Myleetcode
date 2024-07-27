class Solution {
    public long minimumCost(String s, String t, char[] o, char[] c, int[] cost) {
        long[][] g = new long[26][26];
        
        for(int i = 0; i < o.length; i++){
            if(g[o[i]-'a'][c[i]-'a'] > 0)
                g[o[i]-'a'][c[i]-'a'] = Math.min(g[o[i]-'a'][c[i]-'a'], cost[i]);
            else
                g[o[i]-'a'][c[i]-'a'] = cost[i];
        }
        // System.out.println(g[2][1]);
        // System.out.println(g[2][4]);
        // System.out.println(g[4][1]);
        
        for(int k = 0; k < 26; k++){
            for(int i = 0; i < 26; i++)
                for(int j = 0; j < 26; j++){
                    // if(i == 2 && j == 1 && k == 4)
                    //     System.out.println(i +" "+ j + " "+k + "  g[i][k]="+g[i][k] +" g[k][i]="+g[k][i]);
                    if(g[i][k] > 0 && g[k][j] > 0){
                        
                        if(g[i][j] == 0 || g[i][j] > g[i][k] + g[k][j]){
                            
                            g[i][j] = g[i][k] + g[k][j];
                        }
                    }
                }
        }

        long ans = 0;
        
        for(int i = 0; i < s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            
            int isc = sc - 'a';
            int itc = tc - 'a';
            
            if(isc != itc){
                if(g[isc][itc] > 0){
                    ans += g[isc][itc];
                }
                else
                    return -1;
            }
        }
        
        return ans;
    }
}
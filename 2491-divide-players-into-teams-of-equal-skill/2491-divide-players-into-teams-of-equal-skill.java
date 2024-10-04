class Solution {
    public long dividePlayers(int[] skill) {

        int[][] t=new int[skill.length/2][2];
        long ans=0;
        Arrays.sort(skill);
        for(int i=0;i<skill.length/2;i++)
            t[i][0]=skill[i];
        int j=0;
        for(int i=skill.length-1;i>=skill.length/2;i--){
            t[j][1]=skill[i];
            j++;
        }
        int sum=0;
        if(t.length>0){
         sum=t[0][0]+t[0][1];
        }
        //System.out.print(sum);
        for(int i=0;i<t.length;i++){
            int temp=0;
            for(int k=0;k<2;k++){
                temp+=t[i][k];
            }
            if(temp!=sum)
                return -1;
        }
        
        
        for(int i=0;i<t.length;i++){
            long q=1;
            for(int k=0;k<2;k++){
                q*=t[i][k];
            }
            ans+=q;
        }
        return ans;
    }
}
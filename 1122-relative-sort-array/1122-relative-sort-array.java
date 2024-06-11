class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer , Integer> h1 = new HashMap<>();
        for(int i : arr1){

            if(h1.containsKey(i)){
                h1.put(i , h1.get(i)+1);
            }else{
                h1.put(i , 1);
            }
        }
        int p1 =0 , idx=0;
        while(p1<arr2.length){
            int a = arr2[p1];
            for(int j=1 ; j<= h1.get(a) ; j++){
                arr1[idx]=a;
                ++idx;
            }
            h1.remove(a);
            ++p1;
        }
        ArrayList<Integer> l1 = new ArrayList<>();
        for(int val: h1.keySet()){
            for(int j=1 ; j<=h1.get(val) ; j++){
                l1.add(val);
            }
        }
        Collections.sort(l1);
        int k=0;
        while(idx<arr1.length){
            arr1[idx]= l1.get(k);
            ++idx;
            ++k;
        }
        return arr1;
    }
}
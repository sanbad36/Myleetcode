class CustomStack {
    int st[];
    int sp;
    int capacity;
    public CustomStack(int maxSize) {
        st = new int[maxSize];
        Arrays.fill(st,-1);
        sp = -1;
        capacity = maxSize;
    }
    
    public void push(int x) {
        if(sp+1 < capacity){
            sp++;
            st[sp] = x;
        }
        return;
    }
    
    public int pop() {
        int val = -1;
        if(sp != -1){
            val = st[sp];
            st[sp] = -1;
            sp--;
        }
        return val;
    }
    
    public void increment(int k, int val) {
        int noOfEle = sp + 1;
        if(noOfEle < k){
            k = sp+1;
        }
        for(int i=0;i<k;i++){
            st[i] += val;
        }
        return;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
class Solution 
{
    public int[] finalPrices(int[] prices)
    {
        int n= prices.length;
        int[] arr=new int[n];
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        stack.push(prices[n-1]);
        arr[n-1]=prices[n-1];
        
        
        
        for (int i = n-2; i >= 0;i--)
        {
            while (!stack.isEmpty() && stack.peek()>prices[i])
                stack.pop();
            if (stack.isEmpty())
                arr[i]=prices[i];
            else
                arr[i]=prices[i]-stack.peek();
            stack.push(prices[i]);
            
// System.out.println(stack)
        }
        return arr;
    }
}



/*

Iteration (i)	Stack	Action Taken	Result
Start	[]	Initialize result array	
i = 4	[3]	Last item; no discount	[_, _, _, _, 3]
i = 3	[2, 3]	Discount = 2	[_, _, _, 2, 3]
i = 2	[2, 6]	Discount = 2	[_, _, 4, 2, 3]
i = 1	[2, 4]	Discount = 2	[_, 2, 4, 2, 3]
i = 0	[4, 8]	Discount = 4	[4, 2, 4, 2, 3]


*/
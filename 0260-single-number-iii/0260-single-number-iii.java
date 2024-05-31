class Solution {
    public int[] singleNumber(int[] nums) {
        
        int xor=0;                 
        int res[] = new int[2];
        for(int i:nums){
            xor ^= i;
        }
        int lowestSetbitinxor = xor&(-xor);
    
        for(int i=0;i<nums.length;i++){
            
            if((nums[i]&lowestSetbitinxor)==0){
                res[0] ^= nums[i];
            }
            else{
              res[1] ^= nums[i];   
            }
            
        }
        return res;
        
    }
}


/* 
 Time Complexity: O(n)


1. Take the xor of all all elements in the array. so the elements with twice pairs will becomes     0, and at last we have the xor of the two distinct numbers, say xor. 


2. Now we have to find this two elements, check the last set bit of the xor. use this, 
    xor & (-xor) ....(say lowestSetbitinxor) -> this gives the number which have the last bit       set in the xor. 
    -xor means->  2's complements; 

3. Intution is, any bit in xor is set then there are two possiblilities, 0,1=1 or 1,0 = 1
    now we found that the lowest set bit in lowestSetbitinxor. 
 
4. Now check each elements of the array nums, and take the & with lowestSetbitinxor, 
    if it gives 0, which means that, that elements nums[i] does not have a set bit at that location. so this number store in res[0]. 
    if it gives 1, which means that, that elements nums[i] does have a set bit at that location. so  this number store in res[1].
    
5. now all the elemensts in the res[0] and res[1] we have to take the xor. 

6. thus finally at res[0] we get the number which have the that bit as 0, and in res[1] that bit as 1. 

which finally contibute the o,1=1 in the XOr. 



ref: https://www.youtube.com/watch?v=wPBKH1jy0_E



-----------------------------------------------------------------------------
Method 1(Use Sorting) 

First, sort all the elements. In the sorted array, by comparing adjacent elements
we can easily get the non-repeating elements. Time complexity of this method is O(nLogn)


Method 2(Use XOR) 

Approach : 
Step 1: Xor all the elements of the array into a variable sum thus all the elements present twice in an array will get removed as for example, 4 = “100” and if 4 xor 4 => “100” xor “100” thus answer will be “000”. 
Step 2: Thus in the sum the final answer will be 3 xor 5 as both 2 and 4 are xor with itself giving 0, therefore sum = “011” xor “101” i.e sum = “110” = 6. 
Step 3: Now we will take 2’s Complement of sum i.e (-sum) = “010”. 
Step 4: Now bitwise And the 2’s of sum with the sum i.e “110” & “010” gives the answer “010” (Aim for bitwise & is that we want to get a number that contains only the rightmost set bit of the sum). 
Step 5: bitwise & all the elements of the array with this obtained sum, 2 = “010” & “010” = 2, 3 = “011” & “010” = “010” , 4 = “100” & “010” = “000”, 5 = “101” & “010” = “000”. 
Step 6: As we can see that the bitwise & of 2,3 > 0 thus they will be xor with sum1 and bitwise & of 4,5 is resulting into 0 thus they will be xor with sum2. 
Step 7: As 2 is present two times so getting xor with sum1 two times only the result 3 is being stored in it and As 4 is also present two times thus getting xor with sum2 will cancel it’s value and thus only 5 will remain there.

Time Complexity: O(n)

*/
class Solution {
   public String reversePrefix(String word, char ch) {
int start=0;
char[] temp=word.toCharArray();
for(int end=0;end<temp.length;end++)
{
if(temp[end]==ch)
{
while(start<end)
{
char tempS=temp[start];
temp[start]=temp[end];
temp[end]=tempS;
start++;
end--;
}
break;
}
}
return new String(temp);
}
}
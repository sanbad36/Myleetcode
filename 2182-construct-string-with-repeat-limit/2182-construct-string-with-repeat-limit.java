class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
		//convert string to char array
        char array[] = s.toCharArray();

        // now sort the array using array.sort() method
        Arrays.sort(array);
       
        //reverse the order so that it is in descending order 
        for(int count = 0; count < array.length/2; count++) {
            char temp = array[count];
            array[count] = array[array.length -1 - count]; 
            array[array.length -1 - count] = temp; 
        }

        //replace letters with too many repetitions with the next greatest letter 
        int numInstances = 1; 
        for(int count = 1; count < array.length; count++) {
        	
        	if(array[count] == ' ') 
        		break; 

            //if this character is the same as the last character 
            if(array[count -1 ] == array[count]) {
                numInstances++; 
            }
            else //new char so reset the numInstances count
                numInstances = 1;

            //if we found a chain of letters that surpasses the repeat limit
            if(numInstances > repeatLimit) {

                //we must find the next letter in the ascending chain that is different than the current letter and swap it 
                //binary search is used to find this position
            	int start = count + 1;
            	int end = array.length-1; 
            	int mid = start + (end - start) / 2; 
            	
                while(start <= end) {
                	if(array[mid] < array[count])
                		end = mid - 1; 
                	else 
                		start = mid + 1;
                	
                	mid = start + (end - start) / 2; 
                }
                //when this while loop finishes it should contain the index of the first different char

                //if no smaller replacement letter was found
                if(start >= array.length) {
                    //replace letters in this chain, starting at the end working back, w/ spaces 
                    //these spaces will be removed at the point of return using a trim operation on the string 
                    
                    //first make start point to the last char 
                    start--;
                    while(start >= count) {
                        array[start] = ' '; 
                        start--; 
                    } 
                }
                //otherwise, a smaller replacement was found so swap them 
                else { 
                //now swap this char with the char at start  
                char temp = array[count]; 
                array[count] = array[start]; 
                array[start] = temp; 

                //since we now have a new letter at count the numInstances counter should be set to 1
                numInstances = 1;  

                }              
            }
        }

        

        
        // making the string from the array
        //String sortedStr = new String(array);



        //System.out.println(sortedStr); 

        return new String(array).trim();
    }
}
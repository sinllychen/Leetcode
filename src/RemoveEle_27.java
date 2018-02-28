/**
 * Given an array and a value, remove all instances of that value in-place and return the new length.
   Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
   The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 */
public class RemoveEle_27 {
    public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0)
        	return 0;
        int k = 0;
        for(int i=0;i<nums.length;i++)
        {
        	if(nums[i]!=val)
        	{	
        	    nums[k]=nums[i];
        	    k = k+1;
        	}
        }
        return k;
    }
    public int removeElement1(int[] nums, int val){
        if(nums==null || nums.length==0)
        	return 0;
        int j = nums.length;
        int i=0;
        while(i < j){
        	if(nums[i] == val)
        	{
        		int tmp = nums[j-1];
        		nums[j-1] = nums[i];
        		nums[i] = tmp;
        		j = j-1;
        	}else
        		i++;
        }
        return j;
    }
    public static void main(String[] args)
    {
    	
    }
}

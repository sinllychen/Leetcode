/**
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 */
public class RemoveDuplicateArray_26 {
	public int removeDuplicates(int[] nums) {
		if(nums==null || nums.length == 0)
			return 0;
		int k=0;
		for(int i=1;i<nums.length;i++)
		{
			if(nums[i]!=nums[k])
			{
				int tmp = nums[i];
				nums[i]=nums[k+1];
				nums[k+1]=tmp;
				k = k +1;
			}
		}
		return k+1;
	}
	public static void main(String[] args)
	{
		RemoveDuplicateArray_26 obj = new RemoveDuplicateArray_26();
		int[] nums={1,1,2,2,2,2,3,3,4};
		System.out.println(obj.removeDuplicates(nums));
		
	}
}

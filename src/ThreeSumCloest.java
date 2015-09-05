import java.util.Arrays;


public class ThreeSumCloest {
//	public void insertSort(int[] nums)
//	{
//		for(int i=1;i<nums.length;i++)
//		{
//			int key=nums[i];
//			int j=i-1;
//			while(j>=0 && nums[j]>key)
//			{
//				nums[j+1]=nums[j];
//				j=j-1;
//			}
//			nums[j+1]=key;
//		}
//	}
//	public void quickSort(int[] nums,int i,int j)
//	{
//		if(i<j)
//		{
//			int p=partition(nums,i,j);
//			quickSort(nums,i,p-1);
//			quickSort(nums,p+1,j);
//		}
//	}
//	public int partition(int[] nums,int i,int j)
//	{
//		int key=nums[i];
//		int start=i+1;
//		int end=j;
//		while(start<=end)
//		{
//			while(start<=end && nums[start]<=key) start++;
//			while(start<=end && nums[end]>=key) end--;
//			if(start>end)
//				break;
//			swap(nums,start,end);
//		}
//		nums[i]=nums[end];
//		nums[end]=key;
//		return end;
//	}
//	public void swap(int[] nums,int i,int j)
//	{
//		int key=nums[i];
//		nums[i]=nums[j];
//		nums[j]=key;
//	}
    public int threeSumClosest(int[] nums, int target) {
        int minValue=Integer.MAX_VALUE;
        int res=0;
        Arrays.sort(nums);
//        quickSort(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++)
        {
        	int start=i+1;
        	int end=nums.length-1;
        	while(start<end)
        	{
        		int sum=nums[i]+nums[start]+nums[end];
        	    int diff=Math.abs(target-sum);
        	    if(diff==0)
        	    	return sum;
        	    else if(diff<minValue)
        	    {
        	    	minValue=diff;
        	    	res=sum;
        	    }
        	    if(sum<=target)
        	        start++;
        	    else 
        	    	end--;
        	}
        }
        return res;
    }
    public static void main(String[] args)
    {
    	int[] nums={0,1,2};
    	System.out.println(new ThreeSumCloest().threeSumClosest(nums, 3));
    }
}

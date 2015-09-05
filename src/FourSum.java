import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results=new ArrayList<List<Integer>>();
        HashSet<List<Integer>> hashSet = new HashSet<List<Integer>>();
    	if(nums.length<4)
    		return results;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
        	for(int j=i+1;j<nums.length;j++)
        	{
        		int start=j+1;
        		int end=nums.length-1;
        		int sum=0;
        		while(start<end)
        		{
        			sum=nums[i]+nums[j]+nums[start]+nums[end];
        			if(sum<target)
        				start++;
        			else if(sum>target)
        				end--;
        			else
        			{
        				List<Integer> res=new ArrayList<Integer>();
        				res.add(nums[i]);
        				res.add(nums[j]);
        				res.add(nums[start]);
        				res.add(nums[end]);
        				if(!hashSet.contains(res))
        				{
        					results.add(res);
        					hashSet.add((res));
        				}
        				start++;
        				end--;
        			}
        		
        		}
        	}
        }
        return results;
    }
    public static void main(String[] args)
    {
    	 int[] nums = {2,1,0,-1};
    	 List<List<Integer>> results=new  FourSum().fourSum(nums, 2);
    	 for(int i=0;i<results.size();i++)
    	 {
    		 List<Integer> res=results.get(i);
    		 for(int j=0;j<res.size();j++)
    			 System.out.print(res.get(j)+",");
    		 System.out.println();
    	 }
    }
}

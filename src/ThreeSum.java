import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
	public void insertSort(int[] nums)
	{
		int key;
		for(int i=1;i<nums.length;i++)
		{
			key=nums[i];
			int j=i-1;
		    while(j>=0 && key<nums[j])
		    {
		    	nums[j+1]=nums[j];
		    	j--;
		    }
		    nums[j+1]=key;
		}
	}
	public List<List<Integer>> threeSum(int[] nums) {
           List<List<Integer>> res=new ArrayList< List<Integer>>();
           if(nums.length<3)
        	   return res;
           insertSort(nums);
           for(int i=0;i<nums.length;i++)
           {
        	   if(i!=0 && nums[i]==nums[i-1])
        		   continue;
        	   int start=i+1;
        	   int end=nums.length-1;
        	   int sum=0;
        	   while(start<end)
        	   {
        		   sum=nums[i]+nums[start]+nums[end];
        		   if(sum==0)
        		   {
        			   int[] tmpRes={nums[i],nums[start],nums[end]};
        			   insertSort(tmpRes);
        			   List<Integer> tmp=new ArrayList<Integer>();
        			   for(int j=0;j<tmpRes.length;j++)
        				   tmp.add(tmpRes[j]);
        			   res.add(tmp);
            		   while(++start<end && nums[start-1]==nums[start])
            		   {
            			   continue;
            		   };
            		   while(--end>start && nums[end+1]==nums[end])
            		   {
            			   continue;
            		   }
        		   }
        		   else if(sum<0)
        		   {
        			   ++start;
        		   }
        		   else
        			   --end;
        	   }
           }
           return res;
	}
	public static void main(String[] args)
	{
		int[] nums={-1, 0, 1, 2, -1, -4};
		List<List<Integer>> result=new ThreeSum().threeSum(nums);
		for(int i=0;i<result.size();i++)
		{
		     System.out.println("第"+(i+1)+"组");
		     for(int j=0;j<result.get(i).size();j++)
		     {
		    	 System.out.print(result.get(i).get(j)+",");
		     }
		     System.out.println();
		}
	}
}


public class ContainWithMostWater {
	public int maxArea(int[] height) 
	{       
		if(height.length < 2)           
			return 0;     
		int start = 0;        
		int end = height.length - 1;       
		int maxArea = 0;     
		int area;      
		while(start < end)
		{        
			if(height[start] < height[end])
			{              
				area = height[start] * (end - start);            
				start++;        
			}          
			else
			{            
				area = height[end] * (end - start);               
				end--;         
			}          
			if(maxArea < area)            
				maxArea = area;      
		}        
		return maxArea;   
	}
}

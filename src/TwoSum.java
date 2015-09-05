import java.util.HashMap;
/**
Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
思路：用一个hashMap保存target-当前值作为key,它的index作为value。当检索到的值中有
存在hashMap中则相当于之前有值能够和它相加等于target。则输出。算法时间复杂度为O(N)
 * @author sinlly
 *
 */
public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int index[];
		index=new int[2];
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<numbers.length;i++)
		{
			if(!map.containsKey(numbers[i]))
			{
				map.put(target-numbers[i], i);
			}
			else
			{
				index[0]=map.get(numbers[i])+1;
				index[1]=i+1;
			}
		}
		return index;
	}
	public static void main(String[] args)
	{
		int[] numbers=new int[10];
		for(int i=0;i<10;i++)
		{
			numbers[i]=i+1;
		}
		int target=5;
		TwoSum opt=new TwoSum();
		int[] result=opt.twoSum(numbers, target);
		for(int i=0;i<result.length;i++)
		{
			System.out.print(result[i]+"  ");
		}
	}
}

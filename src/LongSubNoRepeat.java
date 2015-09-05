import java.util.HashSet;
/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 *  which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1
 * @author sinlly
 *
 */
public class LongSubNoRepeat {
    public int lengthOfLongestSubstring(String s) {
    	if(s==null || s.length()==0)
    		return 0;
    	HashSet<Character> tmpSet=new HashSet<Character>();
    	int max=0;
    	int right=0;//ÓÒ±ßË÷Òý
    	int left=0;//×óË÷Òý
    	while(right<s.length())
    	{
    		if(!tmpSet.contains(s.charAt(right)))
    		{
    			tmpSet.add(s.charAt(right));
    		}
    		else
    		{
    			if(right-left>max)
    				max=right-left;
    			while(s.charAt(right)!=s.charAt(left))
    			{
    				tmpSet.remove(s.charAt(left));
    				left=left+1;
    			}
    			left=left+1;
    		}
    		right=right+1;
    	}
    	if(max<right-left)
    		max=right-left;
        return max;
    }
   public static void main(String[] args)
   {
	   LongSubNoRepeat opt=new LongSubNoRepeat();
	   System.out.println(opt.lengthOfLongestSubstring("abcdefab"));
   }
}

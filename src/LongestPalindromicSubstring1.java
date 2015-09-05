/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * 使用动态规划算法O(N*2)
 * @author sinlly
 *
 */
public class LongestPalindromicSubstring1 {
	public String longestPalindrome(String s) {
		if(s==null)
			return null;
		if(s.length()<=1)
			return s;
		int len=s.length();
		boolean flag[][]=new boolean[len][len];

		for(int i=0;i<len;i++)
		{
			for(int j=0;j<len;j++)
			{
				if(i>=j)
					flag[i][j]=true;
				else
					flag[i][j]=false;
			}
		}
		int max=0;
		int ss=0;
		int se=0;
		for(int j=1;j<len;j++)
		{
			for(int i=0;i<j;i++)
			{
				if(s.charAt(i)==s.charAt(j) && flag[i+1][j-1])
				{
					if(flag[i][j]  && j-i+1>max)
					{
						max=j-i+1;
						ss=i;
						se=j;
					}
				}
				else
					flag[i][j]=false;
			}
		}
		return  s.substring(ss, se+1);
	}
	public static void main(String[] args)
	{
		LongestPalindromicSubstring1 str=new LongestPalindromicSubstring1();
		StringBuffer buf=new StringBuffer();
		for(int i=0;i<1000;i++)
			buf.append("a");
		
		System.out.println(	str.longestPalindrome(buf.toString()));
	}
}

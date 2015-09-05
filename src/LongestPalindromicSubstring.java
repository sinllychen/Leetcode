/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * 查找O(N*2)
 * @author sinlly
 *
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if(s==null)
			return null;
		if(s.length()<=1)
			return s;
		int len=s.length();
	    String maxStr=s.substring(0,1);
	    for(int i=0;i<len;i++)
	    {
	    	//回文子串只有一个字母
	    	String str=findStr(s,i,i);
	    	if(str.length()>maxStr.length())
	    		maxStr=str;
	    	str=findStr(s,i,i+1);
	    	if(str.length()>maxStr.length())
	    		maxStr=str;
	    }
		return  maxStr;
	}
	public String findStr(String s,int start,int end)
	{
		while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end))
		{
			start--;
			end++;
		}
		return s.substring(start+1,end);//返回回文子串
	}
	public static void main(String[] args)
	{
		LongestPalindromicSubstring str=new LongestPalindromicSubstring();
//		StringBuffer buf=new StringBuffer();
//		for(int i=0;i<1000;i++)
//			buf.append("a");
//		
//		System.out.println(	str.longestPalindrome(buf.toString()));
		System.out.println(str.longestPalindrome("abcddcbaababa"));
	}
}

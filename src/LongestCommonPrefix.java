
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    	if(strs.length<1)
    		return "";
        String prefix=strs[0];
        int len;
        for(int i=1;i<strs.length;i++)
        {
        	if(strs[i].length()<1)
        		return "";
        	if(prefix.length()<strs[i].length()) 
        		len=prefix.length();
        	else
        		len=strs[i].length();
        	int j;
        	for(j=0;j<len;j++)
        	{
        		if(prefix.charAt(j)!=strs[i].charAt(j))
        			    break;
        	}
        	prefix=strs[i].substring(0,j);
        }
        return prefix;
    }
}

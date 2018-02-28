
public class ImpStr_28 {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0)
        	return 0;
        else if(haystack.length() ==0)
        	return -1;
        for(int i =0;i<haystack.length();i++)
        {
             int j =0;
             if(haystack.charAt(i)!=needle.charAt(j))
            	 continue;
             else
             {
            	 int k =i;
            	 boolean inFlag = true;
            	 for(j=j+1;j<needle.length();j++)
            	 {
            		 k=k+1;
                     if(k>=haystack.length())
                     {
                    	 inFlag = false;
                    	 break;
                     }
                     if(haystack.charAt(k)!=needle.charAt(j))
                     {
                    	 inFlag = false;
                    	 break;
                     }
            	 }
            	 if(inFlag && j==needle.length())
            	 {
            		 return i;
            	 }
             }
        }
        return -1;
    }
    public int strStr1(String haystack, String needle) {
          return haystack.indexOf(needle);
    }
    
    public static void main(String[] args)
    {
    	ImpStr_28 obj = new ImpStr_28();
    	System.out.println(obj.strStr("abcde", "bce"));
    }
}

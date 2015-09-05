
public class ZigZagConversion {
    public  String convert(String s, int numRows) {
        StringBuffer buf=new StringBuffer();
        if(numRows<=1 || s.length()==0)
        	return s;
        int len=s.length();
        for(int i=0;i<len && i<numRows;i++)
        {
        	 int index=i;
        	 buf.append(s.charAt(i));
        	 for(int j=1;index<len;j++)
        	 {
        		 if(i==0 || i==numRows-1)
        		 {
        			 index=index+2*numRows-2;
        		 }
        		 else
        		 {
        			 if(j%2==1) 
        				 index=index+2*(numRows-1-i);
        			 else
        				 index=index+2*i;
        		 }
        		 if (index<len)
        			 buf.append(s.charAt(index));
        	 }
        }
        return buf.toString();
    }
    public static void main(String[] args)
    {
    	String str="PAYPALISHIRING";
    	System.out.println(new ZigZagConversion().convert(str,3));
    }
}

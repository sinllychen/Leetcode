import java.util.Stack;
/**
 * 
 * @author sinllychen
 * @date 2016年12月28日
 */
public class LeetCode_02 {
    public static int evalRPN(String[] tokens) {
       Stack<Integer> s=new Stack<Integer>();
       int num=0;
       for(int i=0;i<tokens.length;i++)
       {
            try
            {
                int a=Integer.parseInt(tokens[i]);
                s.push(a);
            }
            catch(Exception e)
            {
        	if(tokens[i].equals("+"))
        	{
        	    int a=s.pop();
        	    int b=s.pop();
        	    num=a+b;
        	    s.push(num);
        	}
                if(tokens[i].equals("-"))
                {
        	    int a=s.pop();
       	            int b=s.pop();
       	            num=b-a;
    		    s.push(num);
                }
               if(tokens[i].equals("*"))
               {
        	    int a=s.pop();
       	            int b=s.pop();
       		    num=a*b;
    		    s.push(num);
               }
               if(tokens[i].equals("/"))
               {
        	    int a=s.pop();
       	            int b=s.pop();
       		    num=b/a;
    	            s.push(num);
               }
            }
        }
        if(!s.isEmpty())
            num=s.pop();
        return num;
    }
    public static void main(String[] args)
    {
        String[] tokens={"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }
}

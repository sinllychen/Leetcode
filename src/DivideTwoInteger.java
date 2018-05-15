/**
 * Divide two integers without using multiplication, division and mod operator.
    If it is overflow, return MAX_INT.
 * @author sinllychen
 *
 */
public class DivideTwoInteger {
    public int divide(int dividend, int divisor) {
        if(divisor==0 || (dividend == Integer.MIN_VALUE && divisor == -1)) //对于该特殊样例会造成溢出
        	return Integer.MAX_VALUE;
        int count = 0, result = 0;  
        boolean isNeg = false;  
        if((dividend<0 && divisor>0)||(dividend>0 && divisor<0))  
            isNeg = true;  
        long  a = abs(dividend);  
        long  b = abs(divisor);  
        //若a=10，b=3，则会出现循环的情况
        while(b <= a)  
        {  
            count = 1;  
            long sum = b;  
            while((sum+sum) <= a)  
            {  
            	sum +=sum;
                count +=count;  
            }  
            a -= sum;  
            result += count;  
        }  
        return isNeg ? (0-result) : result;  
    }
    /**
     * 需要单独实现绝对值方法。若使用Math.abs会导致整数最小值求绝对值的过程中溢出
     * @param num
     * @return
     */
    private long abs(int num){
        if(num < 0){
            return -(long)num;
        }
        return (long)num;
    }
    public static void main(String[] args)
    {
    	DivideTwoInteger test = new DivideTwoInteger();
    	test.divide(Integer.MIN_VALUE, 1);
    	System.out.println(Integer.MIN_VALUE+","+Integer.MAX_VALUE);
    }
}

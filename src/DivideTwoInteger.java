/**
 * Divide two integers without using multiplication, division and mod operator.
    If it is overflow, return MAX_INT.
 * @author sinllychen
 *
 */
public class DivideTwoInteger {
    public int divide(int dividend, int divisor) {
        if(divisor==0 || (dividend == Integer.MIN_VALUE && divisor == -1)) //���ڸ�����������������
        	return Integer.MAX_VALUE;
        int count = 0, result = 0;  
        boolean isNeg = false;  
        if((dividend<0 && divisor>0)||(dividend>0 && divisor<0))  
            isNeg = true;  
        long  a = abs(dividend);  
        long  b = abs(divisor);  
        //��a=10��b=3��������ѭ�������
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
     * ��Ҫ����ʵ�־���ֵ��������ʹ��Math.abs�ᵼ��������Сֵ�����ֵ�Ĺ��������
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

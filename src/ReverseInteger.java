
public class ReverseInteger {
	public int reverse(int x) {
		long sum=0;
		while(x != 0)  
		{  
			int temp = x % 10;  
			sum = sum * 10 + temp;  
			if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE)   //溢出处理  
			{   
				return  0;  
			}  
			x = x / 10;  
		}  
		return (int)sum;  
	}
	public static void main(String[] args)
	{
		System.out.println(new ReverseInteger().reverse(1534236469));
	}
}

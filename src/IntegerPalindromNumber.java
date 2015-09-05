
public class IntegerPalindromNumber {
	public boolean isPalindrome(int x) {
		if(x<0)
			return false;
		int srcValue=x;
		long sum=0;
		while(x != 0)  
		{  
			int temp = x % 10;  
			sum = sum * 10 + temp;  
			if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE)   //溢出处理  
			{   
				return  false;  
			}  
			x = x / 10;  
		}  
		if((int)sum==srcValue)
			return true;
		else
			return false;
	}
	public static void main(String[] args)
	{
		System.out.println(new IntegerPalindromNumber().isPalindrome(1));
	}
}

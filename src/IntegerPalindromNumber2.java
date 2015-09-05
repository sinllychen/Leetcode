
public class IntegerPalindromNumber2 {
	public boolean isPalindrome(int x) {
		if(x<0)
			return false;
		int len=1;
		while(x/len>=10)
			len=len*10;
		int left;
		int right;
		while(x!=0)
		{
			left=x/len;
			right=x%10;
			if(left!=right)
				return false;
			x=(x%len)/10;
			len=len/100;
		}
		return true;
	}
	public static void main(String[] args)
	{
		System.out.println(new IntegerPalindromNumber2().isPalindrome(1234));
	}
}

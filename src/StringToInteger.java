
public class StringToInteger {
	public int myAtoi(String str) {
		String tmp=str.trim();
		long num=0;
		int flag=0;
		boolean hasSym=false;
		for(int i=0;i<tmp.length();i++)
		{
			int value;
			if(hasSym && (tmp.substring(i, i+1).equals("-") || tmp.substring(i, i+1).equals("+")))
				return 0;
			else
			{
				if(flag==0 && tmp.substring(i, i+1).equals("-"))
				{
					flag=1;
					hasSym=true;
					continue;
				}
				if(tmp.substring(i, i+1).equals("+"))
				{
					hasSym=true;
					continue;
				}
				try{
					value=Integer.parseInt(tmp.substring(i,i+1));
					num=num*10+value;
					if(flag==1)
					{
						if(-num<Integer.MIN_VALUE)
							return Integer.MIN_VALUE;
					}
					else
					{
						if(num>Integer.MAX_VALUE)
							return Integer.MAX_VALUE;
					}
				}
				catch(NumberFormatException exp)
				{
					if(num!=0)
					{
						if(flag==0)
							return (int)num;
						else
							return -(int)num;
					}
					else
						return 0;
				}
			}
		}
		if(flag==0)
			return  (int)num;
		else
			return -(int)num;
	}
	public static void main(String[] args)
	{
		System.out.println(new StringToInteger().myAtoi("-1"));
	}

}

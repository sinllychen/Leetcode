
public class Permulate {
	public static int num = 0;
	public static void permulate(int[] a, int i,int j)
	{
		if(i>=j)
		{
			num = num +1;
			printArray(a);
		}
		else{
			for(int k=i;k<a.length;k++)
			{
				swap(a,i,k);
				permulate(a,i+1,j);
				swap(a,k,i);
			}
		}

	}
	public static void printArray(int[] a)
	{
		for(int data :a)
		{
			System.out.print(data+" ");
		}
		System.out.println();
	}
	public static void swap(int a[],int i,int j)
	{
		int tmp = a[i];
		a[i] = a[j];
		a[j]=tmp;
	}

	public static void main(String[] args)
	{
		int[] a={1,2,3,4,5};
		Permulate test = new Permulate();
		test.permulate(a,0,a.length-1);
		System.out.println("共有"+num+"种解法");
	}
}


public class Sort {
	/**
	 * 插入排序
	 * @param datas
	 */
	public void insertSort(int[] datas)
	{
		for(int i=1;i<datas.length;i++)
		{
			int data = datas[i];
			int j;
			for( j = i; j>0 && datas[j-1] >data; j--)
			{
				datas[j]=datas[j-1];
			}
			datas[j] = data;
		}
	}
	/**
	 * 希尔排序（特殊的插入排序）
	 * @param datas
	 */
	public void shellSortTest(int[] datas)
	{
		int k = datas.length / 2;
		while(k>=1)
		{
			shellSort(datas,k);
			k = k/2;
		}
	}
	private void shellSort(int[] datas, int k)
	{
		for(int i = k; i<datas.length; i = i +1)
		{
			int data = datas[i];
			int j ;
			for( j = i; j-k>=0 && datas[j-k] > data ; j = j - k)
			{
				datas[j] = datas[j-k];
			}
			datas[j]=data;
		}
	}

	/**
	 * 选择排序
	 * @param datas
	 */
	public void selectSort(int[] datas)
	{
		for(int i = 0;i < datas.length;i++)
		{
			int minIndex = i;
			for(int j = i+1;j<datas.length;j++)
			{
				if(datas[j]<datas[minIndex])
				{
					minIndex = j;
				}
			}
			int tmp = datas[i];
			datas[i]=datas[minIndex];
			datas[minIndex]=tmp;
		}
	}

	private void buildMaxHeap(int[] a)
	{
		int n = a.length-1;
		for(int i = (n-1)/2;i>=0;i--)
		{
			keepMaxSort(a,i,n);
		}
	}
	/**
	 * 堆排序
	 * ---构建大顶堆，最后一个非叶节点下标为n-1/2, 当前节点为i，则其左孩子为2*i+1，右孩子为2*i+2
	 * @param a
	 */
	public void heapSort(int[] a)
	{
		buildMaxHeap(a);
		int k=a.length-1;
		for(int i=0;i<a.length;i++)
		{
			int tmp = a[0];
			a[0] = a[k];
			a[k]=tmp;
			k = k-1;
			keepMaxSort(a,0,k);
		}
	}
	/**
	 * 保持堆最大的数字
	 * @param a
	 * @param index
	 */
	private void keepMaxSort(int[] a, int index, int maxSize)
	{
		int left = 2*index +1;
		int right = 2*index +2;
		int max = index;
		if(left<= maxSize && a[left]>a[max])
			max = left;
		if(right <=maxSize && a[right] >a[max])
			max = right;
		if(index == max || max>maxSize)
			return;
		int tmp = a[index];
		a[index]=a[max];
		a[max]=tmp;
		keepMaxSort(a,max,maxSize);
	}

	public void bubbleSort(int[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length-1-i;j++)
			{
				if(a[j]>=a[j+1])
				{
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		}
	}
	/**
	 * 带flag冒泡
	 * 设置一标志性变量pos,用于记录每趟排序中最后一次进行交换的位置。由于pos位置之后的记录均已交换到位,故在进行下一趟排序时只要扫描到pos位置即可
	 * @param a
	 */
	public void flagBubbleSort(int[] a)
	{
		int i = a.length-1;
		while(i>0)
		{
			int pos=0;
			for(int j=0;j<i;j++)
			{
				if(a[j]>=a[j+1])
				{
					int tmp = a[j];
					a[j]=a[j+1];
					a[j+1]=tmp;
					pos = j;
				}
			}
			i = pos;
		}
	}
	/**
	 * 双向冒泡排序
	 * @param a
	 */
	public void twoBubble(int[] a)
	{
		int low = 0;
		int high = a.length-1;
		while(low<high)
		{
			for(int i=low;i<high;i++)
			{
				if(a[i]>a[i+1])
				{
					int tmp= a[i];
					a[i]=a[i+1];
					a[i+1]=tmp;
				}
			}
			--high;
			for(int i=high;i>low ; i--)
			{
				if(a[i]<a[i-1])
				{
					int tmp= a[i];
					a[i]=a[i-1];
					a[i-1]=tmp;
				}
			}
			++low;
		}
	}

	public void quickSort(int[] a,int i,int j)
	{
		if(i<j)
		{
			int p = getPartition(a,i,j);
			quickSort(a,i,p-1);
			quickSort(a,p+1,j);
		}

	}
	private int getPartition(int[] a,int i,int j)
	{
		int key = a[i];
		int m=i+1;
		int n = j;
		while(m<=n)
		{
			while(m<=n && a[m]<=key) m++;
			while(m<=n && a[n]>=key) n--;
			if(m>=n)
				break;
			int tmp = a[m];
			a[m]=a[n];
			a[n]=tmp;
		}
		a[i]=a[n];
		a[n]=key;
		return n;
	}
//i=0,j=8,p=4
	public void mergeSort(int a[],int i,int j)
	{
		if(i<j)
		{
			int p = (int)Math.floor((i+j)/2);
			mergeSort(a,i,p);
			mergeSort(a,p+1,j);
			merge(a,i,p,j);
		}
	}
	public void merge(int a[], int i,int p, int j)
	{
		int[] l = new int[a.length];
		int[] r = new int[a.length];
		int n1 = p-i+1; 
		int n2 = j-p;
		for(int k=0;k<n1;k++)
			l[k] = a[i+k];
		for(int k=0;k<n2;k++)
			r[k] = a[p+1+k];
		l[n1] = Integer.MAX_VALUE; 
		r[n2]= Integer.MAX_VALUE;
		int m=0;
		int n=0;
		for(int k=i;k<=j;k++)
		{
			if(l[m]<=r[n])
			{
				a[k]=l[m];
				m=m+1;
			}else{
				a[k]=r[n];
				n=n+1;
			}
		}
	}

	public static void main(String[] args)
	{
		Sort test = new Sort();
		int[] datas = {8,7,6,5,4,3,2,1,10};
		//	   test.insertSort(datas);
		//	   test.shellSortTest(datas);
		//	   test.selectSort(datas);
		//	   test.heapSort(datas);
		//	   test.flagBubbleSort(datas);
		//	   test.twoBubble(datas);
//		test.quickSort(datas, 0, datas.length-1);
		test.mergeSort(datas, 0, datas.length-1);
		for(int data : datas)
		{
			System.out.print(data+" ");
		}


	}
}

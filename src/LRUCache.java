import java.util.HashMap;
import java.util.Set;

public class LRUCache {
    class Node
	{
		Node pre,next;
		int key,value;
		public Node(int key,int value)
		{
		    this.key=key;
		    this.value=value;
		}
	 }
	private Node first,last;
	private HashMap<Integer,Node> maps;
	private  int num;
	private int capacity;
	
    public LRUCache(int capacity) {
        first=null;
    	last=null;
    	maps=new HashMap<Integer,Node>();
    	this.capacity=capacity;
    }
    
    public int get(int key) {
         Node cur=maps.get(key);
         if(cur==null)
             return -1;
         else if(cur!=last)
         {
             if(cur==first)
            	first=first.next;
             else
            	cur.pre.next=cur.next;
             cur.next.pre=cur.pre;
             last.next=cur;
             cur.pre=last;
             cur.next=null;
             last=cur;
          }
          return cur.value;
    }
    
    public void set(int key, int value) {
        Node cur=maps.get(key);
        if(cur==null)
        {
            Node newN=new Node(key,value);
            if(num>=capacity)
            {
            	 maps.remove(first.key);
            	 first=first.next;
            	 if(first!=null)
            	    first.pre=null;
            	 else
            	    last=null;
            	 --num;
            }
            if(first==null || last==null)
            	 first=newN;
            else
            	 last.next=newN;	    
            newN.pre=last;
            last=newN;
            maps.put(key, newN);
            ++num;
        }
        else
        {
            cur.value=value;
            if(cur!=last)
            {
            	if(cur==first)
            	    first=first.next;
            	else
            	    cur.pre.next=cur.next;
            	cur.next.pre=cur.pre;
            	last.next=cur;
            	cur.pre=last;
            	cur.next=null;
            	last=cur;
            }
       }
    }
    public  void print()
    {
        Set<Integer> keys= maps.keySet();
        Node n=maps.get(keys.toArray()[0]);
    	while(n.pre!=null)
    	{
    		n=n.pre;
    	}
    	while(n!=null)
    	{
    		System.out.print(n.value+"   ");
    		n=n.next;
    	}
    	System.out.println();
    }
    public static void main(String[] args)
    {
    	LRUCache l=new LRUCache(10);
    	l.set(10,13);l.print();l.set(3,17);l.print();l.set(6,11);l.print();l.set(10,5);l.print();l.set(9,10);l.print();l.get(13);l.print();l.set(2,19);l.print();l.get(2);l.print();l.get(3);l.print();l.set(5,25);l.print();l.get(8);l.print();l.set(9,22);l.print();l.set(5,5);l.print();l.set(1,30);l.print();l.get(11);l.print();l.set(9,12);l.print();l.get(7);l.print();l.get(5);l.print();l.get(8);l.print();l.get(9);l.print();l.set(4,30);l.print();l.set(9,3);l.print();l.get(9);l.print();l.get(10);l.print();l.get(10);l.print();l.set(6,14);l.print();l.set(3,1);l.print();l.get(3);l.print();l.set(10,11);l.print();l.get(8);l.print();l.set(2,14);l.print();l.get(1);l.print();l.get(5);l.print();l.get(4);l.print();l.set(11,4);l.print();l.set(12,24);l.print();l.set(5,18);l.print();l.get(13);l.print();l.set(7,23);l.print();l.get(8);l.print();l.get(12);l.print();l.set(3,27);l.print();l.set(2,12);l.print();l.get(5);l.print();l.set(2,9);l.print();l.set(13,4);l.print();l.set(8,18);l.print();l.set(1,7);l.print();l.get(6);l.print();l.set(9,29);l.print();l.set(8,21);l.print();l.get(5);l.print();l.set(6,30);l.print();l.set(1,12);l.print();l.get(10);l.print();l.set(4,15);l.print();l.set(7,22);l.print();l.set(11,26);l.print();l.set(8,17);l.print();l.set(9,29);l.print();l.get(5);l.print();l.set(3,4);l.print();l.set(11,30);l.print();l.get(12);l.print();l.set(4,29);l.print();l.get(3);l.print();l.get(9);l.print();l.get(6);l.print();l.set(3,4);l.print();l.get(1);l.print();l.get(10);l.print();l.set(3,29);l.print();l.set(10,28);l.print();l.set(1,20);l.print();l.set(11,13);l.print();l.get(3);l.print();l.set(3,12);l.print();l.set(3,8);l.print();l.set(10,9);l.print();l.set(3,26);l.print();l.get(8);l.print();l.get(7);l.print();l.get(5);l.print();l.set(13,17);l.print();l.set(2,27);l.print();l.set(11,15);l.print();l.get(12);l.print();l.set(9,19);l.print();l.set(2,15);l.print();l.set(3,16);l.print();l.get(1);l.print();l.set(12,17);l.print();l.set(9,1);l.print();l.set(6,19);l.print();l.get(4);l.print();l.get(5);l.print();l.get(5);l.print();l.set(8,1);l.print();l.set(11,7);l.print();l.set(5,2);l.print();l.set(9,28);l.print();l.get(1);l.print();l.set(2,2);l.print();l.set(7,4);l.print();l.set(4,22);l.print();l.set(7,24);l.print();l.set(9,26);l.print();l.set(13,28);l.print();l.set(11,26);
    	l.print();
    	

    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
public class LeetCode_04 {
    public ListNode sortList(ListNode head) {
         return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head)
    {    	
    	if(head==null || head.next==null)
              return head;
    	ListNode p=head;
    	ListNode q=head;
    	ListNode pre=p;
        while(q!=null &&q.next!=null)
        {
        	q=q.next.next;
        	pre=p;
        	p=p.next;
        }
        pre.next=null;
        ListNode lNode=mergeSort(head);
        ListNode rNode=mergeSort(p);
        return merge(lNode,rNode);
    }
    public ListNode merge(ListNode n1,ListNode n2)
    {
    	ListNode n=new ListNode(0);
    	ListNode p=n;
    	while(n1!=null && n2!=null)
    	{
    		if(n1.val<=n2.val)
    		{	p.next=n1;n1=n1.next;}
    		else 
    		{
    			p.next=n2;n2=n2.next;
    		}
    		p=p.next;
    	}
    	if(n1!=null)
    		p.next=n1;
    	if(n2!=null)
    		p.next=n2;
    	return n.next;
    }
    public static void main(String[] args)
    {
    	ListNode a=new ListNode(10);
    	ListNode p=a;
    	for(int i=9;i>=1;i--)
    	{
    		ListNode b=new ListNode(i);
    		a.next=b;
    		a=a.next;
    	}
    	ListNode c=new LeetCode_04(). sortList(p); 
    	while(c.next!=null)
    	{
    		System.out.print(c.val+",");
    		c=c.next;
    	}
    }
}

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
 * @author sinllychen
 *
 */
public class RemoveNthNodeFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n<=0)
        	return head;
        if(head.next == null && n ==1) //仅一个节点
        	return null;
        ListNode start = new ListNode(-1);
        start.next  = head;
        ListNode p = start;
        ListNode q = start;
        for(int i=0;i<n;i++)
        {
        	q = q.next;
        }
        while(q.next != null)
        {
        	q = q.next ;
        	p = p.next;
        }
        ListNode tmp = p.next;
        p.next = tmp.next;
        return start.next;
    }
    
    public static void main(String[] args)
    {
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(2);
//    	ListNode c = new ListNode(3);
//    	ListNode d = new ListNode(4);
//    	ListNode e = new ListNode(5);
//    	ListNode f = new ListNode(6);
    	a.next=b;
    	b.next=null;
//    	c.next=d;
//    	d.next=e;
//    	e.next=f;
    	RemoveNthNodeFromEnd_19 test = new RemoveNthNodeFromEnd_19();
    	ListNode result = test.removeNthFromEnd(a, 2);
       	while(result!=null)
    	{
    		System.out.println(result.val);
    		result = result.next;
    	}
    }
}

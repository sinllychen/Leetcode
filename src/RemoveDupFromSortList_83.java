/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * @author sinllychen
 *
 */
public class RemoveDupFromSortList_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next==null)
        	return head;
        ListNode cur = head.next;
        ListNode pre = head;
        while(cur!=null)
        {
        	if(cur.val == pre.val)
        	{
        		pre.next = cur.next;
        		cur = cur.next;
        	}else{
        		pre = cur;
        		cur = cur.next;
        	}
        }
        return head;
    }
    public static void main(String[] args) {
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(2);
    	ListNode c = new ListNode(2);
    	ListNode d = new ListNode(3);
    	ListNode e = new ListNode(3);
    	ListNode f = new ListNode(5);
    	a.next=b;
    	b.next=c;
    	c.next=d;
    	d.next=e;
    	e.next=f;
    	RemoveDupFromSortList_83 test = new RemoveDupFromSortList_83();
    	ListNode result = test.deleteDuplicates(a);
       	while(result!=null)
    	{
    		System.out.println(result.val);
    		result = result.next;
    	}
	}
}

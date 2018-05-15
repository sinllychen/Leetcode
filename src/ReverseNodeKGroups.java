
public class ReverseNodeKGroups {
	public ListNode reverse(ListNode pre, ListNode next)
	{
		ListNode last = pre.next;
		ListNode cur = last.next;
		while(cur!=next)
		{
			last.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = last.next;
		}
		return last;
	}
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k ==1)
        	return head;
        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        ListNode pre = tmp;
        ListNode cur = head;
        int count = 0;
        while(cur != null)
        {
        	 count = count +1;
        	 ListNode next = cur.next;
        	 if(count == k)
        	 {
        		 pre = reverse(pre,next);
        		 count = 0;
        	 }
        	 cur = next;
        }
        return tmp.next;
    }
}

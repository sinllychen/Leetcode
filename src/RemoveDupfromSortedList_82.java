
public class RemoveDupfromSortedList_82 {
	   public ListNode deleteDuplicates(ListNode head) {
	        if(head == null || head.next==null)
	        	return head;
	        ListNode startN = new ListNode(-1);
	        startN.next = head;
	        ListNode pre = head;  //记录上一个节点
	        ListNode cur = head.next;
	        ListNode start = startN; //重复元素的起始节点的上一个节点
	        ListNode end = startN; //重复元素的终止节点
	        while(cur!=null)
	        {
	        	if(cur.val == pre.val)
	        	{
                   end = cur;
	        	}else{
	        		if(start!=end) 
	        		{
	        			start.next = end.next;
	        			end = start;
	        		}else{
	        			start = end = pre;
	        		}
	        	}
	        	pre = cur;
	        	cur = cur.next;
	        }
	        if(start != end)
	        	start.next = end.next;
	        return startN.next;
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
	    	RemoveDupfromSortedList_82 test = new RemoveDupfromSortedList_82();
	    	ListNode result = test.deleteDuplicates(a);
	       	while(result!=null)
	    	{
	    		System.out.println(result.val);
	    		result = result.next;
	    	}
		}
}

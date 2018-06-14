/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 *
 */
public class ReverseLinkedListII_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if(m>=n || n<0)
    		return head;
        ListNode begin = new ListNode(0); //头结点
        begin.next = head;
        ListNode  preM = begin;
        //寻找m-1的点位置
        int index = 1;
        while(preM!=null && index<m)
        {
        	preM = preM.next;
        	index = index +1;
        }
        
        ListNode revStart = preM.next;  //m点位置
        index = 1;
        while(index <= n-m) //逆转n-m个节点
        {
        	ListNode tmp = revStart.next;  //要删除节点
        	revStart.next = tmp.next;
        	tmp.next = preM.next;
        	preM.next = tmp;
        	index = index + 1;
        }
        return begin.next;
    }
    
    public static void main(String[] args)
    {
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(2);
    	ListNode c = new ListNode(3);
    	ListNode d = new ListNode(4);
    	ListNode e = new ListNode(5);
    	ListNode f = new ListNode(6);
    	a.next=b;
    	b.next=c;
    	c.next=d;
    	d.next=e;
    	e.next=f;
    	ReverseLinkedListII_92 test = new ReverseLinkedListII_92();
    	ListNode result  = test.reverseBetween(a, 0, 5);
        ListNode pre = result;
        while(pre!=null)
        {
        	System.out.println(pre.val);
        	pre = pre.next;
        }
    }
}

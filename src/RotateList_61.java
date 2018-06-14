/**
 * Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
 * @author sinllychen
 *
 */
public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
    	if(head == null || head.next == null)
    		return head;
        ListNode cur = head;
        int count = 1;
        //计算链表长度
        while(cur.next!=null)
        {
        	cur = cur.next;
        	count = count +1;
        }
        int step = count - k%count;//链表需要往后走的步数
        cur.next = head; //形成环
        for(int i=0;i<step;i++)
        {
        	cur = cur.next;
        }
        //将链表断开
        head = cur.next;
        cur.next = null;
        return head;
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
    	RotateList_61 test = new RotateList_61();
    	ListNode result = test.rotateRight(a, 4);
       	while(result!=null)
    	{
    		System.out.println(result.val);
    		result = result.next;
    	}
    }
}

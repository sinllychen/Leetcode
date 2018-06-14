/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
    You should preserve the original relative order of the nodes in each of the two partitions.
 * @author sinllychen
 *
 */
public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
    	if(head == null || head.next ==null)
    		return head;
        ListNode leftN = new ListNode(-1);
        ListNode leftPre = leftN;
        ListNode rightN = new ListNode(-1);
        ListNode rightPre = rightN;
        while(head!=null)
        {
        	if(head.val<x)
        	{
        		leftPre.next  = head;
        		leftPre = head;
        	}else{
        		rightPre.next = head;
        		rightPre = head;
        	}
        	head = head.next;
        }
        rightPre.next =null;
        leftPre.next = rightN.next;
        return leftN.next;
    }

    public static void main(String[] args) {
    	ListNode a = new ListNode(5);
    	ListNode b = new ListNode(2);
    	ListNode c = new ListNode(1);
    	ListNode d = new ListNode(4);
    	ListNode e = new ListNode(3);
    	ListNode f = new ListNode(6);
    	a.next=b;
    	b.next=c;
    	c.next=d;
    	d.next=e;
    	e.next=f;
    	PartitionList_86 test = new PartitionList_86();
    	ListNode head = test.partition(a, 3);
    	while(head!=null)
    	{
    		System.out.println(head.val);
    		head = head.next;
    	}
	}
}

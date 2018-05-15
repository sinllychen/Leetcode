/**
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * @author sinllychen
 *
 */
public class SwapNodesInPari {
    public ListNode swapPairs(ListNode head) {
        if(head==null)
        	return head;
        ListNode curNode = head;
        ListNode preNode = curNode;
        if(curNode.next!=null)
        	head = curNode.next;
        while(curNode!=null && curNode.next !=null)
        {
        	preNode.next = curNode.next;
        	ListNode next = curNode.next.next;
        	curNode.next.next = curNode;
        	curNode.next = next;
        	preNode = curNode;
        	curNode = next;
        }
        return head;
    }
}

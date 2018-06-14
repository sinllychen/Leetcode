/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
1）先判断是否存在环
使用两个指针slow,fast。两个指针都从表头开始走，slow每次走一步，fast每次走两步，如果fast遇到null，则说明没有环，返回false；如果slow==fast，说明有环，并且此时fast超了slow一圈，返回true。
为什么有环的情况下二者一定会相遇呢？因为fast先进入环，在slow进入之后，如果把slow看作在前面，fast在后面每次循环都向slow靠近1，所以一定会相遇，而不会出现fast直接跳过slow的情况。 

2）找环的第一个节点
设：链表头是X，环的第一个节点是Y，slow和fast第一次的交点是Z。各段的长度分别是a,b,c，如图所示。环的长度是L。slow和fast的速度分别是qs,qf。
第一次相遇时slow走过的距离：a+b，fast走过的距离：a+b+c+b。
因为fast的速度是slow的两倍，所以fast走的距离是slow的两倍，有 2(a+b) = a+b+c+b，可以得到a=c（这个结论很重要！）。
发现L=b+c=a+b，也就是说，从一开始到二者第一次相遇，循环的次数就等于环的长度。
已经得到了结论a=c，那么让两个指针分别从X和Z开始走，每次走一步，那么正好会在Y相遇！也就是环的第一个节点。

 * @author sinllychen
 *
 */
public class LinkedListCycleII_142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
        	return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode slow2 = head;
        while(fast!=null && fast.next!=null)
        {
        	slow = slow.next;
        	fast = fast.next.next;
            if(slow == fast)
            {
            	while(slow!=slow2)
            	{
            		slow = slow.next;
            		slow2=slow2.next;
            	}
            	return slow2;
            }
        }
        return null;
    }
}

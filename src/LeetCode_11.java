/**
 * 找出循环节点的起始位置
 * 思路：设置一个慢指针和一个快指针（快指针走一步，慢指针走2步）
 * 若交汇则有循环链表
 * @author sinlly
 *
 */
public class LeetCode_11 {
    class ListNode{
    	int val;
    	ListNode next;
    	ListNode(int x)
    	{
    		val=x;
    		next=null;
    	}
    }
   public boolean hasCycle(ListNode head) {
          ListNode slow=head;
          ListNode fast=head;
          if(head==null)
        	  return false;
          while(fast!=null && fast.next!=null)  //找到快指针和慢指针第一次重合位置.2(k+m)=k+m+d+m  得出d=k
          {
        	  slow=slow.next;
        	  fast=fast.next.next;
        	  if(fast==slow)
        		  break;
          }
          if(fast==null || fast.next==null)
          {
        	  return false;
          }
          else
        	  return true;
   }
}

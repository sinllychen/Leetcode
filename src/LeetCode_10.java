/**
 * 找出循环节点的起始位置
 * 思路：设置一个慢指针和一个快指针（快指针走一步，慢指针走2步）
 * 令k为循环节点位置距离head的距离
 * 令m为快慢指针交汇处慢距离循环节点起始位置的距离
 * 令d为快慢指针交汇处快距离循环节点起始位置的距离
 * 则可知2(k+m)=k+m+d+m  推出k=d
 * @author sinlly
 *
 */
public class LeetCode_10 {
    class ListNode{
    	int val;
    	ListNode next;
    	ListNode(int x)
    	{
    		val=x;
    		next=null;
    	}
    }
    public ListNode detectCycle(ListNode head) {
          ListNode slow=head;
          ListNode fast=head;
          if(head==null)
        	  return null;
          while(fast!=null && fast.next!=null)  //找到快指针和慢指针第一次重合位置.2(k+m)=k+m+d+m  得出d=k
          {
        	  slow=slow.next;
        	  fast=fast.next.next;
        	  if(fast==slow)
        		  break;
          }
          if(fast==null || fast.next==null)
          {
        	  return null;
          }
          slow=head; //将慢指针指向头节点
          while(slow!=fast) //快慢指针都走一步交汇处即为循环节点的起始位置
          {
        	  slow=slow.next;
        	  fast=fast.next;
          }
          return slow;
    }
}

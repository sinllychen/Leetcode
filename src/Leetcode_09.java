import com.sinllychen.common.ListNode;


public class Leetcode_09 {
      public void reorderList(ListNode head) {
              ListNode first=head;
              ListNode second=head;
              ListNode pre=head;
              if(head==null || head.next==null)
            	    return;
              while(second!=null && second.next!=null)
              {
            	   second=second.next.next;
            	   pre=first;
            	   first=first.next;
              }
              pre.next=null;
              ListNode secHead=first;
              pre=first.next;
              ListNode cur=first.next;
              while(cur!=null)
              {
            	    cur=cur.next;
            	    pre.next=secHead;
            	    secHead=pre;
            	    pre=cur;
              }
              first.next=null;
              cur=head;
              while(secHead!=null && cur!=null)
              {
            	     ListNode tmp1Node=cur.next;
            	     cur.next=secHead;
            	     ListNode tmp2Node=secHead.next;
            	     secHead.next=tmp1Node;
            	     pre=cur.next;
            	     cur=tmp1Node;
            	     secHead=tmp2Node;
              }
              pre.next=secHead;
      }
      public static void main(String[] args)
      {
    	   ListNode head=new ListNode(1);
    	   ListNode p=head;
    	   for(int i=2;i<=8;i++)
    	   {
    		   ListNode node=new ListNode(i);
    		   head.next=node;
    		   head=head.next;
    	   }
    	   new Leetcode_09().reorderList(p); 
    	   while(p!=null)
    	   {
    		   System.out.print( p.val+"  ");
    		   p=p.next;
    	   }
      }
}

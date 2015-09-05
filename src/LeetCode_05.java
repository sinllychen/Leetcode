public class LeetCode_05 {
       public ListNode insertionSortList(ListNode head) {
               if(head==null || head.next==null)
            	      return head;
               ListNode cur=head.next;
               while(cur!=null)
               {
            	   ListNode q=head;
            	   while(q.val<cur.val && q!=cur)
            		      q=q.next;
            	   if(q!=cur)
            	   {
            		     int key=cur.val;
            		     int value;
            		     while(q!=cur)
            		     {
            		    	   value=q.val;
            		    	   q.val=key;
            		    	   key=value;
            		    	   q=q.next;
            		     }
            		     cur.val=key;
            	   }
            	   cur=cur.next;
               }
               return head;
       }
       public static void main(String[] args)
       {
    	       ListNode p=new ListNode(-1);
    	       ListNode q=p;
    	       for(int i=9;i>=0;i--)
    	       {
    	    	   ListNode temp=new ListNode(i);
    	    	   p.next=temp;
    	    	   p=p.next;
    	       }
    	       ListNode result= new LeetCode_05().insertionSortList(q.next);
    	       while(result!=null)
    	       {
    	    	      System.out.print(result.val+"  ");
    	    	      result=result.next;
    	       }
       }
}

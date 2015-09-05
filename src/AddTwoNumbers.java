import java.math.BigInteger;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class AddTwoNumbers {
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	      ListNode result ;
	      Stack<BigInteger> digit1=new Stack<BigInteger>();
	      ListNode tmp=l1;
	      while(tmp!=null)
	      {
	    	  digit1.push(BigInteger.valueOf(tmp.val));
	    	  tmp=tmp.next;
	      }
	      BigInteger sum1=BigInteger.valueOf(0);
	      for(int i=digit1.size()-1;i>=0;i--)
	      {
	    	  BigInteger tmpVal= digit1.pop().multiply(BigInteger.valueOf(10).pow(i));
	    	  sum1=sum1.add(tmpVal);
	      }
	      Stack<BigInteger> digit2=new Stack<BigInteger>();
	      tmp=l2;
	      while(tmp!=null)
	      {
	    	  digit2.push(BigInteger.valueOf(tmp.val));
	    	  tmp=tmp.next;
	      }
	      BigInteger sum2=BigInteger.valueOf(0);
	      for(int i=digit2.size()-1;i>=0;i--)
	      {
	    	  BigInteger tmpVal= digit2.pop().multiply(BigInteger.valueOf(10).pow(i));
	    	  sum2=sum2.add(tmpVal);
	      }
	      BigInteger totalSum=sum1.add(sum2);
	      String tmpSum=totalSum.toString();
	      result=new ListNode(Integer.valueOf(tmpSum.substring(tmpSum.length()-1, tmpSum.length())));
	      ListNode tmpNode=result;
	      for(int i=tmpSum.length()-2;i>=0;i--)
	      {
	    	  ListNode node=new ListNode(Integer.valueOf(tmpSum.substring(i, i+1)));
	    	  tmpNode.next=node;
	    	  tmpNode=node;
	      }
	      return result;
	      
//	      ListNode p1 = l1;
//	        ListNode p2 = l2;
//	 
//	        ListNode newHead = new ListNode(0);
//	        ListNode p3 = newHead;
//	 
//	        int val;//store sum
//	 
//	        boolean flag = false;//flag if greater than 10
//	 
//	        while(p1 != null || p2 != null){
//	            //both p1 and p2 have value
//	            if(p1 != null && p2 != null){
//	 
//	                if(flag){
//	                    val = p1.val + p2.val + 1;
//	                }else{
//	                    val = p1.val + p2.val;
//	                }
//	 
//	                //if sum >= 10
//	                if(val >= 10 ){
//	                    flag = true;
//	 
//	                //if sum < 10
//	                }else{
//	                    flag = false;
//	                }
//	 
//	                p3.next = new ListNode(val%10);
//	                p1 = p1.next;
//	                p2 = p2.next;
//	            //p1 is null, because p2 is longer                
//	            }else if(p2 != null){
//	 
//	                if(flag){
//	                    val = p2.val + 1;
//	                    if(val >= 10){
//	                        flag = true;
//	                    }else{
//	                        flag = false;
//	                    }
//	                }else{
//	                    val = p2.val;
//	                    flag = false;
//	                }
//	 
//	                p3.next = new ListNode(val%10); 
//	                p2 = p2.next;
//	 
//	            ////p2 is null, because p1 is longer  
//	            }else if(p1 != null){
//	 
//	                if(flag){
//	                    val = p1.val + 1;
//	                    if(val >= 10){
//	                        flag = true;
//	                    }else{
//	                        flag = false;
//	                    }
//	                }else{
//	                    val = p1.val;
//	                    flag = false;
//	                }
//	 
//	                p3.next = new ListNode(val%10); 
//	                p1 = p1.next;
//	            }
//	 
//	            p3 = p3.next;
//	        }
//	 
//	        //handle situation that same length final sum >=10
//	        if(p1 == null && p2 == null && flag){
//	            p3.next = new ListNode(1);
//	        }
//	 
//	        return newHead.next;
	 }
	 public static void main(String[] args)
	 {
		 ListNode node1=new ListNode(9);
		
		 ListNode node4=new ListNode(1);
		 ListNode tmp=node4;
		 for(int i=0;i<9;i++)
		 {
			 ListNode node5=new ListNode(9);
			 tmp.next=node5;
			 tmp=tmp.next;
		 }
		 
		 AddTwoNumbers opt=new AddTwoNumbers();
		 ListNode result=opt.addTwoNumbers(node1,node4);
		 while(result!=null)
		 {
			 System.out.println(result.val);
			 result=result.next;
		 }
		 
	 }
}


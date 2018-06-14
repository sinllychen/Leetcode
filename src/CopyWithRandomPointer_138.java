import java.util.HashMap;

import com.sinllychen.common.RandomListNode;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
   Return a deep copy of the list.
 * @author sinllychen
 */
public class CopyWithRandomPointer_138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
        	return head;
        HashMap<RandomListNode,RandomListNode> maps = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        maps.put(head, newHead);
        RandomListNode curOldNode = head.next;  //当前老节点
        RandomListNode preNewNode = newHead; //当前新节点的前一个节点
        //第一次遍历进行简单复制
        while(curOldNode!=null)
        {
        	RandomListNode curNewNode = new RandomListNode(curOldNode.label); //当前新节点
        	preNewNode.next = curNewNode;
        	maps.put(curOldNode	, curNewNode);
        	curOldNode = curOldNode.next;
        	preNewNode = preNewNode.next;
        }
        
        //第二次遍历进行Random节点复制
        curOldNode = head;
        preNewNode = newHead;
        while(curOldNode!=null)
        {
        	RandomListNode rand = maps.get(curOldNode.random);
        	preNewNode.random = rand;
        	curOldNode = curOldNode.next;
        	preNewNode = preNewNode.next;
        }
        return newHead;
        
    }   
}

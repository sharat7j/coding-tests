/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //using min heap
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
        for(int i=0;i<lists.length;i++){
            ListNode list=lists[i];
            while(list!=null){
                queue.add(list.val);
                list=list.next;
            }
        }
        ListNode result=null;
        ListNode start=null;
        if(!queue.isEmpty()){
                   result=new ListNode(queue.remove());
                   start=result;
        }
        while(!queue.isEmpty()){
            ListNode tmp=new ListNode(queue.remove());
            result.next=tmp;
            result=tmp;
            
            
            
            
        }
        return start;
    }
}

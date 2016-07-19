//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

//use recursion to get height balanced tree
 //test 1= 1,2,3,4,5,6,7
 //step1 - get middle element of the array. make that current root. If current root is null then make that as root of whole tree
 //else make it child of previous root.
 //step2: get the left array right array of mid element. make the node returned as left and right child respectively
 // step3: repeat step 2 . if there is only one element, create the node and return,else get mid node make it cur root,return that
 //step4:return root node at the end.
 
 //ex- 1,2,3,4,5,6,7
 //mid is 4-root 
 
// 4 is root. left array-1,2,3 .right array- 5,6,7
// for 1,2,3.. 2 is root. left sub array- 1, right sub array -3 .return 2 which will become left child of 4
//1 is single so return 1. 1 is left child of 2. 3 is single so return. right child of 2 is 3
// for 5,6,7, 6 is mid. 5 is left, 7 is right. return 6 which will be right child of 4
// 5 is left child and 7 is right of 6
//ex- 1,2,3,4,5,6. 
// 3
//2 5
//1 4 6

/**
 * Definition for singly-linked list. */
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
/**
 * Definition for a binary tree node.
 */
 class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Solution {

    public static TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode currNode=head;
        int count=0;
        ArrayList<Integer> array=new ArrayList<Integer>();
        while(currNode!=null){
            array.add(currNode.val);
            currNode=currNode.next;
            count=count+1;
            
        }
        //get mid for even or odd sized list
        int mid=0;
        if(count%2==0){
        	mid=count/2-1;
        }else {
        	mid=count/2;
        }
        //reset
        count =0;
        
        currNode=head;
        
        
        TreeNode root=new TreeNode(array.get(mid));
if(array.subList(0,mid).size()>=1){
        TreeNode left=createSubTree(array.subList(0,mid),root);
}
if(array.subList(mid+1,array.size()).size()>=1){
        TreeNode right=createSubTree(array.subList(mid+1,array.size()),root);

}
        return root;
    }
    
    public static TreeNode createSubTree(List<Integer> curList,TreeNode root){
    	if(curList.size()==1){
    		TreeNode node=new TreeNode(curList.get(curList.size()-1));
    		
    		return node;
    	}
    	int mid=0;
    	if(curList.size()%2==0){
    		mid=curList.size()/2-1;
    	}else{
    		mid=curList.size()/2;
    	}
    	    	TreeNode parent=new TreeNode(curList.get(mid));
    	    	if(curList.subList(0,mid).size()>=1){
    	TreeNode left=createSubTree(curList.subList(0, mid),parent);
    	    	}
    	if(curList.subList(mid+1,curList.size()).size()>=1){
    	TreeNode right=createSubTree(curList.subList(mid+1,curList.size()),parent);

    	}
    	return parent;
 } 

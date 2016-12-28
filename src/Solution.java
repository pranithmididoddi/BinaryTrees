/**
 * Created by Pranith on 12/27/16.
 */
import java.util.*;



public class Solution {

    /**Iterative approach for inorder tree traversal*/
    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();

        TreeNode p=root;

        while(!stack.isEmpty() || p!=null){
            if(p!=null){
                stack.push(p);
                p=p.left;
            }
            else{
                TreeNode temp=stack.pop();
                list.add(temp.val);
                p=temp.right;
            }
        }
        return list;
    }
    /**Identical binary trees*/
    public static int isSameTree(TreeNode a, TreeNode b) {

        if(isBooleanTree(a,b)){
            return 1;
        }
        return 0;
    }
    public static boolean isBooleanTree(TreeNode a, TreeNode b){
        if(a==null && b==null) return true;
        if(a==null || b==null) return false;

        if(a.val==b.val){ return (isBooleanTree(a.left,b.left)) && (isBooleanTree(a.right,b.right));}
        else return false;
    }

    /**Symmetric binary trees*/
    public int isSymmetric(TreeNode a) {

        if(areSymmetric(a.left,a.right)) return 1;

        return 0;
    }

    public boolean areSymmetric(TreeNode lc, TreeNode rc){
        if(lc ==null && rc==null) return true;

        if(lc==null || rc==null) return false;

        if(lc.val!=rc.val) return false;

        if(!areSymmetric(lc.left,rc.right)) return false;
        if(!areSymmetric(lc.right,rc.left)) return false;

        return true;
    }

    /**SortedArray to binary search tree*/
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;

        return sortedArrayToBST(nums,0,nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end){
        if(start>end) return null;

        int mid=(start+end)/2;
        TreeNode root=new TreeNode(nums[mid]);

        root.left=sortedArrayToBST(nums,start,mid-1);
        root.right=sortedArrayToBST(nums,mid+1,end);

        return root;

    }

    /**List to BST*/
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        if(a.isEmpty()) return null;

        int size=a.size();

        return sortedArrayToBST(a,0,size-1);
    }

    public TreeNode sortedArrayToBST(List<Integer> a, int start, int end){
        if(start>end) return null;

        int mid=(start+end)/2;
        TreeNode root=new TreeNode(a.get(mid));

        root.left=sortedArrayToBST(a, start, mid-1);
        root.right=sortedArrayToBST(a, mid+1, end);

        return root;
    }
}
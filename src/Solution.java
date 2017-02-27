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

    /**Preorder traversal*/
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(root==null) return list;
        Stack<TreeNode> stack=new Stack<>();

        stack.push(root);

        while(!stack.empty()){
            TreeNode temp=stack.pop();
            list.add(temp.val);

            if(temp.right!=null){
                stack.push(temp.right);
            }

            if(temp.left!=null){
                stack.push(temp.left);
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

    /**Leetcode max depth*/
    public int maxDepth(TreeNode a) {

        if(a==null) return 0;

        int leftDepth=maxDepth(a.left);
        int rightDepth=maxDepth(a.right);

        int maxDepth=Math.max(leftDepth,rightDepth);

        return maxDepth+1;
    }

/**invert a binary tree*/
    public TreeNode invertTree(TreeNode root) {

        if(root!=null){
            invertbst(root);
        }

        return root;

    }

    public void invertbst(TreeNode root){
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        if(root.left!=null){
            invertbst(root.left);
        }

        if(root.right!=null){
            invertbst(root.right);
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(isabalancedtree(root)<1) return false;
        return true;
    }

    public int isabalancedtree(TreeNode root){
        if(root==null) return 1;

        int right=isabalancedtree(root.right);
        int left=isabalancedtree(root.left);

        if(left==-1 || right==-1) return -1;

        if(Math.abs(left-right)>1) return -1;

        return Math.max(left,right)+1;
    }
    /**finding the kth smallest element*/
    public int kthSmallest(TreeNode root, int k) {

        TreeNode p=root;
        int result=0;
        Stack<TreeNode> stack=new Stack<>();

        while(!stack.empty() || p!=null){
            if(p!=null){
                stack.push(p);
                p=p.left;
            }
            else{
                TreeNode temp=stack.pop();
                k--;

                if(k==0){
                    result=temp.val;
                }
                p=temp.right;

            }
        }
        return result;
    }

    /**Same Tree*/

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;

        if(p.val==q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }

        return false;

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();

        if(root==null){
            return list;
        }

        queue.offer(root);

        while(!queue.isEmpty()){
            ArrayList<Integer> lst=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode head=queue.poll();
                lst.add(head.val);

                if(head.left!=null){
                    queue.offer(head.left);
                }
                if(head.right!=null){
                    queue.offer(head.right);
                }
            }
            list.add(lst);
        }
        return list;
    }

    public List<Integer> largestValues(TreeNode root) {

        Queue<TreeNode> queue=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        queue.offer(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            int maxval=Integer.MIN_VALUE;

            for(int i=0;i<size;i++){
                TreeNode temp=queue.poll();
                maxval=Math.max(temp.val, maxval);

                if(temp.left!=null){
                    queue.offer(temp.left);
                }

                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
            list.add(maxval);
        }
        return list;
    }

    public int maxDepth(TreeNode root) {

        if(root==null) return 0;

        int leftval=maxDepth(root.left);
        int rightval=maxDepth(root.right);

        return Math.max(leftval,rightval)+1;
    }

    /**Validate Binary Search tree*/
    public boolean isValidBST(TreeNode root) {

        return validateBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);

    }

    public boolean validateBST(TreeNode p, double min, double max){
        if(p==null) return true;

        if(p.val<=min || p.val>=max) return false;

        return validateBST(p.left,min,p.val)&&validateBST(p.right,p.val,max);
    }

    /**Lowest common ancestor of two nodes*/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;

        if(root==p || root==q) return root;

        TreeNode l=lowestCommonAncestor(root.left,p,q);
        TreeNode r=lowestCommonAncestor(root.right,p,q);

        if(l==null&&r==null){
            return null;
        }
        else if(l!=null&&r!=null){
            return root;
        }else{
            return l==null?r:l;
        }
    }

    /**Balanced binary tree check*/

    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;

        if(isBalance(root)==-1)return false;
        return true;
    }

    public int isBalance(TreeNode root){
        if(root==null) return 0;

        int leftval=isBalance(root.left);
        int rightval=isBalance(root.right);

        if(leftval==-1 || rightval==-1) return -1;
        if(Math.abs(leftval-rightval)>1) return -1;

        return Math.max(leftval,rightval)+1;
    }

}
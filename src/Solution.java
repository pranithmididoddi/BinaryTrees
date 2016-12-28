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
}
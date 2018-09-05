import BinarySearch.TreeNode;

class Solution {
    public class ResultType{
        public int max;
        public int min;
        public boolean isBST;
        public ResultType(int max, int min, boolean isBST){
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root).isBST;
    }

    private ResultType isValidBSTHelper(TreeNode root){
        if (root == null){
            return new ResultType(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }

        ResultType left = isValidBSTHelper(root.left);
        ResultType right = isValidBSTHelper(root.right);
        if (!left.isBST || !right.isBST){
            return new ResultType(0,0,false);
        }
        if (left.max > root.val || right.min < root.val){
            return new ResultType(0,0,false);
        }
        ResultType result = new ResultType(root.val, root.val, true);
        result.max = Math.max(Math.max(root.val, left.max),right.max);
        result.min = Math.min(Math.max(root.val, left.min),right.min);
        return result;
    }
}
package jianzhi.offer;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class jz05 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int left=0,right=preorder.length-1;
        if(left>right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int i=0;
        while(i<=right){
            if(root.val==inorder[i]){
                break;
            }
            i++;
        }
        root.left=build(preorder,inorder,left,i-1);
        root.right=build(preorder,inorder,i+1,right);
        return root;
    }
    TreeNode build(int[] preorder,int[] inorder,int left,int right){
        if(left>right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[left]);
        int i=left;
        while(i<=right){
            if(root.val==inorder[i]){
                break;
            }
            i++;
        }
        root.left=build(preorder,inorder,left,i-1);
        root.right=build(preorder,inorder,i+1,right);
        return root;
    }
    public static void main(String[] args) {
        int[] preorder={3,9,20,15,7};
        int[] inorder={9,3,15,20,7};
        new jz05().buildTree(preorder, inorder);
    }
}
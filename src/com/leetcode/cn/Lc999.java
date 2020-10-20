package com.leetcode.cn;

/**
 * @author yvzhu
 */
public class Lc999 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        root = dfs(root.left,root,1);
        root = dfs(root.right,root,0);
    }
    TreeNode dfs(TreeNode root,TreeNode father,int flag){
        if(root == null){
            return father;
        }
        TreeNode temp , ftemp;
        if(flag == 1){
            if(father.val < root.val){
                temp = new TreeNode(father.val,root.left,root.right);
                ftemp = new TreeNode(root.val,father.left,father.right);
                ftemp.left = temp;
                return ftemp;
            }
            if(root.right != null){
                if(root.right.val > father.val){
                    temp = new TreeNode(father.val,root.right.left,root.right.right);
                    ftemp = new TreeNode(root.right.val,father.left,father.right);
                    root.right = temp;
                    return ftemp;
                }

            }
        }else{
            if(father.val > root.val){
                temp = new TreeNode(father.val,root.left,root.right);
                ftemp = new TreeNode(root.val,father.left,father.right);
                return ftemp;
            }
            if(root.left != null){
                if(root.left.val > father.val){
                    temp = new TreeNode(father.val,root.left.left,root.left.right);
                    ftemp = new TreeNode(root.left.val,father.left,father.right);
                    return ftemp;
                }
            }
        }
        root = dfs(root.left,root,1);
        root = dfs(root.left,root,0);
        return father;
    }

    public static void main(String[] args) {
        int a = 2;

        boolean b=  true;
        if(b){
            System.out.println(a);
        }
    }

}

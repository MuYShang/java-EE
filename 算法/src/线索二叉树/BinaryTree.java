package 线索二叉树;

//二叉树
public class BinaryTree {
    TreeNode root = new TreeNode(1);

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void frontShow(){
        if (root != null){
            root.frontShow();
        }
    }
    public void midShow(){
        if (root != null){
            root.midShow();
        }
    }
    public void afterShow(){
        if (root != null){
            root.afterShow();
        }
    }


    public TreeNode frontSearch(int i){
        return root.frontSearch(i);
    }

    public void delete(int i){
        if(root.value == i){
            root = null;
        }else {
            root.deleteTree(i);
        }
    }

    //线索化

    TreeNode pre = null;
    public void treeNode(){
        treeNode(root);
    }
    public void treeNode(TreeNode node){
        if(node == null){
            return;
        }
        //处理左
        treeNode(node.leftNode);
        if(node.leftNode == null){
            node.leftNode = pre;
            node.leftType = 1;
        }
        if(pre != null && pre.rightNode == null){
            pre.rightNode = node;
            pre.leftType = 1;
        }

        pre = node;
        //处理右
        treeNode(node.rightNode);
    }


    public void iterator(){
        TreeNode node = root;
        while (node != null){
            while(node.leftType == 0){
                node = node.leftNode;
            }
            System.out.println(node.value);
            while(node.rightType == 1){
                node = node.rightNode;
                System.out.println(node.value);
            }
            node = node.rightNode;


        }
    }



}

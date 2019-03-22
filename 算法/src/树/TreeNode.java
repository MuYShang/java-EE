package 树;

public class TreeNode {
    int value;//权
    TreeNode leftNode;//左节点
    TreeNode rightNode;//右节点

    public TreeNode(int value) {
        this.value = value;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
    //前序遍历
    public void frontShow(){
        System.out.println(value);
        if (leftNode != null){
            leftNode.frontShow();
        }
        if(rightNode != null){
            rightNode.frontShow();
        }
    }
    //中序遍历
    public void midShow(){
        if (leftNode != null){
            leftNode.midShow();
        }
        System.out.println(value);
        if(rightNode != null){
            rightNode.midShow();
        }
    }
    //后序遍历
    public void afterShow(){
        if (leftNode != null){
            leftNode.afterShow();
        }
        if(rightNode != null){
            rightNode.afterShow();
        }
        System.out.println(value);
    }

    //前序查找
    public TreeNode frontSearch(int i){
        TreeNode target = null;
        if(this.value == i){
            return this;
        }else {
            if (leftNode != null){
                target = leftNode.frontSearch(i);
            }
            if (target != null){
               return target;
            }
            if (rightNode != null){
                target = rightNode.frontSearch(i);
            }
        }
        return target;
    }

    //删除节点，删除子树
    public void deleteTree(int i){
        TreeNode parent = this;
        if(parent.leftNode !=null && parent.leftNode.value == i){
            parent.leftNode = null;
            return;
        }
        if(parent.rightNode !=null && parent.rightNode.value == i){
            parent.rightNode = null;
            return;
        }

        parent = leftNode;
        if(parent != null){
            parent.deleteTree(i);
        }

        parent = rightNode;
        if(parent != null){
            parent.deleteTree(i);
        }
    }
}



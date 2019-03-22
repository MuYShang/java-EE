package 二叉查找树;

public class BinaryTree {
    Node root;
    public void add(Node node){
        if(root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

}

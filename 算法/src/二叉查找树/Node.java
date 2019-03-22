package 二叉查找树;

public class Node {
    int value;
    Node left;

    Node right;

    public Node(int value) {
        this.value = value;
    }

    public void add(Node node){
        if(node == null){
            return;
        }
        if(node.value < this.value){
            if(node.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if(node.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

}

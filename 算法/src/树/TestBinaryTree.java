package 树;

public class TestBinaryTree {
    public static void mian(String [] args){
        BinaryTree binaryTree = new BinaryTree();//创建一棵树
        TreeNode root = new TreeNode(1);//创建根节点
        binaryTree.setRoot(root);//把根节点赋给树

        TreeNode rootL = new TreeNode(2);//创建左节点
        root.setLeftNode(rootL);

        TreeNode rootR = new TreeNode(3);//创建右节点
        root.setRightNode(rootR);

        rootL.setLeftNode(new TreeNode(4));
        rootL.setRightNode(new TreeNode(5));

        rootR.setLeftNode(new TreeNode(6));
        rootR.setRightNode(new TreeNode(7));


    }
}

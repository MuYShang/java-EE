package 树;

public class ArrayBinaryTree {
    int [] data;

    public ArrayBinaryTree(int[] data) {
        this.data = data;
    }
    public void frontShow(){
        frontShow(0);
    }

    public void frontShow(int index){
        if(data == null || data.length == 0){
            return;
        }
        System.out.println(data[index]);
        //处理左子树
        if(2*index+1 < data.length){
            frontShow(2*index+1);
        }
        //处理右子树
        if(2*index+2 < data.length){
            frontShow(2*index+2);
        }
    }
}

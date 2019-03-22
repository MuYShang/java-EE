package 赫夫曼树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestHuffmanTree {
    public static void main(String [] args){
        int[] arr = {3,7,8,11,14,23,29,5};
        Node node = creatHuffman(arr);
    }
    public static Node creatHuffman(int arr[]){
        List<Node> list = new ArrayList<>();
        for (int value:arr) {
            list.add(new Node(value));
        }
        while(list.size() >= 1){
            if(list.size() == 1){
                System.out.println(list);
                break;
            }
            Collections.sort(list);
            System.out.println(list);
            Node left = list.get(0);
            Node right = list.get(1);
            Node parent = new Node(left.value + right.value);

            parent.left = left;
            parent.right = right;

            list.remove(left);
            list.remove(right);

            list.add(parent);
        }
        return list.get(0);
    }
}

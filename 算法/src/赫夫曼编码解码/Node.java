package 赫夫曼编码解码;

public class Node implements Comparable<Node> {
    Byte data;
    int value;
    Node left;
    Node right;

    public Node(Byte data, int value) {
        this.data = data;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", value=" + value +
                '}';
    }
    //倒序排列
    @Override
    public int compareTo(Node o) {
        return o.value - this.value;
    }
}

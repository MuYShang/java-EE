package 循环链表;

public class DoubleNode {
    //上一个节点
    DoubleNode pre = this;
    //下有一个节点
    DoubleNode next = this;

    int data;
    public DoubleNode(int data) {
        this.data = data;
    }
    //增加节点
    public void after(DoubleNode node){
        //原来的下一个节点
        DoubleNode nextNext = next;
        //把新节点作为当前节点的下一个节点
        this.next = node;
        //把当前节点作为新节点的上一个节点
        node.pre = this;
        node.next = nextNext;
        nextNext.pre = node;
    }

    //获取下一个节点
    public DoubleNode next(){
        return this.next;
    }
    //上一个节点
    public DoubleNode upNode(){
        return this.pre;
    }

    //获取数据
    public int getData(){
        return this.data;
    }
}

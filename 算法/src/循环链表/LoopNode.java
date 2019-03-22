package 循环链表;

//一个节点
public class LoopNode {
    //节点内容
    int data;
    //下一个节点
    LoopNode next;
    public LoopNode(int data){
        this.data = data;
    }
    //插入一个节点最为当前节点的下一个节点
    public void insertNode(LoopNode node){
        //取出下一个节点最为下下一个节点
        LoopNode nextNext = next;
        //把新节点最为当前节点的下一个节点
        this.next = node;

        node.next = nextNext;
    }
    //删除下一个节点
    public void removeNext(){
        LoopNode newNext = next.next;
        this.next = newNext;
    }

    //获取下一个节点
    public LoopNode next(){
        return this.next;
    }
    //获取节点中的数据
    public int getData(){
        return this.data;
    }

    public boolean isLast(){
        return next == null;
    }
}

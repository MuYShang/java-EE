package 单链表;
//一个节点
public class Node {
    //节点内容
    int data;
    //下一个节点
    Node next;
    public Node(int data){
        this.data = data;
    }

    //追加节点
    public Node append(Node node){
        //当前节点
        Node currentNode = this;
        while(true){
            //取出下一个节点
           Node nextNode =  currentNode.next;
            //如果没有下一个节点
            if (nextNode == null){
                break;
            }
            //赋给当前节点
            currentNode = nextNode;
        }
        //需要追加的节点追加给当前节点的后面
        currentNode.next = node;
        return this;
    }
    //插入一个节点最为当前节点的下一个节点
    public void insertNode(Node  node){
        //取出下一个节点最为下下一个节点
        Node nextNext = next;
        //把新节点最为当前节点的下一个节点
        this.next = node;

        node.next = nextNext;
    }
    //删除下一个节点
    public void removeNext(){
        Node  newNext = next.next;
        this.next = newNext;
    }
    //显示所有节点信息
    public void show(){
        Node currentNode = this;
        while(true){
            System.out.print(currentNode.data+" ");
            currentNode = currentNode.next;
            //如果是最后一个节点
            if(currentNode ==  null){
                break;
            }
        }
        System.out.println();
    }
    //获取下一个节点
    public  Node next(){
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

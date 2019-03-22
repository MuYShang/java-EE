package 赫夫曼编码解码;

import javax.print.DocFlavor;
import java.io.*;
import java.util.*;

public class TestHuffmanCode {
    public static void main(String [] args){
        String msg = "can you can a can as a can canner can a can.";
        byte[] bytes = msg.getBytes();
        //进行赫夫曼压缩
        byte[] b = huffmanZip(bytes);
        //使用指定的赫夫曼编码表进行解码
        byte[] newByte = decode(huffCodes,b);

        //文件压缩
        String src = "";
        String dst = "";
        try {
            zipFile(src,dst);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //文件压缩
    public static void zipFile(String src,String dst) throws IOException {
        //闯进一个输入流
        InputStream is = new FileInputStream(src);
        //创建一个和输入流指向的文件大小的数组
        byte[] b = new byte[is.available()];
        is.read(b);
        is.close();
        //使用赫夫曼进行编码
        byte[] byteZip = huffmanZip(b);
        //输出流
        OutputStream os = new FileOutputStream(dst);
        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos.writeObject(byteZip);
        oos.writeObject(huffCodes);

        oos.close();
        os.close();
    }

    //文件解压
    public static void unZip(String src,String dst) throws Exception{
        InputStream is = new FileInputStream(src);
        ObjectInputStream ois = new ObjectInputStream(is);

        byte[] b = (byte[]) ois.readObject();
        Map<Byte,String> codes = (Map<Byte, String>) ois.readObject();
        ois.close();
        is.close();

        byte[] bytes = decode(codes,b);
        OutputStream os = new FileOutputStream(dst);
        os.write(bytes);
        os.close();
    }

    //使用指定编码表进行解码
    private static byte[] decode(Map<Byte, String> huffCodes,byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        //把byte数组转为一个二进制的字符串
        for(int i = 0;i < bytes.length;i++){
            byte b = bytes[i];
            //是否是最后一个
            boolean flag = (i == bytes.length-1);
            sb.append(byteBitStr(!flag,b));
        }
        //把字符串按照指定的赫夫曼编码进行解码
        //把赫夫曼编码的键值对进行交换
        Map<String,Byte> map = new HashMap<>();
        for (Map.Entry<Byte,String> entry:huffCodes.entrySet()) {
            map.put(entry.getValue(),entry.getKey());
        }

        //创建一个集合。用于存byte
        List<Byte> list = new ArrayList<>();
        //处理字符串
        for(int i = 0;i < sb.length();){
            int count = 1;
            boolean flag = true;
            Byte b = null;
            //截取出一个byte
            while(flag){
                String key = sb.substring(i,i+count);
                b = map.get(key);
                if(b == null){
                    count++;
                }else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        //把集合转换为数组
        byte[] b = new byte[list.size()];
        for(int i = 0;i < list.size();i++ ){
            b[i] = list.get(i);
        }
        return b;
    }

    private static String  byteBitStr(boolean flag, byte b) {
        int temp = b;
        if(flag){
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if(flag){
            return str.substring(str.length()-8);
        }else {
            return str;
        }
    }

    //进行赫夫曼编码压缩的方法
    private static byte[] huffmanZip(byte[] bytes) {
     //先统计每一个byte出现的次数，并放入一个集合中
        List<Node> nodes = getNodes(bytes);
        //创建一颗赫夫曼树
        Node tree = createHuffmanTree(nodes);
        //创建一个赫夫曼编码表
        Map<Byte,String> huffCodes = getCodes(tree);
        //编码
        byte[] b = zip(bytes,huffCodes);
        return b;
    }
    //进行赫夫曼编码
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
        StringBuilder sb = new StringBuilder();
        //把需要压缩的byte数组处理成一个二进制的字符串
        for (byte b:bytes) {
            sb.append(huffCodes.get(b));
        }
        //定义长度
        int len;
        if(sb.length() % 8 == 0){
            len = sb.length() / 8;
        }else {
            len = sb.length() / 8 + 1;
        }
        //用于存储压缩后的byte
        byte[] by = new byte[len];
        //记录新byte的位置
        int index = 0;
        for(int i = 0;i < sb.length();i+=8){
            String strByte;
            if(i+8 > sb.length()){
                strByte = sb.substring(i);
            }else {
                strByte = sb.substring(i,i+8);
            }
            byte byt = (byte)Integer.parseInt(strByte,2);
            by[index] = byt;
            index++;
        }
        return by;
    }
    //用于临时存储路径
    static StringBuilder sb = new StringBuilder();
    //用于存储赫夫曼编码
    static Map<Byte,String> huffCodes = new HashMap<>();
    //根据赫夫曼树获取赫夫曼编码
    private static Map<Byte, String> getCodes(Node tree) {
        if(tree == null){
            return null;
        }
        getCodes(tree.left,"0",sb);
        getCodes(tree.right,"1",sb);
        return huffCodes;
    }
    private static void getCodes(Node node, String code, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(code);
        if(node.data == null){
            getCodes(node.left,"0",sb2);
            getCodes(node.right,"1",sb);
        }else {
            huffCodes.put(node.data,sb2.toString());
        }
    }
    //构建赫夫曼树
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1){
            //排序
            Collections.sort(nodes);
            //q取出来那个过过个权最低的二叉树
            Node left = nodes.get(nodes.size()-1);
            Node right = nodes.get(nodes.size()-2);
            //构建新的二叉树
            Node parent = new Node(null,left.value + right.value);
            parent.left = left;
            parent.right = right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
    //将byte转换为node集合
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        //存储每一个byte出现了多少次
        Map<Byte,Integer> map = new HashMap<>();
        //统计每一个byte的次数
        for (byte b:bytes) {
            Integer count = map.get(b);
            if(count == null){
                map.put(b,1);
            }else {
                map.put(b,count+1);
            }
        }
        //把每一个键值对转为一个node对象
        for (Map.Entry<Byte,Integer> entry :map.entrySet()) {
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }
}

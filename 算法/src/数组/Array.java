package 数组;

import java.util.Arrays;

public class Array {
    //用于存储数据
    private int[] elements;
    public Array(){
        elements = new int[0];
    }
    //数组长度
    public int size(){
        return elements.length;
    }
    //在数组末尾添加元素
    public void add(int element){
        int newArr[] = new int[elements.length+1];
        for (int i = 0;i < elements.length;i++){
            newArr[i] = elements[i];
        }
        newArr[elements.length] = element;
        elements = newArr;
    }
    //打印所有元素
    public void show(){
        System.out.println(Arrays.toString(elements));
    }

    //删除数组元素
    public void delete(int index){
        if(index < 0 || index > elements.length){
            throw new RuntimeException("下标越界");
        }
        int newArr[] = new int[elements.length-1];
        for(int i = 0;i<newArr.length;i++){
            if (i < index){
                newArr[i] = elements[i];
            }else {
                newArr[i] = elements[i+1];
            }
        }
        elements = newArr;
    }
    //去除指定位置元素
    public int select(int index){
        if(index < 0 || index > elements.length){
            throw new RuntimeException("下标越界");
        }
        return elements[index];
    }
    //插入元素到指定位置
    public void  insert(int index,int  element){
        if(index < 0 || index > elements.length){
            throw new RuntimeException("下标越界");
        }
        int newArr[] = new int[elements.length+1];
        for (int i = 0;i < newArr.length;i++){
            if(i < index){
                newArr[i] = elements[i];
            }else {
                newArr[i+1] = elements[i];
            }
        }
        newArr[index] = element;
        elements = newArr;
    }

    //替换指定位置的元素
    public void send(int index,int element){
        if(index < 0 || index > elements.length){
            throw new RuntimeException("下标越界");
        }
        elements[index] = element;
    }
    //替换指定位置的元素
    public int get(int index){
        if(index < 0 || index > elements.length){
            throw new RuntimeException("下标越界");
        }
        return elements[index];
    }
}

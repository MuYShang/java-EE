package 数组;

import java.util.Arrays;

public class Check {
    //线性查找
    public int search(int index[],int element,int elements[]){
        int n = 0;
        for (int i = 0;i < elements.length;i++){
            if(elements[i] == element){
                index[n] = i;
            }
        }
        if(index.length >= 0){
            System.out.println(Arrays.toString(index));
        }
        return -1;
    }


    //二分查找:被查找的数组必须是有序的
    public int search2(int index,int element,int elements[]){
        int start = 0;
        int end = elements.length-1;
        int mid = (start + end)/2;
        int n = -1;
        while(true){
            if(elements[mid] == index){
                n = mid;
                break;
            }else {
                if(elements[mid] > index){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
                mid = (start + end)/2;
            }
            if(start >= end){
                break;
            }
        }
        return -1;
    }
}

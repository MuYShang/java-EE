package Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//快速排序
public class QuickSort<T extends Comparable<T>> extends Sort<T>{
    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums,0,nums.length - 1);
    }

    private void sort(T[] nums,int l,int h){
        if(h <= l){
            return;
        }
        int j =partition(nums,l,h);
        sort(nums,l,j - 1);
        sort(nums,j+1,h);
    }

    private void shuffle(T[] nums){
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }
    //切分
    private int partition(T[] nums,int l ,int h){
        int i = l, j = l + h;
        T v = nums[i];
        while (true){
            while (less(nums[++i],v) && i != h);
            while (less(v,nums[--j]) && j != l);
            if(i >= j){
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }
    //基于切分的快速选择算法
    public T select(T[] nums,int i){
        int l = 0, h = nums.length - 1;
        while (h > l){
            int j = partition(nums,l,h);
            if(j == i){
                return nums[i];
            }else if(j > i){
                h = j - 1;
            }else {
                l = j + 1;
            }
        }
        return nums[i];
    }
}

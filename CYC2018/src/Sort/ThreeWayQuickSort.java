package Sort;
//三向切分
public class ThreeWayQuickSort<T extends Comparable<T>> extends QuickSort<T>{

    public void sort(T[] nums,int l,int h) {
        if(h <= l){
            return;
        }
        int left = l,i = l+1,right = h;
        T v = nums[l];
        while (i < right){
            int cmp = nums[i].compareTo(v);
            if(cmp < 0){
                swap(nums,left++,i++);
            }else if(cmp > 0){
                swap(nums,i,right--);
            }else {
                i++;
            }
        }
        sort(nums,l,left - 1);
        sort(nums,right + 1,h);
    }
}

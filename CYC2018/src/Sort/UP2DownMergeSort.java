package Sort;
//自上而下的归并排序
public class UP2DownMergeSort<T extends Comparable<T>> extends MergeSort<T>{
    @Override
    public void sort(T[] nums) {
        arr = (T[]) new Comparable[nums.length];
        sort(nums,0,nums.length - 1);
    }
    private  void sort(T[] nums,int l,int h){
        if(h <= l){
            return;
        }
        int mid = l + (h - l)/2;
        sort(nums,l,mid);
        sort(nums,mid+1,h);
        merge(nums,l,mid,h);
    }
}

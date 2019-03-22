package Sort;

public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {
    protected T[] arr;

    protected void merge(T[] nums,int m,int l,int h){
        int i = l, j = m + 1;
        for (int k = l;k <= h;k++){
            arr[k] = nums[k];
        }

        for(int k = l;k <= h;k++){
            if (i > m ){
                nums[k] = nums[j++];
            }else if (j > h){
                nums[k] = arr[i++];
            } else if (arr[i].compareTo(arr[j]) <= 0) {
                nums[k] = arr[i++];
            }else {
                nums[k] = arr[j++];
            }
        }
    }
}

package 排序;

import 队列.MyQueue;

import java.util.Arrays;

public class Sort {
    //冒泡排序
    public void bubbleSort(int arr[]){
        //控制比较多少轮
        for (int i = 0;i < arr.length-1;i++){
            for (int j = 0;j < arr.length-1-i;j++){
                if(arr[j] > arr[j+1] ){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    //快速排序
    public void quickSort(int arr[],int start,int end){
        if(start < end){
            //找到基准数,一般为第一个
            int stard = arr[start];
            //记录需要排序的下标
            int low = stard;
            int high = end;
            while(low < high ){
                //右边的数字比标准数大
                while(low < high && arr[high] >= stard ){
                    high--;
                }
                //使用右边的数字替换左边的数
                arr[low] = arr[high];
                while(low < high && arr[low] <= stard){
                    low++;
                }
                //左边比标准小
                arr[high] = arr[low];
            }
            arr[low] = stard;
            //处理所有小的
            quickSort(arr,start,low);
            //处理所有大的
            quickSort(arr,low+1,end);
        }
    }

    //插入排序
    public void insertSort(int arr[]){
        //遍历所有数字
        for (int i = 1; i < arr.length;i++){
            //如果当前数字小于前一个数，暂时保存起来
            if(arr[i] < arr[i-1]){
                int temp = arr[i];
                int j;
                for( j = i-1;j >=0 && arr[j] < temp;j-- ){
                    arr[j+1] = arr[j];
                }
                arr[j+1] = temp;
            }
        }
    }

    //希尔排序
    public void shellSort(int arr[]){
        int k = 1;
        //遍历所有步长
        for (int d = arr.length/2;d > 0;d /= 2){
            //遍历所有元素
            for (int i = d;i < arr.length;i++){
                //遍历本组中所有元素
                for (int j = i - d;j >= 0;j -= d){
                    if(arr[j] > arr[j+d]){
                        int temp = arr[j];
                        arr[j] = arr[j+d];
                        arr[j+d] = temp;
                    }
                }
            }
            System.out.println("第"+ k +"次排序结果"+ Arrays.toString(arr));
            k++;
        }
    }

    //选择排序
    public void selectSort(int arr[]){
        for (int i = 0; i < arr.length;i++){
            int min = i;
            for (int j = i;j < arr.length;j++){
                if(arr[j] < arr[min]){
                   min = j;
                }
            }
            if(i != min){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    //归并排序
    public void megerSort(int arr[],int low,int high){
        int middle = (high+low)/2;
        if(low <high){
            megerSort(arr,low,middle);
            megerSort(arr,middle+1,high);
            mager(arr,low,middle,high);
        }
    }
    //合并
    public void mager(int arr[],int low,int middle,int high){
        int[] temp = new int[high-low+1];//用于存储归并后的临时数组
        int i = low;
        int j = middle+1;
        int index = 0;
        while(i <= middle && j <= high){
            if (arr[i] <= arr[j]){
                temp[index] = arr[i];
                i++;
            }else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        while (j <= high){
            temp[index] = arr[j];
            j++;
            index++;
        }
        while (i <= middle){
            temp[index] = arr[i];
            i++;
            index++;
        }
        for(int k = 0;k < temp.length;k++){
            arr[k+low] = temp[k];
        }

    }

    //基数排序
    public void radixSort(int arr[]){
        //找到数组中最大的数
        int max = Integer.MAX_VALUE;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        //求最大数的位数
        int maxLength = (max+"").length();
        //用于存放基数排序的临时二维数组
        int temp[][] = new int[10][arr.length];
        //用来记录每个余数的以为数组所存入数的个数
        //10刚好对应所有数的余数在1-10之间
        int count[] = new int[10];
        for(int i = 0,n = 1;i < maxLength;i++,n *= 10){
            for(int j = 0;j < arr.length;j++){
                //计算余数
                int ys = arr[j] / n % 10;
                //count[ys]表示存入的数应该放在对应余数的以为数组的对应第几个位置
                temp[ys][count[ys]] = arr[j];
                //
                count[ys]++;
            }
            //把数字取出来
            int index = 0;
            for (int k = 0;k < count.length;k++){
                if(count[k] != 0){
                    for (int l = 0;l < count[k];l++){
                        arr[index] = temp[k][l];
                        index++;
                    }
                    count[k] = 0;
                }
            }
        }
    }

    //基数排序优化:使用队列实现
    public void redixQueueSort(int arr[]){
         //找到数组中最大的数
         int max = Integer.MAX_VALUE;
         for(int i = 0;i < arr.length;i++){
             if(arr[i] > max){
                 max = arr[i];
             }
         }
         //求最大数的位数
         int maxLength = (max+"").length();
         MyQueue[] temp = new MyQueue[10];
         for (int i = 00;i < temp.length;i++){
             temp[i] = new MyQueue();
         }
         for(int i = 0,n = 1;i < maxLength;i++,n *= 10){
             for(int j = 0;j < arr.length;j++){
                 //计算余数
                 int ys = arr[j] / n % 10;
                 //count[ys]表示存入的数应该放在对应余数的以为数组的对应第几个位置
                 temp[ys].push(arr[j]);
             }
             //把数字取出来
             int index = 0;
             for (int k = 0;k < temp.length;k++){
                 while (temp[k].isEmpty()){
                     arr[index] = temp[k].pop();
                     index++;
                     }
                 }
             }
         }

    //堆排序：升序排列使用大顶堆，降序排列使用小顶堆
    public void heapSort(int arr[]){
        int start = (arr.length -1)/2;
        for(int i = start;i>= 0;i--){
            maxHeap(arr,arr.length,i);
        }

        for (int i = arr.length-1;i > 0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap(arr,i,0);
        }
    }
    //转换成为大顶堆
    public void maxHeap(int arr[],int heapSize,int index){
        int leftNode = 2*index+1;
        int rightNode = 2*index+2;
        int max = index;

        if( leftNode < heapSize && arr[leftNode] > arr[max]){
            max = leftNode;
        }
        if (rightNode < heapSize && arr[rightNode] > arr[max]){
            max = rightNode;
        }
        //交换位置
        if(max != index){
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            maxHeap(arr,heapSize,max);


        }


    }


}

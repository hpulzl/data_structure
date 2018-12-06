package com.hpu.lzl.linked.geekbang;

/**
*   
* @author:awo  
* @time:2018/10/18  上午9:21 
* @Description: info
**/  
public class Sort {
    /**
     * 插入排序:
     * 数组左边是已排序区间，右边是未排序区间.
     * 每次排序保证左边区间是已排序状态
     * 4 5 6 1 3 2
     *
     * 时间复杂度 O(n^2)
     * 原地排序
     * 稳定排序
     * @param arrs
     * @return
     */
    public static int[] insertionSort(int[] arrs){
        int n = arrs.length;
        for (int i=1;i<n;i++){
            int val = arrs[i];
            //表示已排序区间
            for (int j=i-1;j>=0;j--){
                if (arrs[j]>val){
                    arrs[j+1]=arrs[j];
                }else{
                    break;
                }
                arrs[j] = val;
            }
            printf("第"+i+"躺排序",arrs);
        }
        return arrs;
    }

    /**
     * 选择排序
     * 从左到右有序，每趟排序会找出最小值放到数组左边。
     * 4 5 6 3 2 1
     *
     * 原地排序
     * 非稳定排序
     * 时间复杂度 O(n^2)
     * @param arrs
     * @return
     */
    public static int[] selectionSort(int[] arrs){
        int n = arrs.length;
        for (int i=0;i<n;i++){
            int min = arrs[i];
            for (int j=i+1;j<n;j++){
                //最小值交换
                if (arrs[j]<min){
                    int temp = min;
                    min = arrs[j];
                    arrs[j] = temp;
                }
                arrs[i] = min;
            }
            printf("第"+i+"躺:",arrs);
        }
        return arrs;
    }

    public static int[] bubbleSort(int[] arrs){
        int n = arrs.length;
        for (int i=0;i<n-1;i++){
            for (int j=0;j<n-i-1;j++){

                if (arrs[j]>arrs[j+1]){
                    int temp = arrs[j+1];
                    arrs[j+1] = arrs[j];
                    arrs[j] = temp;
                }
            }
            printf("第"+i+"躺:",arrs);
        }
        return arrs;
    }

    public static void quickSort(int[] arrs){
        int n = arrs.length;
        quickSortRecursion(arrs,0,n-1);
    }

    public static void quickSortKth(int[] arrs,int k){
        int n = arrs.length;
        quickSortRecursionKth(arrs,0,n-1,k);
    }

    /**
     * 1.递归方式划分数组
     * 2.利用选择排序来原地比较数组数据大小
     * @param arrs
     * @param p
     * @param r
     */
    private static void quickSortRecursionKth(int[] arrs, int p, int r,int k) {
        if (p>=r)  return ;
        //计算分区
        int q = partition(arrs,p,r);
        if (k == q+1){
            System.out.println("==" + arrs[q]);
        }else if (k < q+1){
            quickSortRecursionKth(arrs,p,q-1,k);
        }   else {
            quickSortRecursionKth(arrs,q+1,r,k);
        }
    }
    private static void quickSortRecursion(int[] arrs, int p, int r) {
        if (p>=r) return;
        //计算分区
        int q = partition(arrs,p,r);
        quickSortRecursion(arrs,p,q-1);
        quickSortRecursion(arrs,q+1,r);
    }

    private static int partition(int[] arrs, int p, int r) {
        //一般选择最右边数据作为下标
        int pivot = arrs[r];
        int i = p;
        int temp;
        //交换位置，保证arrs[p~i]中的的数组<pivot
        for (int j=p;j<=r-1;j++){
            if (arrs[j] < pivot){
                temp = arrs[j];
                arrs[j] = arrs[i];
                arrs[i] = temp;
                i++;
            }
        }
        //arrs[i]>pivot，需要交换
        arrs[r] = arrs[i];
        arrs[i] = pivot;
        printf("第"+count+"次排序",arrs);
        count++;
        return i;
    }


    /**
     * 时间复杂度 nlogn
     * 非原地排序（申请临时空间）
     * 稳定排序 相同数据没有交换位置
     * @param arrs
     */
    public static void mergeSort(int[] arrs){
        int n = arrs.length;
        mergeSortRecursion(arrs,0,n-1);
    }
    private static int count = 0;
    private static void mergeSortRecursion(int[] arrs,int p,int r){
        if (p>=r) return;
        int q = (p+r)/2;
        mergeSortRecursion(arrs,p,q);
        mergeSortRecursion(arrs,q+1,r);
        //合并划分的数组
        mergeArr(arrs,p,q,r);
    }

    private static void mergeArr(int[] arrs, int p, int q,int r) {
        int i = p;
        int j = q + 1;
        //申请一个A[p~r]的数组
        int tempLen = r-p+1;
        int[] temps = new int[tempLen];
        int k=0;
        //数组范围在A[p~q] && A[p+1~r]之间
        while (i<=q && j<=r){
            //将较小的数据放入到temps[]的最前排
            if (arrs[i]<arrs[j]){
                temps[k++] = arrs[i++];
            }else {
                temps[k++] = arrs[j++];
            }
        }

        printf("第"+count+"次，数组合并[temps]",temps);

        //将剩余数组中的数据放入到temps[]中。默认是A[p~r]数组剩余
        int start = i;
        int end = q;
        if (j <= r){
            start = j;
            end = r;
        }
        for (;start<=end;start++){
            temps[k++] = arrs[start];
        }

        //将temps[]中的数组放入到arrs[]中
        for (int t=0;t<tempLen;t++){
            arrs[p+t] = temps[t];
        }
        //递归深度计算
        count++;
    }


    //TODO 基于链表的插入排序


    public static void printf(String desc,int[] arrs){
        StringBuffer sb = new StringBuffer();
        sb.append(desc + "[");
        for (int i : arrs){
            sb.append(i+" ");
        }
        sb.append("]\n");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
//        int[] arrs = new int[]{4,5,6,3,21,1};
//        arrs = insertionSort(arrs);
//        printf("插入排序--->result ",arrs);

//        int[] arrs2 = new int[]{4,5,6,3,21,1};
//        arrs2 = selectionSort(arrs2);
//        printf("选择排序--->result ",arrs2);

//        int[] arrs3 = new int[]{4,5,6,3,21,1};
//        arrs3 = bubbleSort(arrs3);
//        printf("选择排序--->result ",arrs3);

//        int[] arrs3 = new int[]{4,5,6,3,21,1};
//        mergeSort(arrs3);
//        printf("归并排序--->result ",arrs3);

//        int[] arrs3 = new int[]{4,5,6,3,21,1};
//        quickSort(arrs3);
//        printf("快速排序--->result ",arrs3);
//
        int[] arrs3 = new int[]{4,5,6,3,21,1};
        quickSortKth(arrs3,3);
    }
}

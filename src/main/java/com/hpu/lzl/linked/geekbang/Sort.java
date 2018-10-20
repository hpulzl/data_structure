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

        int[] arrs3 = new int[]{4,5,6,3,21,1};
        arrs3 = bubbleSort(arrs3);
        printf("选择排序--->result ",arrs3);

    }
}

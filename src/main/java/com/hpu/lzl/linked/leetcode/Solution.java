package com.hpu.lzl.linked.leetcode;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

 注意:
 不能使用代码库中的排序函数来解决这道题。

 示例:

 输入: [2,0,2,1,1,0]
 输出: [0,0,1,1,2,2]

 使用二分法排序。
 */
class Solution {
    public int[] sortColors(int[] nums) {
        int m = nums.length;
        int k=m/2;
        int i=0;
        while(k==0){
            //左边二分
            if (nums[i] < nums[k]){

            }else{
                //右遍历二分
            }
          k = m/2;
        }
        return nums;
    }
}
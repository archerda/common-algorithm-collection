package com.archerda.demo;

import java.util.Arrays;

/**
 * Created by Archerda on 15/9/14.
 */
public class QuickSort {

    public static void main(String[] args){
        int a[] = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a, int begin, int end){
        if(begin < end){ // 如果区间不是只有一个元素，则继续分区
            int i = begin;
            int j = end;
            int pivot = a[begin]; // 保存基准数，并在此处挖坑

            while(i < j){
                while(i < j && a[j] >= pivot){ // 在右边寻找比基准数小的元素
                    j--;
                }
                if(i < j){
                    a[i] = a[j]; // 找到一个比基准数小的元素，扔到左边，在j处挖坑
                    i++; // i开始移动
                }

                while(i < j && a[i] < pivot){ // 在左边寻找比基准数大的元素
                    i++;
                }
                if(i < j){
                    a[j] = a[i]; // 找到一个比基准数大的元素，扔到左边，在i处挖坑
                    j--;
                }
            }
            a[i] = pivot;// 此时i == j，存在一个坑，把基准数填下
            quickSort(a, begin, i - 1); // 对左区间递归
            quickSort(a, i + 1, end); // 对右区间递归
        }
    }

}
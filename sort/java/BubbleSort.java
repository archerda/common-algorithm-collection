package com.archerda.demo;

import java.util.Arrays;

/**
 * Created by Archerda on 15/9/15.
 */
public class BubbleSort{
    public static void main(String[] args){
        int a[] = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        bubbleSort1(a);
        System.out.println(Arrays.toString(a));

    }

    public static void bubbleSort(int[] a){
        int temp = 0;
        for(int i = 0; i < a.length - 1; i++){// 遍历第i次，每一次排好后面的1个
            for(int j = 0; j < a.length - i - 1; j++){// 从a[0]开始，依次去后面尚未排序的元素两两比较，大的置后
                if(a[j] > a[j + 1]){
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    // 优化1：每次排序，如果没有发生任何一次交换位置，说明已经是有序的了。
    public static void bubbleSort1(int[] a){
        int temp = 0;
        boolean flag = false;
        for(int i = 0; i < a.length - 1; i++){ // 遍历第i次，每一次排好后面的1个
            flag = true;
            for(int j = 0; j < a.length - i - 1; j++){// 从a[0]开始，依次去后面尚未排序的元素两两比较，大的置后
                if(a[j] > a[j + 1]){
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = false;
                }
            }

            if(flag) { // 如果没有交换任何一次数据，则说明数组有序
                break;
            }
        }
    }

}

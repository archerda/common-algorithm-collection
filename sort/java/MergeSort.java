package com.archerda.demo;

import java.util.Arrays;

/**
 * Created by Archerda on 15/9/14.
 */
public class MergeSort {

    public static void main(String[] args) {
        int a[] = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        System.out.println(Arrays.toString(mergeSort(a)));
    }

    public static int[] mergeSort(int[] a) {
        if(a.length == 1) { // 先分解到最小数组，然后一层层合并
            return a;
        }

        int half = a.length / 2;
        int[] a1 = new int[half];
        int[] a2 = new int[a.length - half];
        System.arraycopy(a, 0, a1, 0, a1.length); // 新建左边数组
        System.arraycopy(a, half, a2, 0, a2.length); // 新建右边数组

        a1 = mergeSort(a1);
        a2 = mergeSort(a2);
        return mergeSortSub(a1, a2);
    }

    public static int[] mergeSortSub(int[] a1, int[] a2){
        int[] result = new int[a1.length + a2.length];
        int i = 0; // 记录左数组下标
        int j = 0; // 记录右数组下标
        int k = 0; // 记录合并数组下标
        while(true) {
            if(a1[i] < a2[j]) { // 左边数组元素小于右边，左边元素放到合并数组中
                result[k] = a1[i];
                i++;

                if(i > a1.length - 1) { // 左数组已全部遍历
                    break;
                }
            }else { // 左边数组元素大于等于右边，右边元素放到合并数组中
                result[k] = a2[j];
                j++;

                if(j > a2.length - 1) { // 右数组已全部遍历
                    break;
                }
            }

            k++; // 移动合并数组下标
        }

        // 把左右数组中元素比较多的那个数组多余的元素填到合并数组中
        for(; i < a1.length; i++) {
            result[++k] = a1[i]; // 因为上面赋值完后没执行k++，所以k指向的是最后赋值的下标，所以这里需要先++k
        }
        for(; j < a2.length; j++) {
            result[++k] = a2[j];
        }

        return result;
    }
}

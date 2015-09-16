package com.archerda.demo;

import java.util.Arrays;

/**
 * Created by Archerda on 15/9/15.
 */
public class ShellSort {
    public static void main(String[] args) {
        int a[] = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void shellSort(int[] a) {
        int size = a.length;

        // 初始步长为数组长度1/2，每次减半
        for(int gap = size / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < gap; i++) { // 分别处理每个步长分组
                for (int j = i + gap; j < size; j += gap) { // 插入排序
                    if (a[j] < a[j - gap]) {
                        int temp = a[j];
                        int k = j - gap;

                        while (k >= 0 && a[k] > temp) {
                            a[k + gap] = a[k];
                            k -= gap;
                        }

                        a[k + gap] = temp;
                    }
                }
            }
        }
    }

}

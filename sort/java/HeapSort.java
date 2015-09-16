package com.archerda.demo;

import java.util.Arrays;

/**
 * Created by Archerda on 15/9/14.
 */
public class HeapSort {
    public static void main(String[] args) {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

        heapSortAsc(a);            // 升序排列
        System.out.println(Arrays.toString(a));
    }

    /*
     * 堆排序(从小到大)
     *
     * 说明：2个for循环，第一个用于初始化最大堆，第二个用于交换root数据和调整堆；
     */
    public static void heapSortAsc(int[] a) {
        int tmp;
        int arraySize = a.length;

        // 初步全局调整：从第一个非叶子节点开始，调整size/2-1次，也就是对所有非叶子节点进行调整
        for (int i = arraySize / 2 - 1; i >= 0; i--) {
            maxHeapDown(a, i, arraySize - 1);
        }

        // 把a[0]依次与最后一个节点调换，然后调整最最大堆，然后需要调换的节点数量-1
        for (int i = arraySize - 1; i >= 0; i--) {
            // 交换a[0]和a[i]。交换后，a[i]是a[0...i]中最大的。
            tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;

            // 局部调整：从root开始，只需要调整一次，调整的是尚未交换数据的节点
            maxHeapDown(a, 0, i - 1);
        }
    }

    /*
     * (最大)堆的向下调整算法
	 *
	 * 注：数组实现的堆中，第n个节点的左孩子的索引值是(2n+1)，右孩子的索引是(2n+2)。
	 *     其中，n为数组下标索引值。
	 *
	 * 参数说明：
	 *     a -- 待排序的数组
	 *     start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
	 *     end   -- 截至范围(一般为数组中最后一个元素的索引)
	 */
    public static void maxHeapDown(int[] a, int start, int end) {
        int current = start;            // 当前(current)节点的位置
        int left = 2 * current + 1;        // 左(left)孩子的位置
        int tmp = a[current];            // 当前(current)节点的大小

        // 依次遍历其子树
        for (; left <= end; current = left, left = 2 * left + 1) {
            // "left"是左孩子，"left+1"是右孩子
            if (left < end && a[left] < a[left + 1]) {
                left++;        // 左右两孩子中选择较大者
            }

            if (tmp >= a[left]) // 调整结束
                break;
            else {            // 交换值
                a[current] = a[left];
                a[left] = tmp;
            }
        }
    }

}

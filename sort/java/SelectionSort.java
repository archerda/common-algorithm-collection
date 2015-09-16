package com.archerda.demo;

import java.util.Arrays;

public class SelectionSort{
	public static void main(String[] args){
		int a[] = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};  
		selectionSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void selectionSort(int[] a){
		int temp = 0;
		int min = 0;

		for(int i = 0; i < a.length - 1; i++){// 最后2个一比较就出结果了，所以最后一个不用比较了。i个元素排好序。
			min = i;
			for(int j = i + 1; j < a.length; j++){// 需要和全部未排序序列比较
				if(a[min] > a[j]){
					min = j;
				}
			}

			temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
	}
}
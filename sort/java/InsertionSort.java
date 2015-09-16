package com.archerda.demo;

import java.util.Arrays;

public class InsertionSort{
	public static void main(String[] args){
		int a[] = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};  
		insertionSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void insertionSort(int[] a){
		for(int i = 1; i < a.length; i++){ // 因为第一个元素可以认为是有序的，所有从索引为1开始
			int key = a[i];
			int j = i;
			while(j > 0 && a[j - 1] > key){ // 如果前面元素大于新元素
				a[j] = a[j - 1]; // 该大元素往后移动1位
				j--;
			}
			a[j] = key; // 把新元素插入到找到的位置当中
		}
	}
}

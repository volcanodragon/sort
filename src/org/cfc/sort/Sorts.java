package org.cfc.sort;

import java.util.Stack;

public class Sorts {

    /**
     * 冒泡排序
     */
    public static void bubbleSort(Integer[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= i; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j - 1, j);
                }
            }
        }
    }

    /**
     * 插入排序
     */
    public static void insertionSort(Integer[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int temp;
        for (int i = 1; i < nums.length; i++) {
            temp = nums[i];
            for (int j = i; j >= 0; j--) {
                if (j != 0 && temp < nums[j - 1]) {
                    nums[j] = nums[j - 1];
                } else {
                    nums[j] = temp;
                    break;
                }
            }
        }
    }

    /**
     * 选择排序
     */
    public static void selectionSort(Integer[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int minIndex;
        for (int i = 0; i < nums.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(Integer[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int start = 0, end = nums.length - 1, left, right, pivot;
        var stack = new Stack<Integer>();
        stack.push(end);
        stack.push(start);
        while (!stack.isEmpty()) {
            left = start = stack.pop();
            right = end = stack.pop();
            // 取最左值为基准值
            pivot = nums[left++];
            while (left <= right) {
                while (right >= left && nums[right] >= pivot) {
                    right--;
                }
                while (left <= right && nums[left] <= pivot) {
                    left++;
                }
                if (left <= right) {
                    swap(nums, left, right);
                }
            }
            swap(nums, start, right);
            if (start < right - 1) {
                stack.push(right - 1);
                stack.push(start);
            }
            if (right + 1 < end) {
                stack.push(end);
                stack.push(right + 1);
            }
        }
    }

    private static void swap(Integer[] nums, int a, int b) {
        Integer temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}

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
            boolean noSwap = true;
            for (int j = nums.length - 1; j >= i; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j - 1, j);
                    noSwap = false;
                }
            }
            if (noSwap) {
                break;
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

    /**
     * 希尔排序
     */
    public static void shellSort(Integer[] nums) {
        int gap = nums.length, temp;
        while (gap >= 2) {
            gap = gap / 2;
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < nums.length; j = j + gap) {
                    temp = nums[j];
                    for (int k = j; k >= i; k = k - gap) {
                        if (k != i && temp < nums[k - gap]) {
                            nums[k] = nums[k - gap];
                        } else {
                            nums[k] = temp;
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * 归并排序[递归实现]
     */
    public static void mergeSortRec(Integer[] nums) {
        merge(nums, 0, nums.length - 1, new Integer[nums.length]);
    }

    private static void merge(Integer[] nums, int start, int end, Integer[] temp) {
        if (start == end) {
            return;
        }
        int middle = (start + end) / 2;
        merge(nums, start, middle, temp);
        merge(nums, middle + 1, end, temp);
        int m = start, n = middle + 1, t = start;
        while (m <= middle && n <= end) {
            if (nums[m] <= nums[n]) {
                temp[t++] = nums[m++];
            } else {
                temp[t++] = nums[n++];
            }
        }
        while (m <= middle) {
            temp[t++] = nums[m++];
        }
        while (n <= end) {
            temp[t++] = nums[n++];
        }
        System.arraycopy(temp, start, nums, start, end - start + 1);
    }

    private static void swap(Integer[] nums, int a, int b) {
        Integer temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}

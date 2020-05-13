package Algorithm.com.sorting;

import java.util.Arrays;

public class QuickSort {
    
    public static void main(String[] args){
        QuickSort quickSort = new QuickSort();

        int[] numbers = {2, 4, 1, 9, 3, 7, 6, 5, 8, 10};

        quickSort.quickSort(numbers, 0, numbers.length-1);

        System.out.println(Arrays.toString(numbers));
    }

    public void quickSort(int[] array, int first, int last){
        if(first < last){
            int pivot = partition(array, first, last);

            quickSort(array, first, pivot-1);
            quickSort(array, pivot+1, last);
        }
    }

    public int partition(int[] array, int left, int right){
        int pivot = array[(left+right)/2]; // pivot을 중앙값으로 선정

        while(left < right){
            while(array[left] < pivot && left < right){
                left++;
            }
            while(array[right] > pivot && left < right){
                right--;
            }

            if(left < right){
                swap(array, left, right);
            }
        }

        return left;
    }

    public void swap(int[] array, int i, int j){
        int temp;

        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
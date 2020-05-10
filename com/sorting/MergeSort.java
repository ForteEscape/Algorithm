package Algorithm.com.sorting;

import java.util.Arrays;

public class MergeSort {

    int[] temp = new int[10];
    public static void main(String[] args){
        int[] numbers = {5, 2, 6, 7, 1, 3, 9, 8, 10, 4};

        MergeSort merge = new MergeSort();

        merge.mergeSort(numbers, 0, numbers.length-1);

        System.out.println(Arrays.toString(numbers));
    }

    public void mergeSort(int[] array, int first, int last){
        if(first < last){
            int mid = (first+last)/2;

            mergeSort(array, first, mid);
            mergeSort(array, mid+1, last);
            merge(array, first, mid, last);
        }
    }

    public void merge(int[] array, int first, int mid, int last){
        int idx1 = first;
        int idx2 = mid+1;
        int idx3 = first;

        while(idx1 <= mid && idx2 <= last ){
            if(array[idx1] < array[idx2]){
                temp[idx3++] = array[idx1++];
            }
            else{
                temp[idx3++] = array[idx2++];
            }
        }
        while(idx1 <= mid){
            temp[idx3++] = array[idx1++];
        }
        while(idx2 <= last){
            temp[idx3++] = array[idx2++];
        }

        for(int i = first; i<=last; i++){
            array[i] = temp[i];
        }

    }
}
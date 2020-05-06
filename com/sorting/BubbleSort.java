package Algorithm.com.sorting;

import java.util.Scanner;
import java.util.Arrays;

public class BubbleSort {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BubbleSort myBubbleSort = new BubbleSort();

        int[] numbers = new int[10];

        for(int i = 0; i<numbers.length; i++){
            numbers[i] = sc.nextInt();
        }
        sc.close();

        myBubbleSort.bubbleSort(numbers, numbers.length);

        System.out.println("BubbleSorting Complete : " + Arrays.toString(numbers));
    }

    public void bubbleSort(int[] array, int size){ // recursion
        if(size <= 0){
            return;
        }
        else{
            for(int i = 0; i<size-1; i++){
                if(array[i] > array[i+1]){
                    swap(array, i, i+1);
                }
            }

            bubbleSort(array, size - 1);
        }
    }

    public void swap(int[] array, int idx1, int idx2){
        int temp;

        temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;

        return;
    }
}
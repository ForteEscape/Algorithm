package Algorithm.com.sorting;

import java.util.Scanner;
import java.util.Arrays;

public class SelectSort{
    public static void main(String[] args){ // recursion
        SelectSort mySelectionSort = new SelectSort();

        int[] numbers = new int[10];

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i<10; i++){
            numbers[i] = sc.nextInt();
        }

        sc.close();

        mySelectionSort.selectSort(numbers, numbers.length, 0);

        System.out.println(Arrays.toString(numbers));
    }

    public void selectSort(int[] array, int size, int forward){
        if(forward >= size){
            return;
        }
        else{
            int min = 21383647;
            int idx = 0;
            int start = forward;
    
            for(int i = start; i<size; i++){
                if(array[i] < min){
                    min = array[i];
                    idx = i;
                }
            }
    
            swap(array, start, idx);

            selectSort(array, size, forward + 1);
        }
    }

    public void swap(int[] array, int idx1, int idx2){
        int temp = 0;

        temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;

        return;
    }
}
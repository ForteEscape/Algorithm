package Algorithm.com.sorting;

import java.util.Arrays;

public class ShellSort {
    
    public static void main(String[] args){
        int[] numbers = {5, 2, 6, 7, 1, 3, 9, 8, 10, 4};
        ShellSort shellSort = new ShellSort();

        shellSort.shell_sort(numbers, numbers.length);

        System.out.println(Arrays.toString(numbers));
    }

    public void shell_sort(int array[], int length){
        int k = 2;
        int gap = length/k;
        int key;
        int j;

        while(gap > 0){
            for(int i = gap; i < length; i++){
                key = array[i];
                j = i;
                while(j >= gap && array[j-gap]>key){
                    array[j] = array[j-gap];
                    j -= gap;
                }
                array[j] = key;
            }
            gap/=k;
        }
    }
}
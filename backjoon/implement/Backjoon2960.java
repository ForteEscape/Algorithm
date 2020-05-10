package Algorithm.backjoon.implement;

import java.util.Arrays;
import java.util.Scanner;

public class Backjoon2960 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[1001];
        int[] delet = new int[1001];

        int range;
        int key;
        int count, idx=0;

        range = sc.nextInt();
        key = sc.nextInt();

        count = key;

        for(int i = 0; i<= range; i++){
            numbers[i] = i;
        }

        for(int i = 2; i<=range; i++){
            if(count <= 0) break;

            if(numbers[i] != 0){
                for(int j = 1; i<=range; j++){
                    if(i*j > range || idx > range){
                        break;
                    }
                    else{
                        delet[idx] = numbers[i*j];
                        numbers[i*j] = 0;
                        idx++;
                        count--;
                    }
                }
            }
        }
        System.out.println(delet[key]);
    }
}
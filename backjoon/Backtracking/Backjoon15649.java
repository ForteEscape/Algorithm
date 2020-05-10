package Algorithm.backjoon.Backtracking;

import java.util.Scanner;

public class Backjoon15649 {
    
    public static void main(String[] args){
        int number;
        int length;

        int[] array = new int[10];

        Scanner sc = new Scanner(System.in);

        number = sc.nextInt();
        length = sc.nextInt();

        for(int i = 1; i<=number; i++){
            array[i] = i;
        }
    }

    public void sequence(int number, int length){
        
    }
}
package Algorithm.backjoon.implement;

import java.util.Scanner;

public class Backjoon5554 {
    public static void main(String[] args){
        int[] time = new int[4];
        int total = 0;

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i<4; i++){
            time[i] = sc.nextInt();

            total += time[i];
        }

        int min = total/60;
        int sec = total%60;

        System.out.println(min);
        System.out.println(sec);
    }
}
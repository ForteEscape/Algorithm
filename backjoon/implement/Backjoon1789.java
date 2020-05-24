package Algorithm.backjoon.implement;

import java.util.Scanner;

public class Backjoon1789 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long sum;

        sum = sc.nextLong();

        for(long i = 1 ;; i++){
            if(((i+1)*(i))/2 > sum){
                System.out.println(i-1);
                break;
            }
        }
    }
}
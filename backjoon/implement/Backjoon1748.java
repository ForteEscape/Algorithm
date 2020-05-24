package Algorithm.backjoon.implement;

import java.util.Scanner;

public class Backjoon1748 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num;
        int count = 0;

        num = sc.nextInt();

        for(int i = 1; i<=num; i++){
            if(i < 10) count += 1;
            else if(i >= 10 && i < 100) count += 2;
            else if(i >= 100 && i < 1000) count += 3;
            else if(i >= 1000 && i < 10000) count += 4;
            else if(i >= 10000 && i < 100000) count += 5;
            else if(i >= 100000 && i < 1000000) count += 6;
            else if(i >= 1000000 && i < 10000000) count += 7;
            else if(i >= 10000000 && i < 100000000) count += 8;
            else if(i == 100000000) count += 9;
        }

        System.out.println(count);
    }
}
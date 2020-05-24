package Algorithm.backjoon.implement;

import java.util.Scanner;

public class Backjoon5596 {
    public static void main(String[] args){
        int sumS = 0;
        int sumT = 0;
        int temp = 0;

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i<4; i++){
            temp = sc.nextInt();
            sumS += temp;
        }
        for(int i = 0; i<4; i++){
            temp = sc.nextInt();
            sumT += temp;
        }

        if(sumS > sumT){
            System.out.println(sumS);
        }
        else if(sumS < sumT){
            System.out.println(sumT);
        }
        else if(sumS == sumT){
            System.out.println(sumS);
        }
    }
}
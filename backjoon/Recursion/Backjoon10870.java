package Algorithm.backjoon.Recursion;

import java.util.Scanner;

public class Backjoon10870 {
    int num1 = 0;
    int num2 = 1;

    public static void main(String[] args){
        int idx;
        int fibo_number = 0;
        Backjoon10870 prob = new Backjoon10870();

        Scanner sc = new Scanner(System.in);

        idx = sc.nextInt();

        fibo_number = prob.fibo(idx);
        System.out.println(fibo_number);
    }

    public int fibo(int n){
        if(n == 1){
           return 1;
        }
        if(n == 0){
            return 0;
        }
        
        return fibo(n-1) + fibo(n-2);
    }
}
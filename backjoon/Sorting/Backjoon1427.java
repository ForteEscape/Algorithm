package Algorithm.backjoon.Sorting;

import java.util.Scanner;
import java.util.Arrays;

public class Backjoon1427 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number;

        number = sc.nextInt();

        sorting(number);
    }
    
    public static void sorting(int number){
        int temp = number;
        int length;
        String num;
        String reverse = "";

        num = Integer.toString(number);
        length = num.length();

        int[] numberArr = new int[length];

        for(int i = 0;; i++){
            if(temp <= 0){
                break;
            }
            else{
                numberArr[i] = temp % 10;
                temp /= 10;
            }
        }
        Arrays.sort(numberArr);

        for(int i = length-1; i>=0; i--){
           reverse += Integer.toString(numberArr[i]);
        }

        System.out.println(reverse);
    }
}
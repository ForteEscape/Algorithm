package Algorithm.backjoon.While;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Backjoon10951{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()){
            int number1 = sc.nextInt();
            int number2 = sc.nextInt();

            System.out.println(number1+number2);
        }
    }
}
package Algorithm.backjoon.Math;

import java.util.Scanner;

public class backjoon1475 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] number = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int count = 1;

        int key = sc.nextInt();
        int num = 0;

        while(key > 0){
            num = key % 10;
            
            if(number[num] == 0){
                if(num == 6 && number[num] == 0 && number[9] != 0){
                    number[9]--;
                }
                else if(num == 9 && number[num] == 0 && number[6] != 0){
                    number[6]--;
                }
                else{
                    for(int i = 0; i<number.length; i++){
                        number[i]++;
                    }
                    count++;
    
                    number[num]--;
                }

                key /= 10;
            }
            else{
                number[num]--;
                key /= 10;
            }
        }
        System.out.println(count);
    }
}
package Algorithm.SW_ExpertAcademy;

import java.util.Scanner;

public class SW1206 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int length;
        int[] height = new int[1001];
        int view = 0;

        length = sc.nextInt();

        for(int i = 2; i<length-2; i++){
            height[i] = sc.nextInt();
        }

        for(int i = 2; i<length-2; i++){
            if(height[i] > height[i-1] && height[i] > height[i+1]){
                view++;
            }
        }
    }
}
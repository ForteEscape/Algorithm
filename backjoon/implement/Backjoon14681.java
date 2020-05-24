package Algorithm.backjoon.implement;

import java.util.Scanner;

public class Backjoon14681 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Scanner sc2 = new Scanner(System.in);

        int posx = 0;
        int posy = 0;

        posx = sc.nextInt();
        posy = sc.nextInt();

        if(posx > 0){
            if(posy > 0) System.out.println("1");
            else if(posy < 0) System.out.println("4");
        }
        else if(posx < 0){
            if(posy > 0) System.out.println("2");
            else if(posy < 0) System.out.println("3");
        }
    }
}
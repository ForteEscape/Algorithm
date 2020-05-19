package Algorithm.com.Others.homework2;

import java.util.Scanner;

public class Sit {
    final static int MAX = 11;

    public static void main(String[] args){
        String state = "";
        String bar = "------------------------------";
        int number = 0;
        int[] seat = new int[MAX];
        int[] res = new int[MAX];

        for(int i = 1; i<MAX; i++){
            seat[i] = i;
        }
        for(int i = 1; i<MAX; i++){
            res[i] = 0;
        }

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        for(;;){
            System.out.print("예약은 Y 종료는 N : ");
            state = sc.nextLine();

            if(state.equals("Y")){
                System.out.println("현재 예약 상태 ");
                System.out.println(bar);

                for(int i = 1; i<MAX; i++){
                    System.out.print(seat[i] + " ");
                }
                System.out.println("\n" + bar);

                for(int i = 1; i<MAX; i++){
                    System.out.print(res[i]+ " ");
                }
                System.out.println("\n몇번째 좌석 예약? : ");
                number = sc2.nextInt();
                
                if(number >= MAX || number <= 0){
                    System.out.println("range out try again");
                }
                else{
                    if(res[number] == 0){
                        res[number] = 1;
                        System.out.println("reserved");
                    }
                    else{
                        System.out.println("Already reserved");
                    }
                }
            }
            else{
                if(state.equals("N")){
                    System.out.println("Final reserved seat print");
                    System.out.println(bar);
                    for(int i = 1; i<MAX; i++){
                        System.out.print(res[i] + " ");
                    }
                    System.out.println("\n" + bar);

                    System.out.println("reserve System out");
                    break;
                }
                else if(!state.equals("Y") && !state.equals("N")){
                    System.out.println("Answer is Y or N");
                }
            }
        }
    }
}
package Algorithm.programmers.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class NumberofK {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] command = new int[50][3];
        int[] array = new int[101];
        int[] ans = {};

        for(int i = 0; i<7; i++){
            array[i] = sc.nextInt();
        }

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                command[i][j] = sc.nextInt();
            }
        }
        sc.close();

        ans = solution(array, command);

        System.out.println(Arrays.toString(ans));
    }

    public static int[] solution(int[] array, int[][] commands){
        int[] answer = new int[commands.length];

        for(int i = 0; i<commands.length; i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int key = commands[i][2];
            int idx = 0;

            int[] sliceArr = new int[(end-start)+1];

            for(int j = start-1; j<=end-1; j++){
                sliceArr[idx++] = array[j];
            }
            Arrays.sort(sliceArr);
            
            answer[i] = sliceArr[key-1];
            Arrays.fill(sliceArr, 0);

            idx = 0;
        }
        return answer;
    }
}
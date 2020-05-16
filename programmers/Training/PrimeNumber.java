package Algorithm.programmers.Training;

import java.util.Arrays;

public class PrimeNumber {
    public static int solution(int number){
        int answer = 0;
        int j = 2;
        int[] array = new int[number+1];

        for(int i = 2; i<=number; i++){
            array[i] = i;
        }

        for(int i = 2; i<=number; i++){
            if(array[i] == -1) continue;

            for(j = 2;;j++){
                if(i*j > number) break;
                else{
                    array[i*j] = 0;
                }
            }
        }

        for(int i = 0; i<=number; i++){
            if(array[i] != 0) answer++;
        }

        return answer;
    }
}
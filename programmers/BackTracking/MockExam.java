package Algorithm.programmers.BackTracking;

import java.util.Arrays;

public class MockExam {

    public static void main(String[] args){
        int[] answer = {4};
        
        int ans[] = solution(answer);
        System.out.println(Arrays.toString(ans));
    }


    public static int[] solution(int[] answers){
        int[] answerOfNum1 = {1, 2, 3, 4, 5};
        int[] answerOfNum2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answerOfNum3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] cnt = new int[3];

        for(int i = 0; i<answers.length; i++){
            int idx1 = i%5, idx2 = i%8, idx3 = i%10;

            if(answers[i] == answerOfNum1[idx1]){
                cnt[0]++;
            }
            if(answers[i] == answerOfNum2[idx2]){
                cnt[1]++;
            }
            if(answers[i] == answerOfNum3[idx3]){
                cnt[2]++;
            }
        }

        int[] temp = Arrays.copyOf(cnt, cnt.length);
        Arrays.sort(temp);
        int isMany = 0;

        for(int i = 0; i<3; i++){
            if(cnt[i] == temp[2]){
                isMany++;
            }
        }

        System.out.println(Arrays.toString(cnt));
        //System.out.println(Arrays.toString(temp));
        //System.out.println(isMany);

        if(isMany >= 2){
            int[] answer = new int[3];
            int max = -2121;
            int idx = 0;

            if(cnt[0] == cnt[1] && cnt[1] == cnt[2]){
                answer[0] = 1;
                answer[1] = 2;
                answer[2] = 3;
            }
            else{
                for(int i = 0; i<3; i++){
                    for(int j = 0; j<3; j++){
                        if(cnt[j] > max){
                            max = cnt[j];
                            idx = j;
                        }
                    }
                    answer[i] = idx+1;
                    cnt[idx] = -1;
                    max = -2121;
                }

            }

            
            //System.out.println(Arrays.toString(answer));
            
            return answer;
        }
        else{
            int[] answer = new int[1];
            int idx = 0;
            int max = -1;

            for(int i = 0; i<3; i++){
                if(cnt[i] > max){
                    max = cnt[i];
                    idx = i;
                }
            }

            //System.out.println(idx);
            answer[0] = idx+1;

            return answer;
        }
    }
}
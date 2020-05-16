package Algorithm.programmers.Training;

public class FindKim {
    public static void main(String[] args){
        String[] seoul = {"Jane", "Kim"};

        solution(seoul);
    }

    public static String solution(String[] seoul){
        String answer = "";
        int idx = 0;

        for(int i = 0; i<seoul.length; i++){
            if(seoul[i].equals("Kim")){
                idx = i;
                break;
            }
        }
        //System.out.println(idx);
        answer = "김서방은 "+idx+"에 있다";
        System.out.println(answer);
        return answer;
    }
}
package Algorithm.backjoon.Sorting;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Position implements Comparable<Position>{
    public int posx;
    public int posy;

    Position(int posx, int posy){
        this.posx = posx;
        this.posy = posy;
    }

    public int compareTo(Position pos){
        if(this.posx > pos.posx){
            return 1;
        }
        else if(this.posx == pos.posx){
            if(this.posy > pos.posy){
                return 1;
            }
        }
        return -1;
    }
}

public class Backjoon11650 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Position> positionList = new ArrayList<>();

        int size = sc.nextInt();

        for(int i = 0; i<size; i++){
           int posx = sc.nextInt();
           int posy = sc.nextInt();

           positionList.add(new Position(posx, posy));
        }
        sc.close();

        Collections.sort(positionList);

        for(int i = 0; i<size; i++){
            System.out.println(positionList.get(i).posx+" "+positionList.get(i).posy);
        }
    }
}
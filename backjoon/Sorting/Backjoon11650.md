# 백준 11650번 문제 좌표 정렬하기

## 개요
* 2차원 평면위에 점 N개 (N <= 100000)가 주어질 때 x좌표가 증가하는 순으로, x좌표가 같을 시 y좌표가 증가하는순으로
  정렬하는 프로그램

## 풀이
* 1181번과 마찬가지로 x, y가 주어지므로 이를 Position Class로 묶어 그 객체의 참조변수를 정렬하는 방식으로
  접근한다.

* 다만 이번에는 조금 다르게 접근했는데 Comparable interface를 이용한 Collection.sort(List)를 통하여 이를 구현하였다.

<pre>
<code>
class Position implements Comparable<Position>{
    int posx;
    int posy;

    Position(int posx, int posy){
        this.posx = posx;
        this.posy = posy;
    }

    public int compareTo(Position pos){ // Comparable interface의 필수 구현 abstract method
        if(this.posx > pos.posx){ // x 오름차순 정렬
            return 1;
        }
        else if(this.posx == pos.posx){
            if(this.posy > pos.posy){ // y 오름차순 정렬
                return 1;
            }
        }
        return -1;
    }
}
</code>
</pre>

* 해당 Class를 ArrayList로 만들어 Constructor를 통하여 초기화(입력) 후 Collection.sort(List)를 통해
  sorting을 실시하였다.
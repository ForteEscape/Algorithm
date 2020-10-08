# 백준 1712번 문제풀이

* 문제 : 고정 비용 A, 가변 비용 B, 제품의 가격 C가 있을 때 최초로 이익이 발생하는 판매량을 출력

* 풀이
* n개의 제품을 만들 때 발생하는 cost = A + nB
* 손익분기점은 가격 C의 제품을 n개 팔았을 때 n개의 제품을 만들 때 발생하는
<br>코스트보다 커야 하므로 다음과 같은 부등식이 성립해야한다.

<br>
<center>
n*C > A+nB
</center>
<br>

* 이때 저 부등식은 다음과 같이 정리될 수 있다.

<br>
<center>
n*C > A+n*B<br>
n*C - n*B > A<br>
n*(C-B) > A<br>
n > A/(C-B)
</center>
<br>

* 즉 최초로 이익이 발생하는 판매량은 다음의 공식으로 도출될 수 있다.<br>
단 C != B 이고 A/(C-B) > 0 이어야 한다 이 조건을 만족하지 못할 경우에 -1을<br>
리턴하게 된다.
# 1157번 단어 공부 풀이

## 문제 
- 알파벳 대소문자로 된 단어가 주어질 때 이 단어에서 가장 많이 사용된 알파벳이 무었인지 알아내는 프로그램을 작성하라 단 대소문자는 구분하지 않는다.

## 풀이
- 입력받은 string을 한번에 대문자로 변환하는 방법과 하나하나 대소문자를 구분해 해당 알파벳의 갯수를 해아리는 방법이 있다. 필자는 전자를 선택했다.

- 알파벳의 수가 26개이므로 26칸의 배열을 선언한 뒤 string을 모두 대문자로 변환하여 알파벳들을 카운트하는 방식을 사용하였다.

<pre>
<code>

len = strlen(string); // 한번에 초기화

for(int i = 0; i < len; i++){
    int idx = (int)string[i] - 65;
    count[idx]++;
}

</code>
</pre>

- 이후에 최대값과 그 인덱스를 저장한 뒤 최대값이 중복되는 케이스를 검사하기 위해 최대값인 인덱스와 저장된 인덱스를 비교하는 검사를 실시한다.

- 최대값이 하나인 경우에는 언제나 인덱스가 같을 것이므로 다른 경우가 생기면 최대값이 둘 이상인 경우로 간주하고 ?을 출력한다. 그게 아니라면 최대값의 인덱스를 아스키 코드에 대응하여 대문자로 출력한다.

## 주의점
- 문자열의 길이를 구하는 함수인 strlen은 주어진 문자열을 한번은 무조건 훑어야 한다. 따라서 strlen의 시간 복잡도는 O(n)이 되며 n은 문자열의 길이가 된다.

- 따라서 이를 for문 내부에서 사용할 경우 프로그램의 전체 시간 복잡도가 O(n^2)가 된다. 따라서 TOE가 발생한다. 이를 해결하기 위해서는 변수를 선언하여 한번에 초기화하고 그 변수를 계속 사용하는 방식으로 프로그램을 짜야 한다
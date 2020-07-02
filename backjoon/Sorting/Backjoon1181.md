# 백준 1181번 단어 정렬 풀이

* n개의 input words 에 대하여 다음 조건에 따라 정렬하는 프로그램

1. 길이가 짧은 것부터
2. 길이가 같으면 사전 순으로

* 단어와 단어의 길이를 하나의 객체로 묶어놓아 각 기준별로 객체를 정렬하는 방식으로 진행함

<pre>
<code>
class Word{
    String word;
    int word_length;
}
</code>
</pre>

* data input 장소는 Word array인 ```Words[]```로 선정
* 이후 bubble sorting을 실시하였으나 시간초과 (O(N^2)라 input data size가 2만인 경우 4억으로 TO가 걸림)
* 이를 다른 정렬(merge sorting, quick sorting, etc...)로 교체하면 통과 가능할 것 같음

=================================================================================================================================
## 재풀이
* 11650번의 접근 방식을 채택
* class에 Comparable interface를 이용한 Class Word의 ArrayList를 만들어 Collections.sort(List)를 사용하여 정렬함

<pre>
<code>
class Word implements Comparable<Word>{
    String word;
    int word_length;

    Word(String word, int word_length){
        this.word = word;
        this.word_length = word_length;
    }

    public int comareTo(Word word){
        if(this.word_length > word.word_length){ // word의 길이로 정렬
            return 1;
        }
        else if(this.word_length == word.word_length){ // word의 길이가 동일할 시
            if(this.word.compareTo(word.word) > 0){ // word의 사전식 순서로 정렬
                return 1;
            }
        }

        return -1;
    }
}
</code>
</pre>

* 이를 ```List<Word> wordList = new ArrayList<>();```로 선언하여 정렬을 진행함
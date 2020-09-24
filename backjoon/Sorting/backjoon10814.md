# 백준 10814번 나이순 정렬

## 문제
- 사람들의 나이와 이름이 가입한 순서대로 주어질 때 회원들을 나이가 증가하는 순으로 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램 작성

## 풀이
- 사람의 정보가 나이, 이름, 가입한 순서 3가지로 나뉘므로 이를 하나의 자료형으로
통합하기 위해서 struct를 사용한다.

<br>
<pre>
<code>
struct Member{
    int age = 0;
    int order = 0; // 가입한 순서
    char name[101];
}
</code>
</pre>
<br>

- 이러한 구조체를 사용하는 배열을 만들어 입력을 한 뒤 구조체를 정렬하는 방식으로
문제를 풀이한다. 구조체의 정렬엔 라이브러리 함수인 ```qsort()```를 사용하였고
```qsort()``` 인자에 들어가는 ```compare()```함수는 아래와 같이 구현하였다.

<br>

<pre>
<code>
int comparator(const void* front, const void* back){
    Member* member1 = (Member*)front; // casting
    Member* member2 = (Member*)back;

    if(member1->age > member2->age){ // 나이순으로 오름차순 정렬
        return 1;
    }
    else if(member1->age == member2->age){
        if(member1->order > member2->order){ // 나이가 같을시 순서 오름차순
            return 1;
        }
        else{
            return -1;
        }
    }
    else{
        return -1;
    }
}
</code>
</pre>
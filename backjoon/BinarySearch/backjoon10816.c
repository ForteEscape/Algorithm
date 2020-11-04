#include<stdio.h>
#include<stdlib.h>
#pragma warning(disable:4996)

int comparator(const void*, const void*);
int upper_bound(int* arr, int key, int size);
int lower_bound(int* arr, int key, int size);

int main()
{
	int cardSize;
	int findCardSize;
	int lower;
	int upper;

	scanf("%d", &cardSize);
	int* cardArr = (int*)malloc(sizeof(int) * cardSize);

	for (int i = 0; i < cardSize; i++) {
		scanf("%d", &cardArr[i]);
	}
	
	qsort(cardArr, cardSize, sizeof(cardArr[0]), comparator);

	scanf("%d", &findCardSize);
	int* findCardArr = (int*)malloc(sizeof(int) * findCardSize);

	for (int i = 0; i < findCardSize; i++) {
		scanf("%d", &findCardArr[i]);
	}

	for (int i = 0; i < findCardSize; i++) {
		lower = lower_bound(cardArr, findCardArr[i], cardSize);
		upper = upper_bound(cardArr, findCardArr[i], cardSize);

		if (upper == cardSize - 1 && cardArr[cardSize - 1] == findCardArr[i]) {
			upper++;
		}
		printf("%d ", upper - lower);
	}

	free(cardArr);
	free(findCardArr);
}

int lower_bound(int* arr, int key, int size) { // 찾고자 하는 값 이상이 처음 나타나는 위치
	int mid;
	int start, end;

	start = 0;
	end = size - 1;

	while (end > start) {
		mid = (start + end) / 2;
		if (arr[mid] >= key) { // 찾고자 하는 값 이상이 처음 나타나는 분기문
			end = mid;
		}
		else {
			start = mid + 1;
		}
	}

	return end;
}

int upper_bound(int* arr, int key, int size) { // 찾고자 하는 값의 초과값이 처음 나타나는 위치
	int mid;
	int start, end;

	start = 0;
	end = size - 1;

	while (end > start) {
		mid = (start + end) / 2;
		if (arr[mid] > key) {
			end = mid;
		}
		else {
			start = mid + 1;
		}
	}

	return end;
}

int comparator(const void* front, const void* back) {
	int card1 = *(int*)front;
	int card2 = *(int*)back;

	if (card1 > card2) {
		return 1;
	}
	else if (card1 == card2) {
		return 0;
	}
	else return -1;
}
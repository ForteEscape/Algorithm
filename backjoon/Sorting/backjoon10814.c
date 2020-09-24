#include<stdio.h>
#include<stdlib.h>
#pragma warning(disable:4996)

typedef struct Member {
	int age = 0;
	int order = 0;
	char name[101];
};

struct Member list[10000];

int comparator(const void* front, const void* back);

int main() 
{
	int memberNum;

	scanf("%d", &memberNum);

	for (int i = 0; i < memberNum; i++) {
		scanf("%d %s", &list[i].age, &list[i].name);
		list[i].order = i;
	}

	qsort(list, memberNum, sizeof(list[0]), comparator);

	for (int i = 0; i < memberNum; i++) {
		printf("%d %s\n", list[i].age, list[i].name);
	}
}

int comparator(const void* front, const void* back) {
	struct Member* member1 = (Member*)front;
	struct Member* member2 = (Member*)back;

	if (member1->age > member2->age) {
		return 1;
	}
	else if (member1->age == member2->age) {
		if (member1->order > member2->order) {
			return 1;
		}
		else {
			return -1;
		}
	}
	else {
		return -1;
	}
}

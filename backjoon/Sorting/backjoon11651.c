#include<stdio.h>
#include<stdlib.h>
#pragma warning(disable:4996)

struct point {
	int posx;
	int posy;
};

typedef struct point Point;

int comparator(const void* front, const void* back);

int main()
{
	int point_num;

	scanf("%d", &point_num);

	Point* pointArr = (Point*)malloc(sizeof(Point)*point_num);

	if (pointArr == NULL) {
		return 0;
	}
	else {
		for (int i = 0; i < point_num; i++) {
			scanf("%d %d", &pointArr[i].posx, &pointArr[i].posy);
		}

		qsort(pointArr, point_num, sizeof(pointArr[0]), comparator);

		for (int i = 0; i < point_num; i++) {
			printf("%d %d\n", pointArr[i].posx, pointArr[i].posy);
		}

		free(pointArr);
	}
}

int comparator(const void* front, const void* back) {
	Point* temp1 = (Point*)front;
	Point* temp2 = (Point*)back;

	if (temp1->posy > temp2->posy) {
		return 1;
	}
	else if (temp1->posy == temp2->posy) {
		if (temp1->posx > temp2->posx) {
			return 1;
		}
		else return -1;
	}
	else return -1;
}
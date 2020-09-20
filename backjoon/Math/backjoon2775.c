#include<stdio.h>
#pragma warning(disable:4996)

int main() {
	int T;
	int number;
	int floor;
	int room;
	int data[15][15] = { 0, }; // floor, room

	for (int i = 0; i < 15; i++) { // initialize
		data[0][i] = i + 1;
		data[i][0] = 1;
	}

	for (int i = 1; i < 15; i++) {
		for (int j = 1; j < 15; j++) {
			data[i][j] = data[i - 1][j] + data[i][j - 1];
		}
	}

	scanf("%d", &T);

	for (int i = 0; i < T; i++) {
		scanf("%d", &floor);
		scanf("%d", &room);

		printf("%d\n", data[floor][room - 1]);
	}
}
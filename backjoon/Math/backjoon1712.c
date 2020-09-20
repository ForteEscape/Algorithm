#include<stdio.h>
#pragma warning(disable:4996)

int main() {
	int a, b, c;
	int ans;

	scanf("%d %d %d", &a, &b, &c);

	if (b == c) {
		printf("-1\n");
	}
	else {
		ans = (a / (c - b)) + 1;

		if (ans < 0) {
			printf("-1\n");
		}
		else {
			printf("%d", ans);
		}
	}
}
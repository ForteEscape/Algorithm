#include<iostream>
#include<cstdio>
#include<algorithm>
#pragma warning(disable:4996)
using namespace std;

int map[26][26];
int cnt = 0;
int number;
int dirX[4] = { 1, 0, -1, 0 };
int dirY[4] = { 0, 1, 0, -1 };
int a[500];

void dfs(int y, int x);

int main()
{
	cin >> number;

	for (int i = 0; i < number; i++) {
		for (int j = 0; j < number; j++) {
			scanf("%1d", &map[i][j]);
		}
	}

	for (int i = 0; i < number; i++) {
		for (int j = 0; j < number; j++) {
			if (map[i][j] == 1) {
				dfs(i, j);
				cnt++;
			}
		}
	}

	sort(a, a + cnt);
	cout << cnt << endl;

	for (int i = 0; i < cnt; i++) {
		cout << a[i] << endl;
	}
}

void dfs(int y, int x) {
	if (map[y][x] == 0) return;

	map[y][x] = 0;
	a[cnt]++;

	for (int i = 0; i < 4; i++) {
		int dx, dy;

		dx = x + dirX[i];
		dy = y + dirY[i];
		
		if (dx >= 0 && dx < number && dy >= 0 && dy < number) {
			dfs(dy, dx);
		}
	}
}
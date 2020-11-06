#include<iostream>
using namespace std;

void dfs(int **map, int x, int y);
void init(int** arr, int x, int y);
void mapFree(int** map, int y);

int n, m, k;
int moveX[4] = { 0, 1, 0, -1 };
int moveY[4] = { 1, 0, -1, 0 };

int main()
{
	int T;

	cin >> T;

	while (T--) {
		int x, y;
		int cnt = 0;

		cin >> m >> n >> k;
		int** map = new int* [n + 1];

		for (int i = 0; i < n; i++) {
			map[i] = new int[m + 1];
		}

		init(map, m, n);

		for (int i = 0; i < k; i++) {
			cin >> x >> y;
			map[y][x] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					dfs(map, j, i);
					cnt++;
				}
			}
		}

		cout << cnt << endl;

		mapFree(map, n);
	}
}

void dfs(int** map, int x, int y) {
	if (map[y][x] == 0) return;

	map[y][x] = 0;

	for (int i = 0; i < 4; i++) {
		int nextX = x + moveX[i];
		int nextY = y + moveY[i];

		if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n) {
			dfs(map, nextX, nextY);
		}
	}
}

void init(int** arr, int x, int y) {
	for (int i = 0; i < y; i++) {
		for (int j = 0; j < x; j++) {
			arr[i][j] = 0;
		}
	}
}

void mapFree(int** map, int y) {
	for (int i = 0; i < y; i++) {
		delete[] map[i];
	}

	delete[] map;
}
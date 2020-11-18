#include<iostream>
#include<algorithm>
using namespace std;

typedef struct dir {
	int x;
	int y;
}Dir;

int map[101][101] = { 0, };
int area[10001] = { 0, };
Dir direction[4] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
int n, m;
int k;
int cnt = 0;

void map_limit(int startX, int startY, int endX, int endY);
void map_init();
void dfs(int x, int y);

int main()
{
	cin >> m >> n >> k;

	map_init();

	for (int i = 0; i < k; i++) {
		int startX, startY, endX, endY;

		cin >> startX >> startY >> endX >> endY;
		map_limit(startX, startY, endX, endY);
	}

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (map[i][j]) {
				dfs(j, i);
				cnt++;
			}
		}
	}
	sort(area, area + cnt);

	cout << cnt << endl;
	for (int i = 0; i < cnt; i++) {
		cout << area[i] << " ";
	}
}

void dfs(int x, int y) {
	if (map[y][x] == 0) return;

	map[y][x] = 0; // visit
	area[cnt]++;

	for (int i = 0; i < 4; i++) {
		int nextX = x + direction[i].x;
		int nextY = y + direction[i].y;

		if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && map[nextY][nextX] == 1) { // in range and map is not visited
			dfs(nextX, nextY);
		}
	}
}

void map_limit(int startX, int startY, int endX, int endY) {
	for (int i = startY; i < endY; i++) {
		for (int j = startX; j < endX; j++) {
			map[i][j] = 0;
		}
	}
}

void map_init() {
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			map[i][j] = 1;
		}
	}
}
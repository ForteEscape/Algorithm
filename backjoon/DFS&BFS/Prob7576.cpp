#include<iostream>
#include<queue>
using namespace std;

typedef struct dir {
	int x;
	int y;
}Dir;

int map[1001][1001] = { 0, };
int day[1001][1001] = { 0, };
bool visit[1001][1001] = { 0, };
queue<pair<int, int>>q;
bool isBfs = false;
bool isAns = false;
int res = 0;
int width, height;
int tomat_cnt = 0;
Dir direction[4] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

bool chk_tomat();
bool inBox(int x, int y);
void bfs();

int main()
{
	cin >> width >> height;
	tomat_cnt = width * height;

	for (int i = 0; i < height; i++) {
		for (int j = 0; j < width; j++) {
			cin >> map[i][j];
			if (map[i][j] == -1) tomat_cnt--;
		}
	}

	for (int i = 0; i < height; i++) {
		for (int j = 0; j < width; j++) {
			if (map[i][j] == 1) {
				q.push(make_pair(j, i));
			}
		}
	}

	bfs();

	if (isAns) {
		cout << res << endl;
	}
	else {
		cout << "-1" << endl;
	}
}

void bfs() {
	int x = 0, y = 0;

	while (!q.empty()) {
		x = q.front().first;
		y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nextX = x + direction[i].x;
			int nextY = y + direction[i].y;

			if (inBox(nextX, nextY) && map[nextY][nextX] == 0) {
				map[nextY][nextX] = 1;
				day[nextY][nextX] = day[y][x] + 1;
				q.push(make_pair(nextX, nextY));
			}
		}
	}

	if (chk_tomat()) {
		res = day[y][x];
		isAns = true;
		return;
	}
}

bool inBox(int x, int y) {
	if (x >= 0 && x < width && y >= 0 && y < height) {
		return true;
	}
	return false;
}

bool chk_tomat() {
	int reap_tomat = 0;

	for (int i = 0; i < height; i++) {
		for (int j = 0; j < width; j++) {
			if (map[i][j] == 1) {
				reap_tomat++;
			}
		}
	}
	return (reap_tomat == tomat_cnt);
}
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int coinNum, goal;
int cnt = 0;
 vector<int>coin;

 void greedy();

int main()
{
	int value;
	cin >> coinNum >> goal;

	for (int i = 0; i < coinNum; i++) {
		cin >> value;

		coin.push_back(value);
	}

	greedy();

	cout << cnt << endl;
}

void greedy() {
	int goalValue = goal;
	
	while (goalValue > 0) {
		int idx = upper_bound(coin.begin(), coin.end(), goalValue) - coin.begin();

		if (idx == 0) {
			goalValue -= coin[idx];
			cnt++;
		}
		else {
			goalValue -= coin[idx - 1];
			cnt++;
		}
	}
}

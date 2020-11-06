#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

void dfs(int start, vector<int>graph[], bool chk[]);

int infest = 0;

int main()
{
	int number;
	int linked_num;

	cin >> number;
	cin >> linked_num;

	vector<int>* graph = new vector<int>[number + 1];
	bool* chk = new bool[number + 1];
	fill(chk, chk + number + 1, false);

	for (int i = 0; i < linked_num; i++) {
		int node, edge;
		cin >> node >> edge;

		graph[node].push_back(edge);
		graph[edge].push_back(node);
	}

	for (int i = 0; i < number; i++) {
		sort(graph[i].begin(), graph[i].end());
	}

	dfs(1, graph, chk);

	cout << infest << endl;
}

void dfs(int start, vector<int>graph[], bool chk[]) {
	chk[start] = true; // visited

	for (int i = 0; i < graph[start].size(); i++) {
		int next = graph[start][i];

		if (chk[next] == false) {
			infest++;
			dfs(next, graph, chk);
		}
	}
}
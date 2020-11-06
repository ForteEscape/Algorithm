#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

void DFS(int start, vector<int>graph[], bool chk[]);

int main()
{
	int nodeNum;
	int edgeNum;
	int nodeStart;

	cin >> nodeNum >> edgeNum >> nodeStart;

	vector<int>* graph = new vector<int>[nodeNum + 1];
	
	bool* chk = new bool[nodeNum + 1];
	fill(chk, chk + nodeNum + 1, false);

	for (int i = 0; i < edgeNum; i++) {
		int node, edge;
		cin >> node >> edge;

		graph[node].push_back(edge);
		graph[edge].push_back(node);
	}

	for (int i = 1; i <= nodeNum; i++) {
		sort(graph[i].begin(), graph[i].end());
	}

	DFS(nodeStart, graph, chk);
	cout << "\n";
}

void DFS(int start, vector<int>graph[], bool chk[]) {
	chk[start] = true;

	cout << start << " ";

	for (int i = 0; i < graph[start].size(); i++) {
		int next = graph[start][i];
		if (chk[next] != true) {
			DFS(next, graph, chk);
		}
	}
}

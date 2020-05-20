package Algorithm.Alg2020.Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

    private int V;
    private LinkedList<Integer> adj[]; // 인접 리스트

    BFS(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i<v; ++i){ // 인접 리스트로 초기화
            adj[i] = new LinkedList();
        }
    }

    // node를 연결 v->w
    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void bfs(int s){
        int[] visited = new int[V]; // visited check
        
        LinkedList<Integer> queue = new LinkedList<Integer>(); // make queue
        
        for(int i = 0; i<visited.length; i++){
            visited[i] = -1; // distance
        }

        queue.add(s); // Enqueue s

        while(queue.size() != 0){
            s = queue.poll();    // dequeue s
            System.out.println(s + " ");

            // 방문한 노드와 인접한 모든 노드를 가져온다.
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()){
                int n = i.next();

                if(visited[n] == -1){
                    visited[n] = visited[s] + 1;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args){
        BFS bfs = new BFS(4);

        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);

        bfs.bfs(2);
    }

    
}